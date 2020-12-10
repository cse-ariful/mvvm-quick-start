/*
 *
 *  * Created by Ariful Jannat Arif on 12/10/20 6:39 PM
 *  * cse.ariful@gmail.com
 *  * Bismillahir Rahmanir Rahim
 *  * Last modified 12/10/20 6:39 PM
 *
 */

package com.arif.core.ui

import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.databinding.BindingAdapter

object ViewBindings {
    @JvmStatic
    @BindingAdapter("toast")
    fun bindToast(view: View, text: String?) {
        text?.let {
            Toast.makeText(view.context, it, Toast.LENGTH_SHORT).show()
        }
    }

    @JvmStatic
    @BindingAdapter("onBackPressed")
    fun bindOnBackPressed(view: View, onBackPress: Boolean) {
        val context = view.context
        if (onBackPress && context is OnBackPressedDispatcherOwner) {
            view.setOnClickListener {
                context.onBackPressedDispatcher.onBackPressed()
            }
        }
    }

}

