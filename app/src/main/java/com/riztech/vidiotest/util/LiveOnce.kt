package com.nioso.core.util

//https://gist.githubusercontent.com/JoseAlcerreca/5b661f1800e1e654f07cc54fe87441af/raw/d1d9ad561c16f4d04367424ac5f5b305ba691852/Event.kt
open class LiveOnce<out T>(private val content: T) {

    var hasBeenHandled = false
        private set // Allow external read but not write

    /**
     * Returns the content and prevents its use again.
     */
    fun showOnce(): T? {
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
    fun showAgain(): T = content
}