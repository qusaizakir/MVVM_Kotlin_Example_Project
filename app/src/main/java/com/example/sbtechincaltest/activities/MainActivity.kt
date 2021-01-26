package com.example.sbtechincaltest.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sbtechincaltest.R
import com.example.sbtechincaltest.fragments.LoginFragment
import com.example.sbtechincaltest.fragments.PhotoFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val LOGIN_FRAGMENT_TAG = "LOGIN_FRAGMENT_TAG"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LoginFragment.newInstance(), LOGIN_FRAGMENT_TAG)
                .commitNow()
        }
    }

    override fun onBackPressed() {
        val fragment = this.supportFragmentManager.findFragmentById(R.id.fragment_container)
        if(fragment?.tag != LOGIN_FRAGMENT_TAG){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LoginFragment.newInstance(), LOGIN_FRAGMENT_TAG)
                .commitNow()
        }else{
            super.onBackPressed()
        }
    }
}