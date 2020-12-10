/*
 *
 *  * Created by Ariful Jannat Arif on 12/10/20 6:26 PM
 *  * cse.ariful@gmail.com
 *  * Bismillahir Rahmanir Rahim
 *  * Last modified 12/10/20 6:26 PM
 *
 */

package com.arif.core.data

/**
 * this is a generic class that can hold all type of data and states regarding them
 * if state is success then this will contain the target data type
 * else it will contain a data relative to the type that it is
 * like for error state it will contain a message
 */
sealed class ResultData<out T>{
    data class Initial(val initialMessage:String): ResultData<Nothing>()
    data class Success<out T>(val data:T): ResultData<T>()
    data class Empty(val nothing: Nothing? = null): ResultData<Nothing>()
    data class Loading(val nothing: Nothing? = null): ResultData<Nothing>()
    data class Failed(val message:String): ResultData<Nothing>()
}