package com.example.ashishmaley1

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.ashishmaley1.databinding.ActivityUplodImageBinding


@Suppress("DEPRECATION")
class UplodImageActivity : AppCompatActivity() {
    private var binding : ActivityUplodImageBinding?=null
    val GALLERY_REQUEST_CODE = 121

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUplodImageBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

    }

    fun selectImage(view: View) {
        val galleryIntent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        galleryIntent.addCategory(Intent.CATEGORY_OPENABLE)
        galleryIntent.type = "image/*"
        startActivityForResult(galleryIntent, GALLERY_REQUEST_CODE)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == GALLERY_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            val selectedImageUri: Uri? = data.data
            binding!!.imageView.setImageURI(selectedImageUri)
        }
    }

    fun back(view: View) {
        onBackPressed()
    }

}