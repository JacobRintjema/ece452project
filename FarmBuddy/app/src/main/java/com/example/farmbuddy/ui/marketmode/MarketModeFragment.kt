package com.example.farmbuddy.ui.marketmode

import android.R
import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.farmbuddy.databinding.FragmentMarketModeBinding

class MarketModeFragment : Fragment() {

    private var _binding: FragmentMarketModeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MarketModeFragment()
    }

    private lateinit var viewModel: MarketModeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val marketModeViewModel = ViewModelProvider(this).get(MarketModeViewModel::class.java)

        _binding = FragmentMarketModeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MarketModeViewModel::class.java)

        // Bind fragment_market_mode.xml's recycler
        val recyclerUI = binding.marketsMain
        binding.marketsMain.adapter = MarketAdapter(MarketData.markets)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}