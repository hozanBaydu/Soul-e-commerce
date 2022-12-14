package com.hozanbaydu.soul.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.hozanbaydu.soul.R
import com.hozanbaydu.soul.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap


        val soul = LatLng(41.04402, 29.00364)
        mMap.addMarker(MarkerOptions().position(soul).title("Soul Asian Street Food").infoWindowAnchor(1f,1f))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(soul,20f))
    }

    fun mapBack(view: View){
        val intent= Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}