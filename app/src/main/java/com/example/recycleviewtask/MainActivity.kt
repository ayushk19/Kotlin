package com.example.recycleviewtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity(), UserProfileAdapter.OnItemClickListener{
    private val exampleList = generateDummyList()
    private val adapter = UserProfileAdapter(exampleList as ArrayList<User>, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val exampleList = generateDummyList()

        rv2.adapter = adapter
        rv2.layoutManager = LinearLayoutManager(this)



    }
    val list2 = ArrayList<User>()
    override fun onItemClick(position: Int) {
        val del_data = exampleList[position]
        exampleList.removeAt(position)
        adapter.notifyItemRemoved(position)
        list2 += del_data
        rv1.adapter = UserProfileAdapter(list2 as ArrayList<User>, this)
        rv1.layoutManager = LinearLayoutManager(this)
    }

    fun shuffle_data(view: View){
        exampleList.shuffle()
        rv2.adapter = adapter
        rv2.layoutManager = LinearLayoutManager(this)
    }


    private fun generateDummyList(): ArrayList<User> {

        var names = arrayOf("Ayush Singh", "Joe Raja", "Neeraj Kumar", "Virat Kohli", "Mitali Raj", "Raj Singh",
            "Suraj Pal", "Mohit Gautam", "Akshu Sharma", "MS Dhoni")
        val list = ArrayList<User>()
        for (i in names) {
            val drawable = R.drawable.profile
            val item = User(drawable, "$i")
            list += item
        }
        return list
    }
}