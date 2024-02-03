package com.sirketismi.azmvipattern

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.update

class SearchListViewModel : BaseViewModel<SearchListContract.Event, SearchListContract.State, SearchListContract.Effect >() {
    override fun handleEvent(event : SearchListContract.Event) {
        when(event) {
            SearchListContract.Event.OnFetchData -> {
                searchFlightsFromRoom()
            }
            SearchListContract.Event.OnDeleteData -> {

            }
            else-> {

            }
        }
    }


    data class temp(val a : String)

    private fun searchFlights() {
         setState {
             it.copy(postState = SearchListContract.PostState.Loading)
    //        copy(postState = SearchListContract.PostState.Loading)
         }
    }

    private fun searchFlightsFromRoom() {
    }

    override fun createInitialState(): SearchListContract.State {
        return SearchListContract.State(SearchListContract.PostState.Idle)
    }
}