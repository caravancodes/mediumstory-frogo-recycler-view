package com.frogobox.mediumfrv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.frogobox.mediumfrv.databinding.ActivityMainBinding
import com.frogobox.recycler.core.IFrogoViewAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        setupFrogoRecyclerView()
    }

    private fun listData(): MutableList<Mahasiswa> {
        val listString = mutableListOf<Mahasiswa>()
        listString.add(Mahasiswa("Muhammad Faisal Amir"))
        listString.add(Mahasiswa("Feronika Nur M"))
        listString.add(Mahasiswa("Dinda Nur Halisa"))
        listString.add(Mahasiswa("Muhammad Lukman Hakim"))
        return listString
    }

    private fun setupFrogoRecyclerView() {

        val adapterCallback = object :
            IFrogoViewAdapter<Mahasiswa> {
            override fun setupInitComponent(view: View, data: Mahasiswa) {
                // Init component content item recyclerview
                view.findViewById<TextView>(R.id.frogo_rv_list_type_1_tv_title).text = data.nama
            }

            override fun onItemClicked(data: Mahasiswa) {
                // setup item clicked on frogo recycler view
            }

            override fun onItemLongClicked(data: Mahasiswa) {
                // setup item long clicked on frogo recycler view
            }
        }

        binding.frogoRv.injector<Mahasiswa>()
            .addData(listData())
            .addCustomView(R.layout.frogo_rv_list_type_1)
            .addEmptyView(null)
            .addCallback(adapterCallback)
            .createLayoutLinearVertical(false)
            .build()
    }


}