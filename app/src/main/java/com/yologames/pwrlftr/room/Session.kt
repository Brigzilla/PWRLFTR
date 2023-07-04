package com.yologames.pwrlftr.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(tableName = "session_table")
data class Session(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,


    @ColumnInfo(name = "exercise")
    var exercise: String,

    @ColumnInfo(name = "set0")
    var set_0: String,

    @ColumnInfo(name = "set1")
    var set_1: String,

    @ColumnInfo(name = "set2")
    var set_2: String,

    @ColumnInfo(name = "set3")
    var set_3: String,

    @ColumnInfo(name = "set4")
    var set_4: String,

    @ColumnInfo(name = "set5")
    var set_5: String,

    @ColumnInfo(name = "set6")
    var set_6: String,

    @ColumnInfo(name = "set7")
    var set_7: String,

    @ColumnInfo(name = "set8")
    var set_8: String,

    @ColumnInfo(name = "set9")
    var set_9: String,

    @ColumnInfo(name = "canreview")
    var can_review: Boolean



    )