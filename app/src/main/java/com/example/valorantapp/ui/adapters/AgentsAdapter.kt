package com.example.valorantapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.valorantapp.databinding.AgentsItemBinding
import com.example.valorantapp.modules.Agent

class AgentsAdapter(private val agentsList: List<Agent>) : RecyclerView.Adapter<AgentsAdapter.AgentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentViewHolder {
        val binding = AgentsItemBinding.inflate(LayoutInflater.from(parent.context),parent, false )
        return AgentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AgentViewHolder, position: Int) {
        holder.bind(agentsList[position])
    }

    override fun getItemCount(): Int = agentsList.size
    
    class AgentViewHolder(private val binding: AgentsItemBinding) : ViewHolder(binding.root){
        fun bind(agent: Agent){

        }
    }
}