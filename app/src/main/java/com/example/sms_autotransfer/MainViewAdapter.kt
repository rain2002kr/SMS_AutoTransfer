package com.example.sms_autotransfer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.main_item.view.*
import kotlinx.android.synthetic.main.tel_item.view.*

class MainViewAdapter (val context: Context , val intId:Int, val list:List<MainViewModel>): RecyclerView.Adapter<MainViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(intId,parent,false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    interface ItemClickListener{
        fun onClick(view : View, position:Int)
    }

    private lateinit var itemClickListener : ItemClickListener

    fun setItemClickListener(itemClickListener : ItemClickListener){
        this.itemClickListener=itemClickListener
    }


    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.containerView.imageView.setImageResource(list[position].imageId)
        holder.containerView.textView.text=list[position].subject
        holder.containerView.textView2.text=list[position].subject2

        holder.containerView.setOnClickListener({
            itemClickListener.onClick(it,position)
        })


    }
}

class LogRegisterViewAdapter  (val context: Context , val intId:Int, val list:List<LogRegisterViewModel>): RecyclerView.Adapter<MainViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(intId,parent,false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.containerView.imgReceiver.setImageResource(list[position].imgReceiver)
        holder.containerView.imgRotate.setImageResource(list[position].imgRotate)
        holder.containerView.imgTransfer.setImageResource(list[position].imgTransfer)

        holder.containerView.txtReceNumber.text=list[position].receiveNumber
        holder.containerView.txtReceName.text=list[position].receiveName
        holder.containerView.txtTransNumber.text=list[position].transNumber
        holder.containerView.txtTransName.text=list[position].transName


    }
}



