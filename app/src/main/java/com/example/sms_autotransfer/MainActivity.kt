package com.example.sms_autotransfer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val list = listOf<MainViewModel>(
        MainViewModel(R.drawable.network, "전송 리스트","내용이 없습니다."),
        MainViewModel(R.drawable.log, "전송 내역","내용이 없습니다."),
        MainViewModel(R.drawable.sms, "문자 보내기","내용이 없습니다.")

    )
    val adapter = MainViewAdapter(this, R.layout.main_item, list)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        container_main.adapter = adapter
        adapter.setItemClickListener(object  : MainViewAdapter.ItemClickListener{
            val contexts = applicationContext

            override fun onClick(view: View, position: Int) {
                Log.d("SSS", "${position}번 리스트 선택")
                Toast.makeText(contexts, "Clicked: ", Toast.LENGTH_SHORT).show()
            }
        })


        //container_main.setHasFixedSize(true)


        container_main.layoutManager = GridLayoutManager(this,1,RecyclerView.VERTICAL,false)



    }
}
