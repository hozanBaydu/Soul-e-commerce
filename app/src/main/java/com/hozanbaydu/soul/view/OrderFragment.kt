package com.hozanbaydu.soul.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.hozanbaydu.soul.databinding.FragmentOrderBinding



class OrderFragment : Fragment() {
    private var _binding: FragmentOrderBinding? = null
    private val binding get() = _binding!!
    val Fragment.packageManager get() = activity?.packageManager//Fragmentte packageManagera ulaşmak için.
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toast.makeText(context,"Sipariş vermek istediğiniz yemek sayısını değiştirmek  için lütfen yemeğin karşısındaki rakamı değiştirin",
            Toast.LENGTH_LONG).show()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        val view = binding.root
        return view


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences=requireContext().getSharedPreferences("com.hojo.kotlin",
            Context.MODE_PRIVATE)

        val food1=sharedPreferences.getBoolean("0",false)

        if (food1==true) {
            binding.etliLayout.visibility=View.VISIBLE
        }else{
            binding.etliLayout.visibility=View.GONE
        }


        val food2=sharedPreferences.getBoolean("1",false)

        if (food2==true) {
            binding.tavukluLayout.visibility=View.VISIBLE
        }else{
            binding.tavukluLayout.visibility=View.GONE
        }


        val food3=sharedPreferences.getBoolean("2",false)

        if (food3==true) {
            binding.sebzeliLayout.visibility=View.VISIBLE
        }else{
            binding.sebzeliLayout.visibility=View.GONE
        }


        val food4=sharedPreferences.getBoolean("3",false)

        if (food4==true) {
            binding.kungpaoLayout.visibility=View.VISIBLE
        }else{
            binding.kungpaoLayout.visibility=View.GONE
        }


        val food5=sharedPreferences.getBoolean("4",false)

        if (food5==true) {
            binding.gyozaLayout.visibility=View.VISIBLE
        }else{
            binding.gyozaLayout.visibility=View.GONE
        }


        val food6=sharedPreferences.getBoolean("5",false)

        if (food6==true) {
            binding.rabokkiLayout.visibility=View.VISIBLE
        }else{
            binding.rabokkiLayout.visibility=View.GONE
        }


        val food7=sharedPreferences.getBoolean("6",false)

        if (food7==true) {
            binding.citirkanatLayout.visibility=View.VISIBLE
        }else{
            binding.citirkanatLayout.visibility=View.GONE
        }


        val food8=sharedPreferences.getBoolean("7",false)

        if (food8==true) {
            binding.kemiksizcitirLayout.visibility=View.VISIBLE
        }else{
            binding.kemiksizcitirLayout.visibility=View.GONE
        }


        val food9=sharedPreferences.getBoolean("8",false)

        if (food9==true) {
            binding.generaltsoLayout.visibility=View.VISIBLE
        }else{
            binding.generaltsoLayout.visibility=View.GONE
        }


        val food10=sharedPreferences.getBoolean("9",false)

        if (food10==true) {
            binding.ramenLayout.visibility=View.VISIBLE
        }else{
            binding.ramenLayout.visibility=View.GONE
        }


        val food11=sharedPreferences.getBoolean("10",false)

        if (food11==true) {
            binding.bibimbapLayout.visibility=View.VISIBLE
        }else{
            binding.bibimbapLayout.visibility=View.GONE
        }


        val food12=sharedPreferences.getBoolean("11",false)

        if (food12==true) {
            binding.manduLayout.visibility=View.VISIBLE
        }else{
            binding.manduLayout.visibility=View.GONE
        }

        val food13=sharedPreferences.getBoolean("12",false)

        if (food13==true) {
            binding.kimchiLayout.visibility=View.VISIBLE
        }else{
            binding.kimchiLayout.visibility=View.GONE
        }


        val food14=sharedPreferences.getBoolean("13",false)

