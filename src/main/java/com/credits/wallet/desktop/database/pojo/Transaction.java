package com.credits.wallet.desktop.database.pojo;

import com.j256.ormlite.core.field.DatabaseField;
import com.j256.ormlite.core.table.DatabaseTable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@DatabaseTable(tableName = "transaction")
public class Transaction {
    @DatabaseField(generatedId = true)
    long id;
    @DatabaseField(columnName = "sender_id", foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    Wallet sender;
    @DatabaseField(columnName = "receiver_id", foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    Wallet receiver;
    @DatabaseField
    String fee;
    @DatabaseField(columnName = "time_stamp")
    long timestamp;
    @DatabaseField(columnName = "user_data")
    String userData;
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = "type")
    TransactionType type;

    public Transaction(Wallet sender,
                       Wallet receiver,
                       String fee,
                       long timestamp,
                       String userData,
                       TransactionType type) {
        this.sender = sender;
        this.receiver = receiver;
        this.fee = fee;
        this.timestamp = timestamp;
        this.userData = userData;
        this.type = type;
    }
}
