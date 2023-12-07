package com.example.kotlin5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin5.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private val manga = mutableListOf<Manga>()
    private val magaListAdapter = MangaListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fillMagaList()
        setupRecyclerView()
    }

    private fun fillMagaList() {
        manga.apply {
            add(Manga(R.drawable.img_2, "Поднятие уровня в одиночкук"))
            add(Manga(R.drawable.img, "Oднажды я стала принцессой пинтерест"))
            add(Manga(R.drawable.img_1, "Ветролом"))
            add(Manga(R.drawable.img_3, "Приемная дочь протагониста"))
            add(Manga(R.drawable.img_4, "Bторой брак императрицы"))
        }
    }

    private fun setupRecyclerView() {
        binding.manga.adapter = magaListAdapter
        magaListAdapter.setData(manga)

    }
}