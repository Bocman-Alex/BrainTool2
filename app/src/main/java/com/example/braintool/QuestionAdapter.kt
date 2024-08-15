package com.example.braintool

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.braintool.databinding.QuestionItemBinding

class QuestionAdapter :RecyclerView.Adapter<QuestionAdapter.QuestionHolder>(){
    val questList = ArrayList<Question>()
    class QuestionHolder(item:View) :RecyclerView.ViewHolder(item){
        val binding = QuestionItemBinding.bind(item)
        fun bind(question: Question)= with(binding){
            theQuestion.text=question.quest

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.question_item,parent,false)
        return QuestionHolder(view)
    }

    override fun getItemCount(): Int {
        return questList.size
    }

    override fun onBindViewHolder(holder: QuestionHolder, position: Int) {
        holder.bind(questList[position])
    }
    fun addQuestion(question: Question){
        questList.add(question)
        notifyDataSetChanged()
    }
}