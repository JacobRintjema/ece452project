package com.example.farmbuddy.ui.charitymode

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.farmbuddy.R

class CharityModeFragment : Fragment() {

    companion object {
        fun newInstance() = CharityModeFragment()
    }

    private lateinit var viewModel: CharityModeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_charity_mode, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CharityModeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}