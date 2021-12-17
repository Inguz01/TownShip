package com.inguz01.township.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.inguz01.township.databinding.FragmentListBinding
import com.inguz01.township.model.Towns
import com.inguz01.township.model.TownsItem

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var townAdapter: TownAdapter
    private lateinit var listTowns: ArrayList<TownsItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)

        return listBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listTowns = loadMockTownsFromJson()
        townAdapter = TownAdapter(listTowns, onItemClicked = {onTownsClicked(it)})

        listBinding.townRecyclerView.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = townAdapter
            setHasFixedSize(false)
        }
    }

    private fun onTownsClicked(town: TownsItem) {
        findNavController().navigate(List)
    //findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(towns = town))
    //TODO Programar detalle
    }


    private fun loadMockTownsFromJson(): ArrayList<TownsItem> {
        val townString: String = context?.assets?.open("towns.json")?.bufferedReader().use { it!!.readText()} //TODO Reparar !!
        val gson = Gson()
        val TownList = gson.fromJson(townString, Towns::class.java)
        return TownList
    }

}