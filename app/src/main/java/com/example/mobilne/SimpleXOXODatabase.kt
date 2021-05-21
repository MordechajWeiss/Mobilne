package com.example.mobilne

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [(SimpleXOXOEnt::class)],version=1)
abstract class SimpleXOXODatabase : RoomDatabase(){
    abstract fun SimpleXOXOEntDAO() : SimpleXOXOEntDAO
}