package com.example.farmbuddy.ui.productview

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.farmbuddy.R
import com.example.farmbuddy.databinding.FragmentProductViewBinding


class ProductViewFragment : Fragment() {

    private var _binding: FragmentProductViewBinding? = null

    private val binding get() = _binding!!


    companion object {
        fun newInstance() = ProductViewFragment()
    }

    private lateinit var viewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val productViewModel =
            ViewModelProvider(this).get(ProductViewModel::class.java)

        _binding = FragmentProductViewBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textMarketMode
        productViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }


        return root


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        val table = binding.marketTable
        val button = binding.imgAdd
        button.setOnClickListener{
            val tr = TableRow(activity)
            val tv1 = TextView(activity)
            tv1.text = "TEST NUMBER"
            tv1.textSize = 20f
            tv1.setPadding(5, 5, 5, 5)
            tr.addView(tv1)
            table.addView(tr)
        }

        val button2 = binding.imgRemove
        button2.setOnClickListener{
            if (table.size > 0) {
                table.removeViewAt(table.size-1)
            }

        }
        // TODO: Use the ViewModel
    }

}