package com.example.networktest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.networktest.databinding.ActivityMainBinding
import com.google.gson.GsonBuilder
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

class MainActivity : AppCompatActivity() {

    private val retrofit by lazy { createRetrofit() }
    private val service by lazy { retrofit.create<ApiService>() }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            fetchData()
        }
        fetchData()
    }

    private fun fetchData() {
        lifecycleScope.launch {
            val response = service.fetchData()
            if (response.isSuccessful) {
                binding.textView.text = response.body()?.toString()
            } else {
                binding.textView.text = response.toString()
            }
        }
    }

    private fun createRetrofit(): Retrofit {
        val gson = GsonBuilder().registerTypeAdapterFactory(runtimeTypeAdapterFactory).create()
        val logging = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        val client = OkHttpClient.Builder().addInterceptor(logging).build()
        return Retrofit.Builder()
            .baseUrl("https://jsonkeeper.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

    interface ApiService {

        @GET("/b/R1PO")
        suspend fun fetchData(): Response<FeedResponse>
    }
}

sealed class NetworkResponse<out SUCCESS> {
    /**
     * Success response with body
     */
    data class Success<SUCCESS>(val body: SUCCESS?) : NetworkResponse<SUCCESS>()

    data class Error(val body: ResponseBody) : NetworkResponse<Nothing>()

}