package com.example.recyclerview_practice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_view.view.*

class Adapter (private val todos: MutableList<Todo>): RecyclerView.Adapter<Adapter.TodoViewHolder>() {

    class TodoViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val textView: TextView = itemView.findViewById(R.id.tv_item1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currTodo = todos[position]
        holder.itemView.apply {
            tv_item1.text = currTodo.title
        }
    }

    override fun getItemCount() = todos.size

    fun addTodos(todo:Todo) {
        todos.add(todo)
        notifyItemInserted(todos.size - 1)
    }

    fun clearList() {
        todos.clear()
        notifyDataSetChanged()
    }

}