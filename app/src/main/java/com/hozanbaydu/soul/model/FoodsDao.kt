package com.hozanbaydu.soul.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface FoodsDao {

    @Query("SELECT*FROM FoodsModel")
    fun getAll(): Flowable<MutableList<FoodsModel>>

    @Query("SELECT*FROM FoodsModel WHERE id=:id")
    fun getFood(vararg id:Int):Flowable<MutableList<FoodsModel>>

    @Insert
    fun insert (vararg FoodsModel: FoodsModel) : Completable

    @Delete
    fun delete(vararg FoodsModel: FoodsModel) : Completable

    @Query("DELETE  FROM FoodsModel")
    fun deleteAllFood():Completable


}