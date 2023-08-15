package com.example.coordinator.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coordinator.R
import com.example.coordinator.adapter.FeddAdapter
import com.example.coordinator.model.Feed


class MainActivity : AppCompatActivity() {

    lateinit var ivRepost:ImageView
    lateinit var ivPost:ImageView
    var IMAGE_CHOOSE_CODE=1234
    lateinit var ivLike:ImageView


    lateinit var list: ArrayList<Feed>

    lateinit var ivShare:ImageView

    lateinit var adapter: FeddAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
//        onClick()

    }

    private fun onClick(v:View) {
        ivLike = findViewById<View>(R.id.iv_like) as ImageView
        ivLike.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                ivLike.setImageResource(R.drawable.round_favorite_border_24)
                ivLike.setImageResource(R.drawable.round_favorit)
            }
        })
    }

    private fun initView() {
        loadList()
        ivRepost=findViewById(R.id.iv_repost)
        ivPost=findViewById(R.id.iv_post)



        val rvFedd =findViewById<RecyclerView>(R.id.rv_feed)

        ivShare=findViewById(R.id.iv_share)

        rvFedd.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        adapter= FeddAdapter(list)
        rvFedd.adapter=adapter
        adapter.likeClickListener={
            Toast.makeText(this, "$it-elementni like tugma bosildi", Toast.LENGTH_SHORT).show()
        }
        ivShare.setOnClickListener {
            val intent=Intent(Intent.ACTION_SEND)
            intent.type="text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "Salom")
            startActivity(Intent.createChooser(intent,"Share"))
        }
        ivRepost.setOnClickListener {
            val intent=Intent(Intent.ACTION_GET_CONTENT)
            intent.type="image/*"
            startActivityForResult(Intent.createChooser(intent, "Select ones"),IMAGE_CHOOSE_CODE)
        }


    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (IMAGE_CHOOSE_CODE==requestCode && resultCode== RESULT_OK){
            val uri=data?.data
            ivPost.setImageURI(uri)
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