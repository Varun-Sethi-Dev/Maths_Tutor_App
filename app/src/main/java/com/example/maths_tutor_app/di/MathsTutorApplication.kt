package com.example.maths_tutor_app.di

import android.app.Application

class MathsTutorApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}