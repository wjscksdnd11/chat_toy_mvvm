package com.example.chattoy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chattoy.data.DataSource
import com.example.chattoy.data.entities.Message
import com.example.chattoy.repository.MessageRepository

class MessageViewModel(
        private val messageRepo: MessageRepository)
    : ViewModel() {
    private val _items = MutableLiveData<List<Message>>().apply {
        value = emptyList()
    }

    val items: LiveData<List<Message>>
        get() = _items
    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean>
        get() = _dataLoading

    private val _isRead = MutableLiveData<Boolean>()
    val isRead: LiveData<Boolean>
        get() = _isRead

    fun start(showLoadingUI:Boolean){
        loadMessages(showLoadingUI)
    }
    fun connectServer(userId:String){
        messageRepo.connect(userId)
    }
    private fun loadMessages(showLoadingUI:Boolean){
        if(showLoadingUI){
            _dataLoading.value = true
        }
        messageRepo.loadMessage(object :DataSource.LoadMessageCallback{
            override fun onSuccess(message: List<Message>) {
                _items.value = ArrayList(message)
            }

            override fun onFail() {
            }
        })

    }
}