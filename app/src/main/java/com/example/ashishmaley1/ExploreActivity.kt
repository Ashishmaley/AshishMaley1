package com.example.ashishmaley1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ashishmaley1.databinding.ActivityExploreBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ExploreActivity : AppCompatActivity() {
    private lateinit var myAdapter: MyAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding : ActivityExploreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExploreBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val swipeRefreshLayout = binding.swipeRefreshLayout
        swipeRefreshLayout.setOnRefreshListener {
            fetchData() // Call the method to fetch data again
        }
        fetchData()
    }
    private fun fetchData() {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://meme-api.com/gimme/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getProduct()

        retrofitData.enqueue(object : Callback<MemeData?> {
            override fun onResponse(call: Call<MemeData?>, response: Response<MemeData?>) {

                val obj = response.body()
                val product = obj?.memes!!
                recyclerView = findViewById(R.id.recyclerView)
                myAdapter = MyAdapter(this@ExploreActivity, product)
                recyclerView.adapter = myAdapter
                recyclerView.layoutManager = LinearLayoutManager(this@ExploreActivity)
                val swipeRefreshLayout = binding.swipeRefreshLayout
                swipeRefreshLayout.isRefreshing = false // Mark the refresh as complete
            }

            override fun onFailure(call: Call<MemeData?>, t: Throwable) {
                Log.d("Main Activity", "OnFailure: " + t.message)
                val swipeRefreshLayout = binding.swipeRefreshLayout
                swipeRefreshLayout.isRefreshing = false // Mark the refresh as complete
            }
        })


    }
}