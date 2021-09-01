package com.example.abdulla.session7

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.abdulla.databinding.ActivityUserRecyclerBinding
import com.example.abdulla.session7.model.User

class RecuclerAdapte : RecyclerView.Adapter<RecuclerAdapte.UserViewHolder>() {
    private var data : ArrayList<User> = arrayListOf()

    fun setData(list:ArrayList<User>)
    {
            this.data = list
        notifyDataSetChanged()

    }

    inner class UserViewHolder(private val binding: ActivityUserRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root){
            fun setUser(user:User)
            {
                binding.name.setText(user.name)
                binding.email.setText(user.email)
                binding.gender.setText(user.gender.name)
            }
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecuclerAdapte.UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ActivityUserRecyclerBinding.inflate(inflater,parent,false)
        return  UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = data[position]
        holder.setUser(user)

    }

    override fun getItemCount(): Int {
       return data.size
    }

}