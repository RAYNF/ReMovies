package com.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(
    entities = [com.data.source.local.entity.MovieEntity::class],
    version = 1,
    exportSchema = false
)


abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
}