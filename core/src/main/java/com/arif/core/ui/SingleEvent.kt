/*
 *
 *  * Created by Ariful Jannat Arif on 11/20/20 7:04 PM cse.ariful@gmail.com
 *  * cse.ariful@gmail.com
 *  * No man is perfect so why codes? if anything went wrong please debug
 *  * Last modified 11/14/20 10:11 PM
 *
 */

package com.arif.core.ui

open class SingleEvent<out T>(private val content: T) {

    var hasBeenHandled = false
        private set // Allow external read but not write

    /**
     * Returns the content and prevents its use again.
     */
    fun getUnHandledEvent(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    /**
     * Returns the content, even if it's already been handled.
     */
    fun getLastSentEvent(): T = content
}