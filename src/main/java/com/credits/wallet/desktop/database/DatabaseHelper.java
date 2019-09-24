package com.credits.wallet.desktop.database;

import com.credits.general.exception.CreditsException;
import com.credits.wallet.desktop.database.pojo.SmartContract;
import com.credits.wallet.desktop.database.pojo.Transaction;
import com.credits.wallet.desktop.database.pojo.Wallet;
import com.j256.ormlite.core.dao.Dao;
import com.j256.ormlite.core.support.ConnectionSource;
import com.j256.ormlite.core.table.TableUtils;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static com.credits.wallet.desktop.utils.GeneralUtils.getResourceAsStream;
import static com.j256.ormlite.core.dao.DaoManager.createDao;
import static java.nio.charset.StandardCharsets.UTF_8;

@Slf4j
public class DatabaseHelper {

    private final String databaseUrl;
    private ConnectionSource connectionSource;
    private Dao<SmartContract, Long> smartContractDao;
    private Dao<Wallet, Long> walletDao;
    private Dao<Transaction, Long> transactionDao;

    public DatabaseHelper(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public void connectAndInitialize() {
        try {
            connectionSource = new JdbcConnectionSource(databaseUrl);
            smartContractDao = createDao(connectionSource, SmartContract.class);
            walletDao = createDao(connectionSource, Wallet.class);
            transactionDao = createDao(connectionSource, Transaction.class);

        } catch (SQLException e) {
            log.error("can't connect to database. Reason {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void createTable(Class<?> clazz) throws SQLException {
        TableUtils.createTable(connectionSource, clazz);
    }

    public void keepSmartContract(SmartContract smartContract) throws SQLException {
        smartContractDao.createIfNotExists(smartContract);
    }

    public SmartContract getSmartContract(String address) throws SQLException {
        final var walletAddresses = walletDao.queryForEq("address", address);
        if (walletAddresses.size() == 0) {
            throw new DatabaseHelperException("smart contract with address \"" + address + "\" not found");
        }

        return smartContractDao.queryForId(walletAddresses.get(0).getId());
    }

    public void keepTransaction(Transaction transaction) throws SQLException {
        transactionDao.createIfNotExists(transaction);
    }

    public List<Transaction> getTransactionsByAddress(String address) throws SQLException {
        return getTransactionsByAddress(address, -1L);
    }

    public List<Transaction> getTransactionsByAddress(String address, long limit) throws SQLException {
        final var getWalletQb = walletDao.queryBuilder();
        final var getTransactionQb = transactionDao.queryBuilder();

        getWalletQb.where().eq("address", address);

        return limit > 0
               ? getTransactionQb.leftJoin(getWalletQb).limit(limit).query()
               : getTransactionQb.leftJoin(getWalletQb).query();
    }

    public void createDatabaseSchemeIfNotExist() {
        try (var connection = DriverManager.getConnection(databaseUrl);
             var statement = connection.createStatement()) {
            var sqlFileStream = IOUtils.toString(getResourceAsStream("/sql/create_db.sql"), UTF_8);
            final var sqlRequests = sqlFileStream.split(";");
            for (var sql : sqlRequests) {
                statement.executeUpdate(sql);
            }

        } catch (SQLException | IOException e) {
            log.error("can't create database scheme. Reason {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static class DatabaseHelperException extends CreditsException {

        public DatabaseHelperException(String errorMessage) {
            super(errorMessage);
        }
    }
}
