package com.example.sbtechincaltest.viewmodels

import android.app.Application
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function3
import io.reactivex.subjects.BehaviorSubject

interface LoginViewModelInputs {
    fun emailInput(text: String)
    fun passwordInput(text: String)
    fun loginClickEvent()
}

interface LoginViewModelOutputs {
    fun loginClicked(): Observable<Boolean>
}

class LoginViewModel(application: Application) : BaseViewModel(application), LoginViewModelInputs, LoginViewModelOutputs{

    val inputs: LoginViewModelInputs = this
    val outputs: LoginViewModelOutputs = this

    private val emailBehaviorSubject = BehaviorSubject.createDefault("")
    private val passwordBehaviorSubject = BehaviorSubject.createDefault("")
    private val loginClickedBehaviorSubject = BehaviorSubject.create<Unit>()

    //inputs
    override fun emailInput(text: String) {
        emailBehaviorSubject.onNext(text)
    }

    override fun passwordInput(text: String) {
        passwordBehaviorSubject.onNext(text)
    }

    override fun loginClickEvent(){
        loginClickedBehaviorSubject.onNext(Unit)
    }

    //outputs
    override fun loginClicked() : Observable<Boolean> {
        return loginClickedBehaviorSubject
                    .withLatestFrom(
                        emailBehaviorSubject,
                        passwordBehaviorSubject,
                        Function3<Unit, String, String, Boolean>
                        {_, email, password ->
                            return@Function3 email.isNotEmpty() && password.isNotEmpty()
                        })
                    .observeOn(AndroidSchedulers.mainThread())
    }
}
