package com.rk.junittesting.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Quote(@PrimaryKey val id: Int, val quote: String, val author: String)
