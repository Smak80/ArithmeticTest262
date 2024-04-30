package ru.smak.arithmetictest262

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val tasks = MutableList(5){
        Task()
    }

    var showResult by  mutableStateOf(false)
    var currentTask by mutableStateOf(0)
    val res: Int
        get() = tasks.filter { it.isCorrect == true }.size
    fun dismiss(){
        currentTask = 0
        showResult = false
        tasks.clear()
        repeat(5){ tasks.add(Task()) }
    }

    fun finishTest(){
        currentTask = -1

    }
    fun gotUserAnswer(){
        if (currentTask < 4)
            currentTask++
        else {
            showResult = true
        }
    }
}