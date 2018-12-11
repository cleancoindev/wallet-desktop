package com.credits.wallet.desktop;

import com.credits.client.node.service.NodeApiService;
import com.credits.client.node.service.NodeApiServiceImpl;
import com.credits.client.node.service.NodeThriftApiClient;
import com.credits.client.node.util.ObjectKeeper;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import static com.credits.wallet.desktop.AppState.account;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.when;

public class SaveNodeApiQueriesTest {

    WalettApp walettApp;
    @Mock
    AppStateInitializer mockInitializer;
    @Mock
    NodeApiServiceImpl mockNodeApiService;

    ObjectKeeper getWalletIdKeeper;

    static AtomicInteger walletId = new AtomicInteger(0);
    static AtomicInteger smartContractTransactionId = new AtomicInteger(0);
    static AtomicInteger transactionId = new AtomicInteger(0);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        doCallRealMethod().when(mockInitializer).loadProperties();
        doCallRealMethod().when(mockInitializer).initializeContractInteractionService();
        doCallRealMethod().when(mockInitializer).initializeContractExecutorApiService();
        mockNodeApiService.nodeClient = NodeThriftApiClient.getInstance("127.0.0.1", 9090);
        when(mockInitializer.initializeNodeApiService()).thenReturn(mockNodeApiService);
        doCallRealMethod().when(mockInitializer).init();
        account = "5B3YXqDTcWQFGAqEJQJP3Bg1ZK8FFtHtgCiFLT5VAxpe";

    }

    @Ignore
    @Test
    public void serializeNodeApiQueries() throws Exception {

        doAnswer(InvocationOnMock::callRealMethod).when(mockNodeApiService).getBalance(any());
        doAnswer(InvocationOnMock::callRealMethod).when(mockNodeApiService).getBalance(any());
        doAnswer(InvocationOnMock::callRealMethod).when(mockNodeApiService).getSmartContract(any());
        doAnswer(InvocationOnMock::callRealMethod).when(mockNodeApiService).getSmartContractAddresses(any());
        doAnswer(InvocationOnMock::callRealMethod).when(mockNodeApiService).getTransaction(any());
        doAnswer(InvocationOnMock::callRealMethod).when(mockNodeApiService).getSmartContracts(any());
        doAnswer(InvocationOnMock::callRealMethod).when(mockNodeApiService).getTransactionsState(any(),any());
        doAnswer(InvocationOnMock::callRealMethod).when(mockNodeApiService).getWalletId(any());
        doAnswer(InvocationOnMock::callRealMethod).when(mockNodeApiService).getWalletTransactionsCount(any());
        doAnswer(InvocationOnMock::callRealMethod).when(mockNodeApiService).getWalletId(any());

        doAnswer(invocation -> beforeInvokeLogic(invocation,"transaction", transactionId)).when(mockNodeApiService).transactionFlow(any());
        doAnswer(invocation -> beforeInvokeLogic(invocation,"smartTransaction", smartContractTransactionId)).when(mockNodeApiService).smartContractTransactionFlow(any());

        NodeApiService mock = mockNodeApiService;

        walettApp = new WalettApp();
        walettApp.appStateInitializer = mockInitializer;
        mockInitializer.startForm = VistaNavigator.WELCOME;
        runApp();
    }

    private Object beforeInvokeLogic(InvocationOnMock invocation, String objectName, AtomicInteger idKeeper) throws Throwable {
        System.out.println("save object" + objectName);
        System.out.println(invocation.getArguments());
        String path = ".." + File.separator + ".." + File.separator + ".." + File.separator + "cache" + File.separator + "test" + File.separator + account + File.separator;
        getWalletIdKeeper = new ObjectKeeper<>(account, path + objectName + idKeeper.getAndIncrement() + ".ser");
        getWalletIdKeeper.keepObject(invocation.getArguments());
        getWalletIdKeeper.flush();
        return invocation.callRealMethod();
    }

    private void runApp() throws InterruptedException {
        new JFXPanel();
        Platform.runLater(() -> {
            try {
                walettApp.start(new Stage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Thread.currentThread().join();
    }

}
