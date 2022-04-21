package com.example.recycleviewtask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserProfileAdapter(
    private val exampleList: ArrayList<User>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<UserProfileAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserProfileAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_layout,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return exampleList.size
    }

    override fun onBindViewHolder(holder: UserProfileAdapter.MyViewHolder, position: Int) {
        val currentItem = exampleList[position]

        holder.imageView.setImageResource(currentItem.profile_image)
        holder.user_name.text = currentItem.user_name
    }

    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val imageView: ImageView = itemView.findViewById(R.id.profilepic)
        val user_name: TextView = itemView.findViewById(R.id.User_profile)

        init {
            itemView.setOnClickListener(this)

        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }
    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }
}