        if (food14==true) {
            binding.kokakolaLayout.visibility=View.VISIBLE
        }else{
            binding.kokakolaLayout.visibility=View.GONE
        }


        val food15=sharedPreferences.getBoolean("14",false)

        if (food15==true) {
            binding.kokakolazeroLayout.visibility=View.VISIBLE
        }else{
            binding.kokakolazeroLayout.visibility=View.GONE
        }


        val food16=sharedPreferences.getBoolean("15",false)

        if (food16==true) {
            binding.spriteLayout.visibility=View.VISIBLE
        }else{
            binding.spriteLayout.visibility=View.GONE
        }


        val food17=sharedPreferences.getBoolean("16",false)

        if (food17==true) {
            binding.fantaLayout.visibility=View.VISIBLE
        }else{
            binding.fantaLayout.visibility=View.GONE
        }


        val food18=sharedPreferences.getBoolean("17",false)

        if (food18==true) {
            binding.sodaLayout.visibility=View.VISIBLE
        }else{
            binding.sodaLayout.visibility=View.GONE
        }


        val food19=sharedPreferences.getBoolean("18",false)

        if (food19==true) {
            println("true")
            binding.suLayout.visibility=View.VISIBLE
        }else{
            binding.suLayout.visibility=View.GONE
        }

