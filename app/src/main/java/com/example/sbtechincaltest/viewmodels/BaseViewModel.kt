package com.example.sbtechincaltest.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.sbtechincaltest.repository.Repository

abstract class BaseViewModel(application: Application) : AndroidViewModel(application){

    protected val repo: Repository = Repository.repository
}