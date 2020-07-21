package com.example.toyproject2020mvvm.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.toyproject2020mvvm.R
import com.example.toyproject2020mvvm.databinding.ActivityMainBinding
import com.example.toyproject2020mvvm.viewmodel.MainViewModel
import com.example.toyproject2020mvvm.viewmodel.viewmodelfactory.MainViewModelFactory
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = mainViewModel
        binding.lifecycleOwner = this
        mainViewModel.toastField.observe(this, Observer {
            Toast.makeText(this, R.string.put_contents, Toast.LENGTH_SHORT).show()
        })
    }
}

