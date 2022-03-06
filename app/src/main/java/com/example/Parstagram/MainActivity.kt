package com.example.Parstagram

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.Parstagram.fragments.ComposeFragment
import com.example.Parstagram.fragments.FeedFragment
import com.example.Parstagram.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.parse.*
import java.io.File

// Let use creat a post by taking a photo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager: FragmentManager = supportFragmentManager

        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnItemSelectedListener{
            item ->
            lateinit var fragmentToShow: Fragment
            when (item.itemId){

                R.id.action_home -> {
                    // Go to Feed Fragment
                    fragmentToShow = FeedFragment()
                }
                R.id.action_compose -> {
                    // Show Compose Fragment
                    fragmentToShow = ComposeFragment()
                }
                R.id.action_profile -> {
                    // Go to Profile
                    fragmentToShow = ProfileFragment()
                }
            }
            if (fragmentToShow != null){
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragmentToShow).commit()
            }
            true // we handle the user interaction
        }

        // Set default selection
        findViewById<BottomNavigationView>(R.id.bottom_navigation).selectedItemId = R.id.action_home

    }

    companion object{
        const val TAG = "MainActivity"
    }
}