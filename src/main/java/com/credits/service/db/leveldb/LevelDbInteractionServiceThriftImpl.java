package com.credits.service.db.leveldb;

import com.credits.common.exception.CreditsCommonException;
import com.credits.common.utils.Base58;
import com.credits.leveldb.client.ApiClient;
import com.credits.leveldb.client.data.CreateTransactionData;
import com.credits.leveldb.client.data.PoolData;
import com.credits.leveldb.client.data.TransactionData;
import com.credits.leveldb.client.data.TransactionIdData;
import com.credits.leveldb.client.exception.CreditsNodeException;
import com.credits.leveldb.client.exception.LevelDbClientException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Component
public class LevelDbInteractionServiceThriftImpl implements LevelDbInteractionService {

    private ApiClient client;

    @Value("${api.server.host}")
    private String apiServerHost;

    @Value("${api.server.port}")
    private Integer apiServerPort;

    @PostConstruct
    public void setUp() {
        client = ApiClient.getInstance(apiServerHost, apiServerPort);
    }


    @Override
    public BigDecimal getBalance(String address, byte currency)
        throws LevelDbClientException, CreditsNodeException, CreditsCommonException {
        return client.getBalance(Base58.decode(address));
    }

    @Override
    public TransactionData getTransaction(String transactionId) throws LevelDbClientException, CreditsNodeException {
        //TODO need add adapter from String to TransactionIdData
        return client.getTransaction(new TransactionIdData());
    }

    @Override
    public List<TransactionData> getTransactions(String address, long offset, long limit)
        throws LevelDbClientException, CreditsNodeException, CreditsCommonException {
        return client.getTransactions(Base58.decode(address), offset, limit);
    }

    @Override
    public List<PoolData> getPoolList(long offset, long limit) throws LevelDbClientException, CreditsNodeException {
        return client.getPoolList(offset, limit);
    }

    @Override
    public PoolData getPoolInfo(byte[] hash, long index) throws LevelDbClientException, CreditsNodeException {
        return client.getPoolInfo(hash, index);
    }

    @Override
    public void transactionFlow(Long innerId, String source, String target, BigDecimal amount, BigDecimal balance,
        byte currency, byte[] signature, BigDecimal fee)
        throws LevelDbClientException, CreditsNodeException, CreditsCommonException {
        CreateTransactionData CreateTransactionData =
            new CreateTransactionData(new Random().nextLong(), Base58.decode(source), Base58.decode(target), amount,
                balance, currency, fee, signature); client.createTransaction(CreateTransactionData, true);
    }
}
