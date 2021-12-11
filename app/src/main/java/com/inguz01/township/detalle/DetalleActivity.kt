package com.inguz01.township.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.inguz01.township.R
import com.inguz01.township.databinding.ActivityDetalleBinding
import com.inguz01.township.model.TownsItem
import com.squareup.picasso.Picasso

class DetalleActivity : AppCompatActivity() {

    private lateinit var detalleBinding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(detalleBinding.root)



        val town: TownsItem = intent.extras?.getSerializable("town") as TownsItem

        with(detalleBinding) {
            nameTextView.text = town.name
            infoTextView.text = town.info
            tempTextView.text = town.temp
            altTextView.text = town.alt
            Picasso.get().load(town.urlPicture).into(pictureImageView)
        }


    }


}