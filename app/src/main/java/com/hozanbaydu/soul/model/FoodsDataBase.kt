package com.hozanbaydu.soul.model

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [FoodsModel::class], version = 1)
abstract class FoodsDataBase: RoomDatabase() {

    abstract fun FoodDao(): FoodsDao
}