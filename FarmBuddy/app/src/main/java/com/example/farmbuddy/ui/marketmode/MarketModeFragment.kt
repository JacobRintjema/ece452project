package com.example.farmbuddy.ui.marketmode

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.farmbuddy.R

class MarketModeFragment : Fragment() {

    companion object {
        fun newInstance() = MarketModeFragment()
    }

    private lateinit var viewModel: MarketModeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_market_mode, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MarketModeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}