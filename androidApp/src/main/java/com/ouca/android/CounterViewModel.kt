package com.ouca.android

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class CounterViewModel : ViewModel() {
    val count = MutableStateFlow(0f)
    val countLVL = MutableStateFlow(0)

    fun incrementCount() {
            if (count.value >= 100f) {
                count.value = 1f
                countLVL.value++
            } else count.value++
    }

    fun decrementCount() {
        if (count.value <= 0f) {
            count.value = 99f
        } else count.value--
    }

    fun initialyseCount() {
            count.value = 0f
    }
}