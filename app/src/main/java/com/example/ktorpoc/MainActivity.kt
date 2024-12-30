package com.example.ktorpoc

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ktorpoc.databinding.ActivityMainBinding
import com.example.ktorpoc.module.viewModelModule
import com.example.ktorpoc.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewmodel : MainViewModel by viewModel()
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initViews()
        getObservers()
    }
    private fun initViews(){
        viewmodel.getResponse()
    }
    private fun getObservers(){
        viewmodel.response.observe(this,{
            Log.d(TAG, "getObservers: ${it.fact}")
            binding.factDetailsTV.text = it.fact
        })
    }
}