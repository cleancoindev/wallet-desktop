package com.credits.wallet.desktop.database;

import com.credits.wallet.desktop.database.pojo.SmartContract;
import com.credits.wallet.desktop.database.pojo.Transaction;
import com.credits.wallet.desktop.database.pojo.TransactionType;
import com.credits.wallet.desktop.database.pojo.Wallet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

import static java.nio.file.Files.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DatabaseHelperTest extends DatabaseTest {

    public static final Path dbDir = Paths.get("./testdb");
    public static final Path dbPath = Paths.get(dbDir.toString(), "wallet-cache-test.db");

    @BeforeEach
    void setUp(TestInfo testInfo) throws IOException {
        if (!exists(dbDir)) createDirectory(dbDir);
        db = new DatabaseHelper("jdbc:sqlite:" + dbPath.toString());
        db.connectAndInitialize();
        processingTestAnnotations(testInfo);
    }

    @AfterEach
    void tearDown() throws IOException {
        deleteIfExists(dbPath);
        deleteIfExists(dbDir);
    }

    @Test
    @CreateTables({Wallet.class, SmartContract.class})
    void createTableThenAddAndGetSmartContract() throws SQLException {
        final var wallet = new Wallet("someAddress");
        final var contract = new SmartContract(wallet, "someCode", System.currentTimeMillis());

        db.keepSmartContract(contract);

        final var returnedContract = db.getSmartContract(contract.getWallet().getAddress());

        assertEquals(contract, returnedContract);
    }

    @Test
    @CreateTables({Wallet.class, Transaction.class, TransactionType.class})
    void testingTransactionManipulationMethods() throws SQLException {
        final var address1 = new Wallet("address1");
        final var address2 = new Wallet("address2");
        final var transactionType = new TransactionType();
        final var transaction1 = new Transaction(address1, address2, "1.00", System.currentTimeMillis(), "from address1 to address2", transactionType);
        final var transaction2 = new Transaction(address2, address1, "1.00", System.currentTimeMillis(), "from address2 to address1", transactionType);
        final var transaction3 = new Transaction(address2, address1, "2.00", System.currentTimeMillis(), "from address2 to address1", transactionType);

        db.keepTransaction(transaction1);
        db.keepTransaction(transaction2);
        db.keepTransaction(transaction3);

        final var transactionsFromAddress1 = db.getTransactionsByAddress(address1.getAddress());
        assertEquals(1, transactionsFromAddress1.size());
        assertEquals(transaction1, transactionsFromAddress1.get(0));

        final var transactionsFromAddress2 = db.getTransactionsByAddress(address2.getAddress());
        assertEquals(2, transactionsFromAddress2.size());
        assertEquals(transaction2, transactionsFromAddress2.get(0));
        assertEquals(transaction3, transactionsFromAddress2.get(1));
    }

    @Test
    void createDatabaseSchemeIfNotExist() {
        db.createDatabaseSchemeIfNotExist();
    }
}