package com.dobi.videogames

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    private val counter = MutableLiveData(0)

    val counterLiveData: LiveData<Int>
        get() {
            Log.d("MMDO", "LiveData instance: ${this.hashCode()}")
            return counter
        }

    fun increment() {
        val curr = counter.value ?: return
        counter.value = curr + 1
    }
}