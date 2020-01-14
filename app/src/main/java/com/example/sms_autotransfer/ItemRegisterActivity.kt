package com.example.sms_autotransfer

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_item_register.*
import kotlinx.android.synthetic.main.tel_items.*


class ItemRegisterActivity : AppCompatActivity() {
    val list = mutableListOf<LogRegisterViewModel>(

    )
    val adapter = LogRegisterViewAdapter(this,R.layout.tel_item,list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_register)
        registerView.adapter = adapter
        registerView.setHasFixedSize(true)
        registerView.layoutManager =  GridLayoutManager(this,1, RecyclerView.VERTICAL,false)
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.tel_items,telView,true)

        btinsert.setOnClickListener({
            val receNumber = txtSetReceNumber.text.toString()
            val receName = txtSetReceName.text.toString()
            val tranNumber = txtSetTransNumber.text.toString()
            val tranName = txtSetTransName.text.toString()
            list.add(LogRegisterViewModel(R.drawable.receive_sms,receNumber,receName,R.drawable.exchange,R.drawable.send_sms,tranNumber,tranName))
            adapter.notifyDataSetChanged()

        })

        btdelete.setOnClickListener({
            if(list.size > 0 ){

                list.removeAt(list.lastIndex)
                adapter.notifyDataSetChanged()
            }
        })


    }
}
