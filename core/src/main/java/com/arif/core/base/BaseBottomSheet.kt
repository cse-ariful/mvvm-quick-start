/*
 *
 *  * Created by Ariful Jannat Arif on 11/20/20 7:03 PM cse.ariful@gmail.com
 *  * cse.ariful@gmail.com
 *  * No man is perfect so why codes? if anything went wrong please debug
 *  * Last modified 11/14/20 10:52 PM
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
import androidx.lifecycle.ViewModel
import com.arif.core.BR
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


abstract class BaseBottomSheet<Binding : ViewDataBinding, viewModelType : ViewModel> : BottomSheetDialogFragment() {
    protected abstract val viewModel: viewModelType
    protected lateinit var binding: Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false)
        return binding.root
    }

    /**
     * Get layout resource id which inflate in onCreateView.
     */
    @LayoutRes
    abstract fun getLayoutResId(): Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        doDataBinding()
    }

    /**
     * Do your other stuff in init after binding layout.
     */
    abstract fun init()

    private fun doDataBinding() {
        //todo it is extra if you want to set life cycle owner in binding
        binding.lifecycleOwner = viewLifecycleOwner
        // Here your viewModelType and binding variable imlementation
        binding.setVariable(BR.viewModel, viewModel)  // In all layout the variable name should be "viewModel"
        binding.executePendingBindings()
        init()
    }

}