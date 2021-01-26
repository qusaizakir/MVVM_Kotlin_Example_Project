package com.example.sbtechincaltest.viewmodels

import android.app.Application
import com.example.sbtechincaltest.model.Photo
import io.reactivex.Observable

interface PhotoViewModelOutputs {
    fun getAllPhotos(): Observable<List<Photo>>
}

class PhotoViewModel(application: Application) : BaseViewModel(application), PhotoViewModelOutputs{

    val outputs: PhotoViewModelOutputs = this

    override fun getAllPhotos(): Observable<List<Photo>> {
        return repo.getAllPhotos()
    }

}
