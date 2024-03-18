package com.example.maths_tutor_app.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.maths_tutor_app.domain.authViewModel.AuthViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            AuthViewModel(
                mathsTutorApplication().container.userDatabaseRepository
            )
        }
    }
}

fun CreationExtras.mathsTutorApplication(): MathsTutorApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MathsTutorApplication)

