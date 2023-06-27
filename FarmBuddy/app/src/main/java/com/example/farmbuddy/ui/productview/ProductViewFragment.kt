package com.example.farmbuddy.ui.productview

import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TableRow
import android.widget.TextView
import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import android.widget.Toast
import androidx.compose.ui.text.toLowerCase
import androidx.core.view.get
import com.example.farmbuddy.databinding.FragmentProductViewBinding
import java.lang.Exception
import java.util.Locale


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

        val textView2 : TextView = binding.quantity
        productViewModel.textQuantity.observe(viewLifecycleOwner) {
            textView2.text = it
        }

        val textView3 : TextView = binding.unit
        productViewModel.textUnits.observe(viewLifecycleOwner) {
            textView3.text = it
        }

        val textView4 : TextView = binding.textMarket
        productViewModel.textMarket.observe(viewLifecycleOwner) {
            textView4.text = it
        }
        val textView5 : TextView = binding.textPrice
        productViewModel.textPrice.observe(viewLifecycleOwner) {
            textView5.text = it
        }
        val textView6 : TextView = binding.textWeight
        productViewModel.textWeight.observe(viewLifecycleOwner) {
            textView6.text = it
        }
        return root
    }

    private  val REQUEST_CODE_SPEECH_INPUT = 1


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        val table = binding.marketTable
        val submit = binding.submitButton
        val user_input = binding.textBox
        submit.setOnClickListener {
            val tr = TableRow(activity)
            val market_name = TextView(activity)
            val market_num = TextView(activity)
            val product_num = TextView(activity)
            val product_cost = TextView(activity)
            market_name.text = user_input.text.toString()
            market_name.textSize = 20f
            market_name.setPadding(8, 8, 8, 8)
            market_num.text = "Market_" + (table.size + 1).toString()
            market_num.textSize = 20f
            market_num.setPadding(8, 8, 8, 8)
            product_num.textSize = 20f
            product_num.text = "1"
            product_num.setPadding(8, 8, 8, 8)
            product_cost.textSize = 20f
            product_cost.text = "$50"
            product_cost.setPadding(8, 8, 8, 8)

            val add = ImageView(activity)
            val add_uri = "@drawable/ic_addition"
            val add_imageResource = resources.getIdentifier(add_uri, null, activity?.packageName)
            val add_res = resources.getDrawable(add_imageResource)

            add.setImageDrawable(add_res)
            add.setOnClickListener {
                val current_val = Integer.parseInt(product_num.text.toString())
                product_num.text = (current_val + 1).toString()
            }

            val remove = ImageView(activity)
            val remove_uri = "@drawable/ic_remove"
            val remove_imageResource =
                resources.getIdentifier(remove_uri, null, activity?.packageName)
            val remove_res = resources.getDrawable(remove_imageResource)

            remove.setImageDrawable(remove_res)
            remove.setOnClickListener {
                val current_val = Integer.parseInt(product_num.text.toString())
                product_num.text = (current_val - 1).toString()
                if (Integer.parseInt(product_num.text.toString()) <= 0) {
                    table.removeView(tr)
                    for (i in Integer.parseInt(market_num.text.substring(7)) - 1 until table.childCount) {
                        var row = table.getChildAt(i) as TableRow
                        val market_view = row.get(0) as TextView
                        val market_num = Integer.parseInt((market_view).text.substring(7)) - 1
                        market_view.text = "Market_" + market_num.toString()
                    }
                }
            }

            tr.addView(market_num)
            tr.addView(market_name)
            tr.addView(product_num)
            tr.addView(product_cost)
            tr.addView(add)
            tr.addView(remove)
            table.addView(tr)
        }

        val mic = binding.imgMic
        mic.setOnClickListener{
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,Locale.getDefault())
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Speak to Text")
            try{
                startActivityForResult(intent,REQUEST_CODE_SPEECH_INPUT)
            } catch(e: Exception) {
                Toast.makeText(activity," "+ e.message, Toast.LENGTH_LONG).show()
            }
        }
    }
    fun checkInt(str: String):Int {
        val num = when (str) {
            "one" -> 1
            "two" -> 2
            "to" -> 2
            "three" -> 3
            "four" -> 4
            "for" -> 4
            "five" -> 5
            "six" -> 6
            "seven" -> 7
            "eight" -> 8
            "nine" -> 9
            else ->  0
        }
        return num
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE_SPEECH_INPUT){
            if (data != null){
                val res : ArrayList<String> = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS) as ArrayList<String>
                val words = res[0].split("\\s".toRegex()).toTypedArray()
                Log.d("dwedwedq",words.size.toString())

                if (words.size == 4) {
                    if (words[0].toLowerCase() == "market") {
                        var num = 0
                        if (words[1].toIntOrNull() == null) {
                           num = checkInt(words[1])
                        } else {
                            num = words[1].toInt()
                        }
                        Log.d("dwedwedq",num.toString())
                        if (num == 0) {
                            Toast.makeText(activity, "Not a valid voice input:no market number found", Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            val table = binding.marketTable
                            var table_row = table.getChildAt(num - 1) as TableRow
                            var stock_view = (table_row.get(2) as TextView)
                            var market_num = (table_row.get(0) as TextView)
                            var current_stock = stock_view.text.toString()

                            if (words[2].toLowerCase() == "add" || words[2].toLowerCase() == "at") {
                                var voice_num = 0
                                if (words[3].toIntOrNull() == null) {
                                    voice_num = checkInt(words[3])
                                } else {
                                    voice_num = words[3].toInt()
                                }
                                var new_stock =
                                    Integer.parseInt(current_stock) + voice_num
                                stock_view.text = new_stock.toString()
                            } else if (words[2].toLowerCase() == "remove") {
                                var new_stock =
                                    Integer.parseInt(current_stock) - Integer.parseInt(words[3])
                                if (new_stock <= 0) {
                                    table.removeView(table_row)
                                    for (i in Integer.parseInt(market_num.text.substring(7)) - 1 until table.childCount) {
                                        var row = table.getChildAt(i) as TableRow

                                        val market_view = row.get(0) as TextView
                                        val market_num =
                                            Integer.parseInt((market_view).text.substring(7)) - 1
                                        market_view.text = "Market_" + market_num.toString()
                                    }
                                } else {
                                    stock_view.text = new_stock.toString()
                                }
                            } else {
                                Toast.makeText(
                                    activity,
                                    "Not a valid voice input: third word is not add or remove",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                        }
                    } else {
                        Toast.makeText(activity, "Not a valid voice input: first word not market", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }

}