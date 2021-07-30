package com.gmail.keseltms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gmail.keseltms.cloud.ApiRepository
import com.gmail.keseltms.data.Radio
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val api: ApiRepository by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch {

            val radio = api.getApiResult(
                "Russia",
                "",
                100000
            ).map {
                Radio(
                    it.country,
                    it.countrycode,
                    it.favicon,
                    it.language,
                    it.name,
                    it.tags,
                    it.url
                )
            }

            Log.e("KEK", "\n"+radio.toString())
            }
        }

    }
