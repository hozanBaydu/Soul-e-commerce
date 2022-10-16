package com.hozanbaydu.soul

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hozanbaydu.soul.databinding.ActivityAppBinding
import com.hozanbaydu.soul.databinding.ActivityMainBinding

class AppActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAppBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }


    fun back(view: View){

        val intent=Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()


    }
}