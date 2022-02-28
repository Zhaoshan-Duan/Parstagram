package com.example.Parstagram

import android.app.Application
import com.example.Parstagram.R
import com.parse.Parse
import com.parse.ParseObject

class ParstagramApplication : Application() {

        override fun onCreate() {
            super.onCreate()

            // Register the Post Class
            ParseObject.registerSubclass(Post::class.java)


            Parse.initialize(
                Parse.Configuration.Builder(this)
                    .applicationId(getString(R.string.back4app_app_id))
                    .clientKey(getString(R.string.back4app_client_key))
                    .server(getString(R.string.back4app_server_url))
                    .build());
        }
    }