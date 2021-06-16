package com.example.mobilne

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NumberDAO {
    @Query("delete from 'NumberTable'")
    fun delete()

    @Insert
    fun insertAll(vararg data1 : NumberEnt)

    @Query("select * from NumberTable")
    fun getAll() : List<NumberEnt>


}