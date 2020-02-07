package com.jineesoft.simpleviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

import com.jineesoft.simpleviewmodel.viewmodel.SimpleViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: SimpleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(SimpleViewModel::class.java)
        count_textView.text = viewModel.cnt.toString()
        plus_button.setOnClickListener {
            plusOne()
        }
    }

    private fun plusOne(){
        viewModel.cnt++
        count_textView.text = viewModel.cnt.toString()
    }
}
