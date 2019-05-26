package com.example.chattoy.chat

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.chattoy.R
import com.example.chattoy.databinding.ChatFragmentBinding

class ChatFragment : Fragment() {
    companion object {
        fun newInstance() = ChatFragment()
    }
    fun setViewModel(viewModel: ChatViewModel){
        viewmodel = viewModel
    }
    private lateinit var viewmodel: ChatViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val chatfragbinding = ChatFragmentBinding.inflate(inflater,container, false )
        chatfragbinding.viewmodel = viewmodel
        chatfragbinding.lifecycleOwner = this
        return chatfragbinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

}
