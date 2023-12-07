package com.example.kotlin5

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import com.example.kotlin5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var count = 0
    private var image: String? = null

    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) {
        binding.viev.setImageURI(it)
        Problems.galleryState = binding.viev.drawable.toBitmap()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState != null) {
            Log.e("TAG", "onCreate: save pictures $savedInstanceState")
        }
        if (savedInstanceState != null) {
            val savedCount = savedInstanceState.getInt(COUNT_KEY)
            Log.e("TAG", "onCreate: ${Problems.count}")
            Problems.count = savedCount
        }

        binding.viev.setImageBitmap(Problems.galleryState)
        binding.tvCounter.text = Problems.count.toString()

        chooseImegeFromGallery()
        setCouter()
    }

    private fun chooseImegeFromGallery() = with(binding) {
        viev.setOnClickListener {
            getContent.launch("image/*")
        }
    }

    private fun setCouter() = with(binding) {
        btnIncrement.setOnClickListener {
            if (Problems.count >= 10) {
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                startActivity(intent)
            }
            tvCounter.text = (++Problems.count).toString()
        }
        btnDecrement.setOnClickListener {
            if (Problems.count > 0) {
                tvCounter.text = (--Problems.count).toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.apply {
            putInt(COUNT_KEY, Problems.count)
        }
    }

    companion object {
        const val COUNT_KEY = "count"
    }
}
