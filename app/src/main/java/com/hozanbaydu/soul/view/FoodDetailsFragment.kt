package com.hozanbaydu.soul.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import com.hozanbaydu.soul.databinding.FragmentFoodDetailsBinding
import com.hozanbaydu.soul.model.FoodsDao
import com.hozanbaydu.soul.model.FoodsDataBase
import com.hozanbaydu.soul.model.FoodsModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_food_details.view.*

class FoodDetailsFragment : Fragment() {
    private var _binding: FragmentFoodDetailsBinding? = null
    private val binding get() = _binding!!
    private var compositeDisposable= CompositeDisposable()
    private lateinit var dp: FoodsDataBase
    private lateinit var foodDao: FoodsDao


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dp= Room.databaseBuilder(requireActivity().applicationContext,FoodsDataBase::class.java,"FoodsModel").build()
        foodDao=dp.FoodDao()



        var foodId=FoodDetailsFragmentArgs.fromBundle(bundle = requireArguments()).uuid

        compositeDisposable.add(
            foodDao.getFood(foodId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleDetailsResponse)
        )

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFoodDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

    fun handleDetailsResponse(Food:List<FoodsModel> ){
        var a=Food.get(0)
        binding.textView5.text=a.details
        binding.imageView.setImageResource(a.image)
    }




}