package com.example.ashishmaley1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

    }

    fun explore(view: View) {
        startActivity(Intent(this,ExploreActivity::class.java))
    }

    fun uploadImage(view: View) {
        startActivity(Intent(this,UplodImageActivity::class.java))
    }
}