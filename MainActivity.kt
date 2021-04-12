package com.example.recyclerview_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoAdapter = Adapter(mutableListOf())

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = todoAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        btn_add.setOnClickListener {
            val todoTitle = et_title.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addTodos(todo)
                et_title.text.clear()
            }
        }

        btn_delete.setOnClickListener {
            todoAdapter.clearList()
        }
    }
}