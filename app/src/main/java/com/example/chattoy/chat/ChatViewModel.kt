package com.example.chattoy.chat

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import com.example.chattoy.data.DataSource
import com.example.chattoy.data.entities.Message
import com.example.chattoy.repository.MessageRepository
import com.example.chattoy.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class ChatViewModel(private val repo: MessageRepository, private val mSchedulerProvider: SchedulerProvider) : ViewModel() {

    private val _items = MutableLiveData<List<Message>>().apply {
        value = emptyList()
    }

    private val items :LiveData<List<Message>>
        get() = _items

    private val mCompositeDisposable: CompositeDisposable = CompositeDisposable()
    fun loadMessages() {
        mCompositeDisposable.clear()
        val disposable = repo.getMessages()
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .doFinally {


                }.subscribe { messages ->
                    _items.value = messages
                }
        mCompositeDisposable.add(disposable)

    }


}
