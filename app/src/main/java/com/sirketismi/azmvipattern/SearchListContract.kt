package com.sirketismi.azmvipattern

import com.sirketismi.common.UIEffect
import com.sirketismi.common.UIEvent
import com.sirketismi.common.UIState

class SearchListContract {
    sealed class Event : UIEvent {
        object OnFetchData : Event()
        object OnDeleteData : Event()
        data class OnItemSelected(val item : SearchListUIModel) : Event()
    }

    data class State(val postState: PostState) : UIState {

    }

    sealed class PostState {
        object Idle : PostState()
        object Loading : PostState()
        data class Success(val posts : List<SearchListUIModel>) : PostState()
    }

    sealed class Effect : UIEffect {
        data class ShowError(val message : String?) : Effect()
    }
}