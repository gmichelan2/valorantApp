package com.example.valorantapp.ui.agents

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.valorantapp.model.Agent
import com.example.valorantapp.ui.adapters.AgentsAdapter

@BindingAdapter("items")
fun RecyclerView.setItems(agents: List<Agent>?){
    if(agents != null){
        (adapter as? AgentsAdapter)?.setList(agents)
    }
}