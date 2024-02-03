package com.sirketismi.azmvipattern

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sirketismi.common.UIEffect
import com.sirketismi.common.UIEvent
import com.sirketismi.common.UIState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

//class BaseViewModel<Event : UIEvent, State : UIState, Effect : UIEffect> : ViewModel() {
abstract class BaseViewModel<Event : UIEvent, State : UIState, Effect : UIEffect> : ViewModel() {
    private val initialState : State by lazy { createInitialState() }
    abstract fun createInitialState() : State
    abstract fun handleEvent(event : Event)

    protected val _state = MutableStateFlow(initialState)
    val state = _state.asStateFlow()

    private val _event : MutableSharedFlow<Event> = MutableSharedFlow()
    val event = _event.asSharedFlow()

    private val _effect : Channel<Effect> = Channel()
    val effect = _effect.receiveAsFlow()

    init {
        subscribeEvents()
    }

    private fun subscribeEvents() {
        viewModelScope.launch {
            event.collect {
                handleEvent(it)
            }
        }
    }

    val currentState: State
        get() = state.value

    fun setEffect(builder : ()->(Effect)) {
        val effectValue = builder()
        viewModelScope.launch { _effect.send(effectValue) }
    }

    fun setState(reduce: (State) -> State) {
        val newState = reduce(currentState)
        _state.value = newState
    }

    fun setEvent(event : Event) {
        val newEvent = event
        viewModelScope.launch { _event.emit(newEvent) }
    }
}