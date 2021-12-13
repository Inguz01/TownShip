package com.inguz01.township.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.inguz01.township.R
import com.inguz01.township.model.TownsItem
import com.squareup.picasso.Picasso

class TownAdapter(
    private val TownList:ArrayList<TownsItem>, // ArrayList<TownsItem> se podria llamar solo Towns ya q este es una arraylist en Towns.kt
    private val onItemClicked: (TownsItem) -> Unit
    ):RecyclerView.Adapter<TownAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_town_item,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val town = TownList[position]
        holder.itemView.setOnClickListener{onItemClicked(TownList[position])}
        holder.bind(town)
    }

    override fun getItemCount(): Int = TownList.size

    class ViewHolder(itemview: View):RecyclerView.ViewHolder(itemview){ //itemview es el cuadro de descripcion

        private var nameTextView: TextView = itemview.findViewById(R.id.name_text_view)
        private var descripTextView: TextView = itemview.findViewById(R.id.descrip_text_view)
        private var caliTextView: TextView = itemview.findViewById(R.id.cali_text_view)
        private var pictureImageView: ImageView = itemview.findViewById(R.id.picture_image_view)

        fun bind(town: TownsItem){
            //Log.d("nombre", town.name)
            nameTextView.text = town.name
            descripTextView.text = town.descrip
            caliTextView.text = town.cali.toString()
            Picasso.get().load(town.urlPicture).into(pictureImageView);
        }
    }
}