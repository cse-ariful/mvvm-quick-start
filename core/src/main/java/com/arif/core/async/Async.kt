/*
 *
 *  * Created by Ariful Jannat Arif on 12/10/20 6:13 PM
 *  * cse.ariful@gmail.com
 *  * Bismillahir Rahmanir Rahim
 *  * Last modified 12/10/20 6:13 PM
 *
 */

package com.arif.core.async

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


/**
 * This class can execute  two task in io and main thread
 */
object Coroutines{
    /**
     * below method is a generic method to execute some work on io thread
     * and after the work finished you need the callback to pass using maing thread
     */
    fun <T:Any> ioThenMain(work: suspend (() -> T?),callback:((T?) -> Unit)) =
        CoroutineScope(Dispatchers.Main).launch {
            val data = CoroutineScope(Dispatchers.IO).async rt@{
                return@rt work()
            }.await()
            callback(data)
        }

    fun <T:Any> OnIo(work: suspend (() -> T?)) = CoroutineScope(Dispatchers.Main).launch {
        CoroutineScope(Dispatchers.IO).async rt@{
            return@rt work()
        }.await()
    }
    fun <T:Any> OnIoSync(work: suspend (() -> T?)) = CoroutineScope(Dispatchers.IO).launch{
        work()
    }


}
