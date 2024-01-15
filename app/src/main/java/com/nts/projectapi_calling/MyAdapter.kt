package com.nts.projectapi_calling

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class MyAdapter(val context: Activity, val userList: List<User>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun getItemCount(): Int {

        return userList.size

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        //Create view holder If Adapter fail

        val itemView = LayoutInflater.from(context).inflate(R.layout.each_item, parent, false)
        return MyViewHolder(itemView)

    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem =userList[position]
        holder.firstName.text =currentItem.firstName
        holder.lastName.text = currentItem.lastName
        holder.emailId.text = currentItem.email
        holder.userName.text=currentItem.username

        //set Image
        Picasso.get().load(currentItem.image).into(holder.image);



    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //Create Vieew

        val firstName: TextView
        val lastName: TextView
        val emailId: TextView
        val userName: TextView
        val image: ImageView

        init {
            firstName = itemView.findViewById(R.id.firstName)
            lastName = itemView.findViewById(R.id.lastName)
            emailId = itemView.findViewById(R.id.emailId)
            userName = itemView.findViewById(R.id.userName)
            image = itemView.findViewById(R.id.img_View)
        }


    }

}