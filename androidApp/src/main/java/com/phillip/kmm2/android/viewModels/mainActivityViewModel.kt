package com.phillip.kmm2.android.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.phillip.kmm2.ApiServer

class MainActivityViewModel: ViewModel() {

    val googleResponse = mutableStateOf("")

    sealed class UiState {
        object Loading: UiState()
        data class Success(val data: String): UiState()
        object Error: UiState()
    }

    init {

    }




    suspend fun connectToGoogle() {
        //ApiServer().connectToGoogle(){}
    }

}