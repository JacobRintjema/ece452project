package com.example.farmbuddy.ui.farmmode

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.farmbuddy.databinding.FragmentFarmModeBinding

class FarmModeFragment : Fragment() {

    private var _binding: FragmentFarmModeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = FarmModeFragment()
    }

    private lateinit var viewModel: FarmModeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val farmModeViewModel =
            ViewModelProvider(this).get(FarmModeViewModel::class.java)

        _binding = FragmentFarmModeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textFarmMode
        farmModeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FarmModeViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}