        binding.floatingActionButton5.setOnClickListener {

            val etlimakarnaTextConctrol=binding.etlimakarnakavurmasText.text.toString()
            val tavuklumakarnaTextConrol=binding.tavuklumakarnakavurmasText.text.toString()
            val sebzelimakarnaTextControl=binding.tavuklumakarnakavurmasText.text.toString()
            val kungpaoTextControl=binding.kungpaoText.text.toString()
            val gyozaTextControl=binding.gyozaText.text.toString()
            val rabokkiTextControl=binding.rabokkiText.text.toString()
            val citirkanatTextControl=binding.citirkanatText.text.toString()
            val kemiksizcitirTextControl=binding.kemiksizcitirText.text.toString()
            val generaltsoTextControl= binding.generaltsoText.text.toString()
            val ramenTextControl= binding.ramenText.text.toString()
            val bibimbapTextControl=binding.bibimbapText.text.toString()
            val manduTextControl=binding.manduText.text.toString()
            val kimchiTextControl=binding.kimchiText.text.toString()
            val kokakolaTextControl=binding.kokakolaText.text.toString()
            val kokakolazeroTextControl=binding.kokakolazeroText.text.toString()
            val spriteTextControl=binding.spriteText.text.toString()
            val fantaTextControl=binding.fantaText.text.toString()
            val sodaTextControl=binding.sodaText.text.toString()
            val suTextControl=binding.suText.text.toString()


            if (etlimakarnaTextConctrol != "" && tavuklumakarnaTextConrol != "" && sebzelimakarnaTextControl != "" && kungpaoTextControl != ""
                && gyozaTextControl != "" && rabokkiTextControl != "" && citirkanatTextControl != "" && kemiksizcitirTextControl !=""
                && generaltsoTextControl!=""&& ramenTextControl!=""&& bibimbapTextControl!=""&&manduTextControl!=""
                && kimchiTextControl != "" && kokakolaTextControl != "" && kokakolazeroTextControl != "" && spriteTextControl !=""
                && fantaTextControl != "" && sodaTextControl != "" && suTextControl != "" ) {

                var message=""

                if (food1==true) {
                     message =message+
                        "Etli makarna kavurması=" + etlimakarnaTextConctrol + " Tane " + etlimakarnaTextConctrol
                            .toFloat() * 68.5 + "tl - "

                }

                if (food2==true){
                    message =message+
                        "Tavuklu makarna kavurması=" + tavuklumakarnaTextConrol + " Tane " + tavuklumakarnaTextConrol
                            .toFloat() * 58.5 + "tl - "

                }

                if (food3==true){
                    message =message+
                            "Sebzeli makarna kavurması=" + sebzelimakarnaTextControl + " Tane " + sebzelimakarnaTextControl
                        .toFloat() * 54.5 + "tl - "
                }
                if (food4==true){
                    message =message+
                            "Kung pao=" + kungpaoTextControl + " Tane " + kungpaoTextControl
                        .toFloat() * 65.0 + "tl - "
                }
                if (food5==true){
                    message =message+
                            "Gyoza=" + gyozaTextControl + " Tane " + gyozaTextControl
                        .toFloat() * 56.0 + "tl - "
                }
                if (food6==true){
                    message =message+
                            "Rabokki=" + rabokkiTextControl + " Tane " + rabokkiTextControl
                        .toFloat() * 54.5 + "tl - "
                }
                if (food7==true){
                    message =message+
                            "Çıtır kanat=" + citirkanatTextControl + " Tane " + citirkanatTextControl
                        .toFloat()* 58.5 + "tl - "
                }
                if (food8==true){
                    message =message+
                            "Kemiksiz çıtır kanat=" + kemiksizcitirTextControl + " Tane " + kemiksizcitirTextControl
                        .toFloat() * 58.5 + "tl - "
                }
                if (food9==true){
                    message =message+
                            "General Tso=" + generaltsoTextControl + " Tane " + generaltsoTextControl
                        .toFloat() * 70.0 + "tl - "
                }
                if (food10==true){
                    message =message+
                            "Ramen=" + ramenTextControl + " Tane " + ramenTextControl
                        .toFloat()* 58.0 + "tl - "
                }
                if (food11==true){
                    message =message+
                            "Bibimbap=" + bibimbapTextControl + " Tane " + bibimbapTextControl
                        .toFloat() * 65.0 + "tl - "
                }
                if (food12==true){
                    message =message+
                            "Mandu=" + manduTextControl + " Tane " + manduTextControl
                        .toFloat() * 66.0 + "tl - "
                }
                if (food13==true){
                    message =message+
                            "Kimchi=" + kimchiTextControl + " Tane " + kimchiTextControl
                        .toFloat() * 16.0 + "tl - "
                }
                if (food14==true){
                    message =message+
                            "Koka-kola=" + kokakolaTextControl + " Tane " + kokakolaTextControl
                        .toFloat() * 12.0 + "tl - "
                }
                if (food15==true){
                    message =message+
                            "Koka-kola zero=" + kokakolazeroTextControl + " Tane " + kokakolazeroTextControl
                        .toFloat() * 12.0 + "tl - "
                }
                if (food16==true){
                    message =message+
                            "Sprite=" + spriteTextControl + " Tane " + spriteTextControl
                        .toFloat() * 12.0 + "tl - "
                }
                if (food17==true){
                    message =message+
                            "Fanta=" + fantaTextControl + " Tane " + fantaTextControl
                        .toFloat() * 12.0 + "tl - "
                }
                if (food18==true){
                    message =message+
                            "Soda=" + sodaTextControl + " Tane " + sodaTextControl
                        .toFloat() * 6.5 + "tl - "
                }
                if (food19==true){
                    message =message+
                            "Su=" + suTextControl + " Tane " + suTextControl
                        .toFloat() * 4.0 + "tl - "
                }

                sendMessage(message)

            }else{
               Toast.makeText(context,"Lütfen sayıları boş bırakmayın",Toast.LENGTH_SHORT).show()



            }

        }
    }

    fun sendMessage(message:String){

        // Creating intent with action send
        val intent = Intent(Intent.ACTION_VIEW)

        // Setting Intent type
        intent.type = "text/plain"

        // Setting whatsapp package name
        intent.setPackage("com.whatsapp")

        intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=905459301429&text="+message))

        // Give your message here
        intent.putExtra(Intent.EXTRA_TEXT, message)

        // Starting Whatsapp
        startActivity(intent)
    }



}

