package com.example.bitfitpart1

import android.content.Context
import androidx.room.Room

class RowDatabase internal constructor(context: Context) {

    private val db: AppDatabase


    fun getAllCards(): List<Row> {
        return db.rowDao().getAll()
    }

    fun insertCard(flashcard: Row) {
        db.rowDao().insertAll(flashcard)
    }

    fun deleteCard(flashcardQuestion: String) {
        val allCards = db.rowDao().getAll()

    }

    fun updateCard(flashcard: Row) {
        db.rowDao().update(flashcard)
    }

    fun deleteAll() {
        for (flashcard in db.rowDao().getAll()) {
            db.rowDao().delete(flashcard)
        }
    }

    init {
        db = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java, "flashcard-database"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
    }