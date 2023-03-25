package com.example.bitfitpart1

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface RowDao {
    @Query("SELECT * FROM row")
    fun getAll(): List<Row>

    @Insert
    fun insertAll(vararg flashcards: Row)

    @Delete
    fun delete(flashcard: Row)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(flashcard: Row)
}