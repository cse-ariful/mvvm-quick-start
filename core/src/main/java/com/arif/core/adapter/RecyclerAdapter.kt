/*
 *
 *  * Created by Ariful Jannat Arif on 11/20/20 7:03 PM cse.ariful@gmail.com
 *  * cse.ariful@gmail.com
 *  * No man is perfect so why codes? if anything went wrong please debug
 *  * Last modified 11/14/20 10:11 PM
 *
 */

package com.arif.core.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.arif.core.BR


class RecyclerAdapter<T : Any>(@LayoutRes val layoutId: Int, private val itemClickEvent: OnItemClickEvent) :
    RecyclerView.Adapter<RecyclerAdapter.GenericViewHolder<T>>() {
    interface OnItemClickEvent {
        fun onClick(view: View, itemModel: Any,pos:Int)
    }



    private val items = mutableListOf<T>()
    private var inflater: LayoutInflater? = null
    private var createAnimation:Animation?=null
    private var bindAnimation:Animation?=null


    fun addItems(items: List<T>?) {
        this.items.clear()
        if(items!=null){
            this.items.addAll(items)
        }
        notifyDataSetChanged()
    }

    fun createAnimation(animations: Animation?){
        this.createAnimation = animations
    }
    fun bindnimation(animations: Animation?){
        this.bindAnimation = animations
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<T> {
        val layoutInflater = inflater ?: LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, layoutId, parent, false)
        createAnimation?.let {
            binding.root.startAnimation(createAnimation)
        }
        return GenericViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: GenericViewHolder<T>, position: Int) {
        val itemViewModel = items[position]

        holder.bind(itemViewModel,position,itemClickEvent)
        bindAnimation?.let {
            holder.itemView.startAnimation(bindAnimation)
        }
    }


    class GenericViewHolder<T : Any>(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            itemViewModel: T,
            position: Int,
            itemClickEvent: OnItemClickEvent
        ) {
            binding.setVariable(BR.position,position)
            binding.setVariable(BR.listener,itemClickEvent)
            binding.setVariable(BR.item, itemViewModel)
            binding.executePendingBindings()
        }

    }


}