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

    @ColumnInfo(name = "sets")
    var sets: Int,

    @ColumnInfo(name = "reps")
    var reps: Int,

    @ColumnInfo(name = "weight")
    var weight: Int

    )