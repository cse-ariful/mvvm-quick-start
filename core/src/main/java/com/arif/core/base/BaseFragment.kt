/*
 *
 *  * Created by Ariful Jannat Arif on 12/10/20 6:11 PM
 *  * cse.ariful@gmail.com
 *  * Bismillahir Rahmanir Rahim
 *  * Last modified 12/10/20 6:11 PM
 *
 */

package com.arif.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.transition.TransitionInflater
import com.arif.core.BR

abstract class BaseFragment<Binding : ViewDataBinding, viewModelType : ViewModel> (@LayoutRes val layoutRes:Int  ): Fragment() {
    protected abstract val viewModel: viewModelType
    protected lateinit var binding: Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        doDataBinding()
    }

    /**
     * Do your other stuff in init after binding layout.
     */
    abstract fun init()
    open fun setBindingVariables(){}
    private fun doDataBinding() {
        binding.lifecycleOwner = viewLifecycleOwner // it is extra if you want to set life cycle owner in binding
        // Here your viewModelType and binding variable imlementation
        binding.setVariable(BR.viewModel, viewModel)  // In all layout the variable name should be "viewModel"
        setBindingVariables()
        binding.executePendingBindings()
        init()
    }

}