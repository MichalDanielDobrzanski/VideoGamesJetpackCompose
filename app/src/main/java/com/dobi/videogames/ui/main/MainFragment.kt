package com.dobi.videogames.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.dobi.videogames.MainActivityViewModel
import com.dobi.videogames.R

class MainFragment : Fragment() {

    private val activityViewModel: MainActivityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.main_fragment, container, false).apply {
        findViewById<View>(R.id.button).setOnClickListener {
            activityViewModel.increment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("MMDO", "At: ${this.hashCode()}")

        activityViewModel.counterLiveData.observe(viewLifecycleOwner) {
            Log.d("MMDO", "Got: $it")
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}