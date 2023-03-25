package com.example.bitfitpart1

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity("row")
data class Row(@NonNull @PrimaryKey @ColumnInfo("food") val food: String,
               @ColumnInfo("calories") val calories: String)  {
}

