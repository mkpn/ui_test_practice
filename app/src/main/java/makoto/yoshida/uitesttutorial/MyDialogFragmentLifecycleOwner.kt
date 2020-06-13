package makoto.yoshida.uitesttutorial

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

class MyDialogFragmentLifecycleOwner : LifecycleOwner {

    private val lifecycleRegistry = LifecycleRegistry(this)

    override fun getLifecycle() = lifecycleRegistry

    fun start() {
        // STARTEDの状態にしてLiveDataをActiveにする
        lifecycleRegistry.currentState = Lifecycle.State.STARTED
    }

    fun stop() {
        // CREATEDの状態にしてLiveDataをInactiveにする
        lifecycleRegistry.currentState = Lifecycle.State.DESTROYED
    }

}