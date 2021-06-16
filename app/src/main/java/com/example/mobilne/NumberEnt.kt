package com.example.mobilne

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NumberTable")
data class NumberEnt(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name= "move") var move: Int
)