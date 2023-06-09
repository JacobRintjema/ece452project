package com.example.farmbuddy.ui.homemode

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.farmbuddy.R

class HomeModeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeModeFragment()
    }

    private lateinit var viewModel: HomeModeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_mode, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeModeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}