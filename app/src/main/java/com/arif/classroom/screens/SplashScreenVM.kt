/*
 *
 *  * Created by Ariful Jannat Arif on 12/10/20 7:36 PM
 *  * cse.ariful@gmail.com
 *  * Bismillahir Rahmanir Rahim
 *  * Last modified 12/10/20 7:36 PM
 *
 */

package com.arif.classroom.screens

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SplashScreenVM : ViewModel() {
    val appName = MutableLiveData<String>("MVVM")
}