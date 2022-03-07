package com.juancho1037.umadefoods.ui.home.cooks_list.local_cooks

import android.widget.ImageView
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.sql.Types.NULL

@Entity(tableName = "table_cooks")
data class Cook(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name="id") val id: Int,
    @ColumnInfo val rank: String,
    @ColumnInfo val cook_name: String,
    @ColumnInfo val food_kind: String,
    @ColumnInfo val location: String,
): Serializable
{
    constructor():this(NULL,"","","","")
}