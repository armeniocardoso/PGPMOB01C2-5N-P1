package br.edu.infnet.mitmob

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MusicaController(lifecycle : Lifecycle) : LifecycleObserver {

    init {

        lifecycle.addObserver(this)
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun iniciarMusica(){

        Log.i("MIT", "MusicaController.iniciarMusica")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun pararMusica(){

        Log.i("MIT", "MusicaController.pararMusica")
    }
}