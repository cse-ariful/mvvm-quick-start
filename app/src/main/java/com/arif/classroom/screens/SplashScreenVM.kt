/*
 *
 *  * Created by Ariful Jannat Arif on 12/10/20 7:36 PM
 *  * cse.ariful@gmail.com
 *  * Bismillahir Rahmanir Rahim
 *  * Last modified 12/10/20 7:36 PM
 *
 */

package com.arif.classroom.screens

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// here passing context for showing sample viewmodel injection demo as i dont have any class right now

// using context in viewModel is not recommended perhaps a very bad practice

// below context is provided from provider module class in di package

class SplashScreenVM @ViewModelInject constructor(val context: Context) : ViewModel() {
    val appName = MutableLiveData<String>("MVVM")
}