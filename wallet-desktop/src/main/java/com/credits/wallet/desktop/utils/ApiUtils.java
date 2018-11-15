package com.credits.wallet.desktop.utils;

import com.credits.client.node.exception.NodeClientException;
import com.credits.client.node.pojo.SmartContractInvocationData;
import com.credits.client.node.pojo.SmartContractTransactionFlowData;
import com.credits.client.node.pojo.TransactionFlowData;
import com.credits.client.node.pojo.TransactionFlowResultData;
import com.credits.client.node.service.NodeApiServiceImpl;
import com.credits.client.node.util.NodePojoConverter;
import com.credits.general.pojo.ApiResponseData;
import com.credits.general.pojo.SmartContractData;
import com.credits.general.pojo.TransactionRoundData;
import com.credits.general.util.exception.ConverterException;
import com.credits.wallet.desktop.AppState;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.credits.client.node.util.NodeClientUtils.serializeByThrift;
import static com.credits.wallet.desktop.AppState.nodeApiService;
import static com.credits.wallet.desktop.AppState.transactionOfferedMaxFeeValue;
import static java.math.BigDecimal.ZERO;

/**
 * Created by Rustem Saidaliyev on 20-Mar-18.
 */
public class ApiUtils {

    private final static Logger LOGGER = LoggerFactory.getLogger(ApiUtils.class);

    public static Pair<Long, TransactionFlowResultData> createTransaction(
        TransactionIdCalculateUtils.CalcTransactionIdSourceTargetResult transactionData, BigDecimal amount)
        throws NodeClientException, ConverterException {
        return Pair.of(transactionData.getTransactionId(), nodeApiService.transactionFlow(getTransactionFlowData(transactionData, amount, null)));
    }

    public static Pair<Long, TransactionFlowResultData> createSmartContractTransaction(
        TransactionIdCalculateUtils.CalcTransactionIdSourceTargetResult transactionData,
        SmartContractData smartContractData) throws NodeClientException, ConverterException {

        SmartContractInvocationData smartContractInvocationData =
            new SmartContractInvocationData(smartContractData.getSmartContractDeployData(),
                    smartContractData.getMethod(), smartContractData.getParams(), false);

        SmartContractTransactionFlowData scData = new SmartContractTransactionFlowData(
            getTransactionFlowData(transactionData, ZERO, serializeByThrift(smartContractInvocationData)),
            smartContractInvocationData);

        return Pair.of(transactionData.getTransactionId(), nodeApiService.smartContractTransactionFlow(scData));
    }

    private static TransactionFlowData getTransactionFlowData(
        TransactionIdCalculateUtils.CalcTransactionIdSourceTargetResult transactionData, BigDecimal amount,
        byte[] smartContractBytes) {
        long id = transactionData.getTransactionId();
        byte[] source = transactionData.getByteSource();
        byte[] target = transactionData.getByteTarget();
        short offeredMaxFee = transactionOfferedMaxFeeValue;
        byte currency = 1;

        saveTransactionIntoMap(transactionData, amount.toString(), String.valueOf(currency));

        TransactionFlowData transactionFlowData =
            new TransactionFlowData(id, source, target, amount, offeredMaxFee, currency, smartContractBytes, null /*TODO refactor, add or not add userFields*/);
        SignUtils.signTransaction(transactionFlowData);
        return transactionFlowData;
    }


    private static void saveTransactionIntoMap(
        TransactionIdCalculateUtils.CalcTransactionIdSourceTargetResult transactionData, String amount,
        String currency) {
        AppState.sourceMap.computeIfAbsent(AppState.account, key -> new ConcurrentHashMap<>());
        Map<Long, TransactionRoundData> sourceMap = AppState.sourceMap.get(AppState.account);
        long shortTransactionId = NodePojoConverter.getShortTransactionId(transactionData.getTransactionId());
        TransactionRoundData transactionRoundData =
            new TransactionRoundData(String.valueOf(shortTransactionId), transactionData.getWideSource(),
                transactionData.getWideTarget(), amount, currency);
        sourceMap.put(shortTransactionId, transactionRoundData);
    }

    public static void saveTransactionRoundNumberIntoMap(int roundNumber, long transactionId) {
        ConcurrentHashMap<Long, TransactionRoundData> tempTransactionsData =
            AppState.sourceMap.get(NodeApiServiceImpl.account);
        TransactionRoundData transactionRoundData =
            tempTransactionsData.get(NodePojoConverter.getShortTransactionId(transactionId));
        transactionRoundData.setRoundNumber(roundNumber);
    }

}