package com.example.mobilne
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SimpleXOXOtable")
data class SimpleXOXOEnt (
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = false) var id : Long ,
    @ColumnInfo(name= "board") var board: String = ""
)