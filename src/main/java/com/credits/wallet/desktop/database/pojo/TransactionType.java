package com.credits.wallet.desktop.database.pojo;

import com.j256.ormlite.core.field.DatabaseField;
import com.j256.ormlite.core.table.DatabaseTable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@DatabaseTable(tableName = "transaction_type")
public class TransactionType {
    @DatabaseField(generatedId = true)
    long  id;

    @DatabaseField
    String type = "unknown";
}
