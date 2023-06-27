package com.example.farmbuddy.ui.homemode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.farmbuddy.databinding.FragmentHomeModeBinding

class HomeModeFragment : Fragment() {

    private var _binding: FragmentHomeModeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = HomeModeFragment()
    }

    private lateinit var viewModel: HomeModeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val homeModeViewModel = ViewModelProvider(this).get(HomeModeViewModel::class.java)

        _binding = FragmentHomeModeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeModeViewModel::class.java)

        // Bind fragment_market_mode.xml's recycler
        val recyclerUI = binding.homeMain
        binding.homeMain.adapter = InventoryAdapter(HomeData.inventory)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}