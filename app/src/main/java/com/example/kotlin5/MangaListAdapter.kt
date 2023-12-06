package com.example.kotlin5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin5.databinding.ItemMangaBinding

class MangaListAdapter : RecyclerView.Adapter<MangaListAdapter.MangaViewHolder>() {

    private var manga = listOf<Manga>()

    fun setData(data: List<Manga>) {
        manga = data
    }

    class MangaViewHolder(private val binding: ItemMangaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBing(manga: Manga) = with(binding) {
            magaView.setImageResource(manga.image)
            mangaTitle.text = manga.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaViewHolder {
        val binding = ItemMangaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MangaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MangaViewHolder, position: Int) {
        holder.onBing(manga[position])
    }

    override fun getItemCount(): Int {
        return manga.size

    }
}