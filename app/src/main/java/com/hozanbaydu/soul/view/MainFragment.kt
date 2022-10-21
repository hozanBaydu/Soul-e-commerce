package com.hozanbaydu.soul.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.hozanbaydu.soul.R
import com.hozanbaydu.soul.databinding.FragmentMainBinding
import com.hozanbaydu.soul.FoodsAdapter
import com.hozanbaydu.soul.model.FoodsDao
import com.hozanbaydu.soul.model.FoodsDataBase
import com.hozanbaydu.soul.model.FoodsModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private var compositeDisposable= CompositeDisposable()
    private lateinit var dp:FoodsDataBase
    private lateinit var foodDao:FoodsDao
    lateinit var sharedPreferences: SharedPreferences
    var runnable:Runnable=Runnable{}
    var handler:Handler= Handler(Looper.getMainLooper())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dp=Room.databaseBuilder(requireActivity().applicationContext,FoodsDataBase::class.java,"FoodsModel").build()
        foodDao=dp.FoodDao()

        compositeDisposable.add(
            foodDao.deleteAllFood()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()

        )


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val etliMakarnaKavurmasiDetails="El yapımı erişte, dana eti, kırmızı biber, yeşil biber, yeşil soğan, sarımsak, zencefil, özel baharat karışımı"
        val etliMakarnaKavurmasi=FoodsModel("etliMakarnaKavurmasi",etliMakarnaKavurmasiDetails,
            R.drawable.etlimakarnakavurmasi
        )

        val tavukluMakarnaKavurmasiDetails="El yapımı erişte, tavuk eti, kırmızı biber, yeşil biber, yeşil soğan, sarımsak, zencefil, özel baharat karışımı"
        val tavukluMakarnaKavurmasi=FoodsModel("tavukluMakarnaKavurması",tavukluMakarnaKavurmasiDetails,
            R.drawable.tavuklumakarnakavurmasi
        )

        val sebzeliMakarnaKavurmasiDetails="El yapımı erişte, kırmızı biber, yeşil biber, yeşil soğan, sarımsak, zencefil, özel baharat karışımı"
        val sebzeliMakarnaKavurmasi=FoodsModel("sebzeli Makarna Kavurmasi",sebzeliMakarnaKavurmasiDetails,
            R.drawable.sebzelimakarnakavurmasi
        )

        val kungpaoDetails="Pirinç pilav, tavuk göğsü, kırmızı biber, Yeşil biber, Yeşil soğan, Salatalık, Yer fıstığı, özel baharat karışımı"
        val kungpao=FoodsModel("kungpao",kungpaoDetails, R.drawable.kungpao)

        val gyozaDetails="Elle Açılmış yufka, Dana kıyma, özel baharat karışımı"
        val gyoza=FoodsModel("Gyoza",gyozaDetails, R.drawable.gyoza)

        val rabokkiDetails="Pirinç keki"
        val rabokki=FoodsModel("Rabokki",rabokkiDetails, R.drawable.rabokki)

        val citirKanat=FoodsModel("Çıtır Kanat","", R.drawable.citirkanat)

        val kemiksizcitir=FoodsModel("Kemiksiz Çıtır","", R.drawable.kemiksizcitir)

        val generaltso=FoodsModel("General Tso","", R.drawable.generaltso)

        val ramen=FoodsModel("Ramen","", R.drawable.ramen)

        val bibimbap=FoodsModel("Bibimbap","", R.drawable.bibimbap)

        val mandu=FoodsModel("Mandu","", R.drawable.mandu)

        val kimchi=FoodsModel("Kimchi","", R.drawable.soul)

        val kokakola=FoodsModel("kokakola","", R.drawable.soul)

        val kokakolazero=FoodsModel("Kokakola-Zero","", R.drawable.soul)

        val sprite=FoodsModel("Sprite","", R.drawable.soul)

        val fanta=FoodsModel("Fanta","", R.drawable.soul)

        val soda=FoodsModel("Soda","", R.drawable.soul)

        val su=FoodsModel("Su","", R.drawable.soul)


        compositeDisposable.add(
            foodDao.insert(etliMakarnaKavurmasi,tavukluMakarnaKavurmasi,sebzeliMakarnaKavurmasi,kungpao,gyoza,rabokki,citirKanat
                ,kemiksizcitir,generaltso,ramen,bibimbap,mandu,kimchi,kokakola,kokakolazero,sprite,fanta,soda,su) //place daoya veri ekler.
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse1)

        )

        compositeDisposable.add(

            foodDao.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse)
        )

        println("4")

        sharedPreferences=requireContext().getSharedPreferences("com.hojo.kotlin",
            Context.MODE_PRIVATE)

        runnable=object :Runnable{

            override fun run() {
                binding.displayScreen.text=""


                val food1=sharedPreferences.getBoolean("0",false)    //we get this value from the FoodsAdapter.

                if (food1==true) {
                    binding.displayScreen.text="etli makarna, "
                }else{
                    binding.displayScreen.text=""
                }

                val food2=sharedPreferences.getBoolean("1",false)

                if (food2==true) {
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+"Tavuklu makarna, "
                }else{
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+""
                }
                val food3=sharedPreferences.getBoolean("2",false)

                if (food3==true) {
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+"Sebzeli makarna, "
                }else{
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+""
                }
                val food4=sharedPreferences.getBoolean("3",false)

                if (food4==true) {
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+"KungPao, "
                }else{
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+""
                }

                val food5=sharedPreferences.getBoolean("4",false)
                if (food5==true) {
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+"Gyoza, "
                }else{
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+""
                }
                val food6=sharedPreferences.getBoolean("5",false)
                if (food6==true) {
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+"Rabokki, "
                }else{
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+""
                }
                val food7=sharedPreferences.getBoolean("6",false)

                if (food7==true) {
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+"Çıtır kanat, "
                }else{
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+""
                }
                val food8=sharedPreferences.getBoolean("7",false)

                if (food8==true) {
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+"Kemiksiz çıtır, "
                }else{
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+""
                }
                val food9=sharedPreferences.getBoolean("8",false)

                if (food9==true) {
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+"General Tso, "
                }else{
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+""
                }
                val food10=sharedPreferences.getBoolean("9",false)

                if (food10==true) {
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+"Ramen, "
                }else{
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+""
                }
                val food11=sharedPreferences.getBoolean("10",false)

                if (food11==true) {
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+"Bibimbap, "
                }else{
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+""
                }
                val food12=sharedPreferences.getBoolean("11",false)

                if (food12==true) {
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+"Mandu, "
                }else{
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+""
                }
                val food13=sharedPreferences.getBoolean("12",false)

                if (food13==true) {
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+"Kimchi, "
                }else{
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+""
                }
                val food14=sharedPreferences.getBoolean("13",false)

                if (food14==true) {
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+"Koka-kola, "
                }else{
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+""
                }
                val food15=sharedPreferences.getBoolean("14",false)

                if (food15==true) {
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+"Koka-kola zero,"
                }else{
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+""
                }
                val food16=sharedPreferences.getBoolean("15",false)

                if (food16==true) {
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+"Sprite, "
                }else{
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+""
                }
                val food17=sharedPreferences.getBoolean("16",false)

                if (food17==true) {
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+"Fanta,"
                }else{
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+""
                }
                val food18=sharedPreferences.getBoolean("17",false)

                if (food18==true) {
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+"Soda, "
                }else{
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+""
                }
                val food19=sharedPreferences.getBoolean("18",false)

                if (food19==true) {
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+"Su "
                }else{
                    val a =binding.displayScreen.text.toString()
                    binding.displayScreen.text=a+""
                }


                handler.postDelayed(this,1000)
                }
            }
        handler.post(runnable)

        binding.floatingActionButton3.setOnClickListener {


            val action=MainFragmentDirections.actionMainFragmentToOrderFragment()
            findNavController(it).navigate(action)

        }





    }

    private fun handleResponse (list: MutableList<FoodsModel>){


        binding.recyclerview.layoutManager=LinearLayoutManager(requireContext())
        val foodsAdapter= FoodsAdapter(list)
        binding.recyclerview.adapter=foodsAdapter

        println("3")

    }
    private fun handleResponse1 (){

    }


    override fun onDestroyView() {

        handler.removeCallbacks(runnable) //If we do not close the runnable, the app crashes when the fragment is destroyed due to binding.
        _binding = null
        compositeDisposable.clear()  //We clear the compositeDisposable to use the memory more efficiently.
        super.onDestroyView()

    }
}