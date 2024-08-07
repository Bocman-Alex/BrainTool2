package com.example.braintool

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.braintool.databinding.GroupViewBinding

class GroupAdapter :RecyclerView.Adapter<GroupAdapter.GroupHolder>(){
    val groupList = ArrayList<Group>()
    class GroupHolder(item:View): RecyclerView.ViewHolder (item){
            val binding =GroupViewBinding.bind(item)
        fun bind(group: Group) = with(binding){
            tvTitle.text=group.title           //////

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.group_view, parent,false)
        return GroupHolder(view)
    }

    override fun getItemCount(): Int {
        return groupList.size
    }

    override fun onBindViewHolder(holder: GroupHolder, position: Int) {
        holder.bind(groupList[position])
    }


    fun addGroup(group: Group){
        groupList.add(group)
        notifyDataSetChanged()
    }

}