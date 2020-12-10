/*
 *
 *  * Created by Ariful Jannat Arif on 12/10/20 7:36 PM
 *  * cse.ariful@gmail.com
 *  * Bismillahir Rahmanir Rahim
 *  * Last modified 12/10/20 7:36 PM
 *
 */

package com.arif.classroom.screens

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.arif.classroom.R
import com.arif.classroom.databinding.FragmentSplashScreenBinding
import com.arif.core.base.BaseFragment

class SplashScreen : BaseFragment<FragmentSplashScreenBinding,SplashScreenVM>(R.layout.fragment_splash_screen) {
    override val viewModel: SplashScreenVM  by viewModels()

    override fun init() {
        //initialize your fragment here
        viewModel.appName.observe(viewLifecycleOwner, Observer {
            //do stuffs with this apps
        })
    }



    /*override fun setBindingVariables() {
        super.setBindingVariables()

        //use this method if you need to set some extra variables in databinding
       // by default viewmodel is automatically binded using naame 'viewModel'

    }*/


}