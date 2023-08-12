package com.example.coordinator.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coordinator.R
import com.example.coordinator.adapter.FeddAdapter
import com.example.coordinator.model.Feed

class MainActivity : AppCompatActivity() {
    lateinit var list: ArrayList<Feed>
    lateinit var adapter: FeddAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        loadList()
        val rvFedd =findViewById<RecyclerView>(R.id.rv_feed)
        rvFedd.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        adapter= FeddAdapter(list)
        rvFedd.adapter=adapter
        adapter.likeClickListener={
            Toast.makeText(this, "$it-elementni like tugma bosildi", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadList() {
        list= ArrayList()
        list.add(Feed("https://t.pimg.jp/081/628/898/1/81628898.jpg","Eshchanova Khalida","Parrot","now","This beatiful bird","https://www.birdcagesnow.com/cdn/shop/collections/large-cockatoo_580x.jpg?v=1507605143",10000,345,true))
        list.add(Feed("https://t.pimg.jp/081/628/898/1/81628898.jpg","Eshchanova Khalida","Parrot","now","This beatiful bird","https://www.birdcagesnow.com/cdn/shop/collections/large-cockatoo_580x.jpg?v=1507605143",10000,345,true))
        list.add(Feed("https://t.pimg.jp/081/628/898/1/81628898.jpg","Eshchanova Khalida","Parrot","now","This beatiful bird","https://i.pinimg.com/originals/82/c0/4f/82c04faf26a42cb172b81bc19e28560d.jpg",10000,345,true))
        list.add(Feed("https://t.pimg.jp/081/628/898/1/81628898.jpg","Eshchanova Khalida","Parrot","now","This beatiful bird","https://www.birdcagesnow.com/cdn/shop/collections/large-cockatoo_580x.jpg?v=1507605143",10000,345,true))
        list.add(Feed("https://t.pimg.jp/081/628/898/1/81628898.jpg","Eshchanova Khalida","Parrot","now","This beatiful bird","https://www.birdcagesnow.com/cdn/shop/collections/large-cockatoo_580x.jpg?v=1507605143",10000,345,true))
        list.add(Feed("https://t.pimg.jp/081/628/898/1/81628898.jpg","Eshchanova Khalida","Parrot","now","This beatiful bird","https://www.birdcagesnow.com/cdn/shop/collections/large-cockatoo_580x.jpg?v=1507605143",10000,345,true))
    }
}