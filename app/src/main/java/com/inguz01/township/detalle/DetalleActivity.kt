package com.inguz01.township.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.inguz01.township.R
import com.inguz01.township.databinding.ActivityDetalleBinding

class DetalleActivity : AppCompatActivity() {

    private lateinit var detalleBinding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(detalleBinding.root)



        val nombre = intent.extras?.getString("nombre")
        detalleBinding.nameTextView.text = nombre

    }


}