package com.example.fragmenttest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fragmenttest.R
import com.example.fragmenttest.databinding.FragmentMainBinding
import com.example.fragmenttest.viewmodel.MainViewModel

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        setupViewModel()
        return binding.apply {
            viewModel = this@MainFragment.viewModel
        }.root
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider.NewInstanceFactory().create(MainViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        setupTextClicked()
    }

    private fun setupTextClicked() {
        viewModel.textCount.observe(viewLifecycleOwner) { count ->
            Toast.makeText(requireActivity(), count.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}