package com.example.mobilne

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SimpleXOXOEntDAO {
    @Query("delete from 'simpleXOXOtable'")
    fun delete()

    @Insert
    fun insertAll(vararg data1 : SimpleXOXOEnt)

    @Query("select * from simpleXOXOtable")
    fun getAll() : List<SimpleXOXOEnt>

    @Query("select * from simplexoxotable order by id DESC limit 1")
    fun getLast() : SimpleXOXOEnt
}