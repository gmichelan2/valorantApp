package com.example.valorantapp.ui.adapters

import android.view.LayoutInflater
import com.example.valorantapp.databinding.BuddieItemBinding
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.valorantapp.model.Buddy
import com.example.valorantapp.tools.setHttpImage

class BuddiesAdapter(
    private var buddiesList: List<Buddy>
) : RecyclerView.Adapter<BuddiesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            BuddieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(buddiesList[position])
    }

    override fun getItemCount(): Int = buddiesList.size

    fun setList(buddyList: List<Buddy>){
        buddiesList = buddyList
        this.notifyDataSetChanged()
    }

    class ViewHolder(
        private val binding: BuddieItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(buddy: Buddy) {
            binding.buddieImage.setHttpImage(buddy.displayIcon)
        }
    }
}