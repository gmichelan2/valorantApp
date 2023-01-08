package com.example.valorantapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.valorantapp.databinding.AgentAbilityItemBinding
import com.example.valorantapp.model.Ability
import com.example.valorantapp.tools.setHttpImage

class AbilityAdapter(private val abilityList: List<Ability>) :
    RecyclerView.Adapter<AbilityAdapter.AbilityViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AbilityAdapter.AbilityViewHolder {
        val binding =
            AgentAbilityItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AbilityViewHolder(binding)

    }

    override fun onBindViewHolder(holder: AbilityAdapter.AbilityViewHolder, position: Int) {
        holder.bind(abilityList[position])
    }

    override fun getItemCount(): Int = abilityList.size

    inner class AbilityViewHolder(private val binding: AgentAbilityItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(ability: Ability) {
            with(binding){
                abilityImage.setHttpImage(ability.displayIcon)
                abilityTitle.text = ability.displayName
                abilityDescription.text = ability.description
            }
        }
    }
}