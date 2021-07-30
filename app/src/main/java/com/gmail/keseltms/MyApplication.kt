package com.gmail.keseltms

import android.app.Application
import com.gmail.keseltms.cloud.ApiRepository
import com.gmail.keseltms.cloud.RadioApi
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinApiExtension
import org.koin.core.context.startKoin
import org.koin.dsl.module

@KoinApiExtension

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(listOf(api,repository))
        }
    }

    private val api = module {
        single { RadioApi.get() }
    }
    private val repository = module {

        factory { ApiRepository(get()) }
    }
}