package com.inguz01.township.list

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.inguz01.township.R
import com.inguz01.township.detalle.DetalleActivity

class ListTownActivity : AppCompatActivity() {

    private lateinit var listTowns: ArrayList<TownsItem> //lista de objetos tipo Towns, Lateint es inicializar despues
    private lateinit var townAdapter: TownAdapter
    private lateinit var townsRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_town)

        townsRecyclerView = findViewById(R.id.town_recycler_view)

        //listTowns = createMockTownShip()
        listTowns = loadMockTownsFromJson()
        townAdapter = TownAdapter(listTowns, onItemClicked = {onTowns(it)})


        townsRecyclerView.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = townAdapter
            setHasFixedSize(false)
        }
    }

    private fun onTowns(town: TownsItem) {
        Log.d("name",town.name)
        val intent = Intent(this,DetalleActivity::class.java)
        intent.putExtra("town",town)
        startActivity(intent)
    }

    private fun loadMockTownsFromJson(): ArrayList<TownsItem> {
        val townString: String = applicationContext.assets.open("towns.json").bufferedReader().use { it.readText()}
        val gson = Gson()
        val data = gson.fromJson(townString, Towns::class.java)
        return data
    }

    /*private fun createMockTownShip() : ArrayList<Towns>{
        return  arrayListOf(
            Towns(
                name = "Bogotá D.C",
                descrip = "Ciudad capital de Colombia",
                cali = 4.5
            )
        )

    }*/
}