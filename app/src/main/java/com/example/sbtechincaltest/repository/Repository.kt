package com.example.sbtechincaltest.repository

import com.example.sbtechincaltest.model.Photo
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class Repository {

    companion object {
        val repository: Repository by lazy { Repository() }
        val photoInterface = RetrofitService.getPhotoInterface()
    }

    fun getAllPhotos(): Observable<List<Photo>> {
        return photoInterface.getAllPhotos()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}