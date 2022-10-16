package com.hozanbaydu.soul.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
class FoodsModel (@ColumnInfo(name="name")
                  var name:String,

                  @ColumnInfo(name = "details")
                  var details:String,

                  @ColumnInfo(name = "image")
                  var image:Int
){

    @PrimaryKey(autoGenerate = true)
    var id=0
}