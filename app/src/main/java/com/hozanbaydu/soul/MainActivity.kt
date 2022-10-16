package com.hozanbaydu.soul

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import com.hozanbaydu.soul.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val buttonAnimation = AnimationUtils.loadAnimation(this, R.anim.buttonanim)
        binding.floatingInfoButton.startAnimation(buttonAnimation)
        binding.floatingMapButton.startAnimation(buttonAnimation)

        val textAnimation = AnimationUtils.loadAnimation(this, R.anim.textanim)
        binding.soulText.startAnimation(textAnimation)

    }

    fun infoButton(view: View){

        val intent=Intent(this,AppActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun mapButton(view: View){
        val intent=Intent(this,MapsActivity::class.java)
        startActivity(intent)
        finish()

    }

}