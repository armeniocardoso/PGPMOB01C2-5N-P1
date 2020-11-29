package br.edu.infnet.mitmob

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MainActivityViewModel : ViewModel() {

    var frase = ""
    var nome = MutableLiveData<String>()

    init {

        Log.i("MIT", "MainActivityViewModel.init")
        val calendar = Calendar.getInstance()
        when(calendar.get(Calendar.HOUR_OF_DAY)) {

            in 0..11 -> frase = "Bom Dia!"
            in 12..17 -> frase = "Boa Tarde!"
            in 18..23 -> frase = "Boa Noite!"
        }
    }

    override fun onCleared() {

        super.onCleared()
        Log.i("MIT", "MainActivityViewModel.onCleared")
    }
}
