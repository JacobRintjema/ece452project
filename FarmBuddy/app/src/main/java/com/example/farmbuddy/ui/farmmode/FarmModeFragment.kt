package com.example.farmbuddy.ui.farmmode

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.speech.RecognizerIntent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.farmbuddy.databinding.FragmentFarmModeBinding
import java.lang.Exception
import java.util.Locale
import java.util.Objects

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

        val textView: TextView = binding.tvText
        farmModeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }


    private  val REQUEST_CODE_SPEECH_INPUT = 1
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FarmModeViewModel::class.java)
        // TODO: Use the ViewModel
        val button = binding.imgMic
        button.setOnClickListener{
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE_SPEECH_INPUT){
            if (data != null){
                val res : ArrayList<String> = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS) as ArrayList<String>
                val tv_text: TextView = binding.realTv
                tv_text.text = Objects.requireNonNull(res[0])
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}