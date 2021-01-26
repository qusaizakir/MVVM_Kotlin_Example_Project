package com.example.sbtechincaltest.repository

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    companion object{
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
        const val PHOTOS_URL = "photos"
        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        fun getPhotoInterface(): PhotoApiInterface{
            return retrofit.create(PhotoApiInterface::class.java)
        }
    }

}
