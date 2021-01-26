package com.example.sbtechincaltest.repository

import com.example.sbtechincaltest.model.Photo
import com.example.sbtechincaltest.repository.RetrofitService.Companion.PHOTOS_URL
import io.reactivex.Observable
import retrofit2.http.GET

interface PhotoApiInterface {

    @GET(RetrofitService.BASE_URL + PHOTOS_URL)
    fun getAllPhotos(): Observable<List<Photo>>

}