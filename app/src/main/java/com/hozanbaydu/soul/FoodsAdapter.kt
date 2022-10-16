package com.hozanbaydu.soul


import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

import com.hozanbaydu.soul.databinding.RecyclerRowBinding
import com.hozanbaydu.soul.model.FoodsModel
import com.hozanbaydu.soul.view.MainFragmentDirections
import kotlinx.android.synthetic.main.recycler_row.view.*

class FoodsAdapter (val artList:MutableList<FoodsModel>): RecyclerView.Adapter<FoodsAdapter.FoodsHolder>(),
    FoodsClickListener {

    lateinit var sharedPreferences: SharedPreferences

    class FoodsHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodsHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodsHolder(binding)




    }


    override fun onBindViewHolder(holder: FoodsHolder, position: Int) {

        holder.binding.foodsModel=artList[holder.absoluteAdapterPosition]
        holder.binding.listener=this


        holder.binding.imageButton3.setOnClickListener {


            val name =artList.get(position).name
            val itemPosition=position.toString()
            Toast.makeText(holder.binding.root.context,name+" Sepetten çıkarıldı.",Toast.LENGTH_SHORT).show()


            sharedPreferences=holder.binding.root.context.getSharedPreferences("com.hojo.kotlin",Context.MODE_PRIVATE)
            sharedPreferences.edit().putBoolean(itemPosition,false).apply()







        }


        holder.binding.imageButton2.setOnClickListener {
            val a =artList.get(position).name
            val itemPosition=position.toString()

            Toast.makeText(holder.binding.root.context,a+" Sepete eklendi.",Toast.LENGTH_SHORT).show()

            sharedPreferences=holder.binding.root.context.getSharedPreferences("com.hojo.kotlin",Context.MODE_PRIVATE)
            sharedPreferences.edit().putBoolean(itemPosition,true).apply()




        }







    }



    override fun getItemCount(): Int {
        return artList.size
    }

    override fun onFoodClick(v:View) {
        val uuid =v.textid.text.toString().toInt()

        val action=MainFragmentDirections.actionMainFragmentToFoodDetailsFragment(uuid = uuid)
        Navigation.findNavController(v).navigate(action)



    }



}

