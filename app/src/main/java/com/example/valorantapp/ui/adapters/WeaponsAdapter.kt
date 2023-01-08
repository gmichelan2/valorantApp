package com.example.valorantapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.valorantapp.databinding.WeaponItemBinding
import com.example.valorantapp.modules.Weapon
import com.example.valorantapp.tools.setHttpImage

class WeaponsAdapter(
    private var weaponsList: List<Weapon>
) : RecyclerView.Adapter<WeaponsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            WeaponItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(weaponsList[position])
    }

    override fun getItemCount(): Int = weaponsList.size

    fun setList(weaponList: List<Weapon>){
        weaponsList = weaponList
        this.notifyDataSetChanged()
    }

    class ViewHolder(
        private val binding: WeaponItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(weapon: Weapon) {
            with(binding){
                weaponImage.setHttpImage(weapon.displayIcon)
                weaponName.text = weapon.displayName
            }


        }
    }
}