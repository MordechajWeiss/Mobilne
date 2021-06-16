package com.example.mobilne

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [(NumberEnt::class)],version=1)
abstract class NumberDatabase : RoomDatabase(){
    abstract fun NumberDAO() : NumberDAO
}