package com.example.sms_autotransfer

import android.content.Context
import android.content.Intent
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
        MainViewModel(R.drawable.network, "전송 리스트","자동전송 정보를 저장하는 화면입니다."),
        MainViewModel(R.drawable.log, "전송 내역","자동전송된 문자 내역을 확인하는 화면입니다."),
        MainViewModel(R.drawable.sms, "문자 보내기","문자를 전송할수있는 화면입니다."),
        MainViewModel(R.drawable.info, "정보","버전을 확인 할수있습니다.")
    )
    val adapter = MainViewAdapter(this, R.layout.main_item, list)
    val versionInfo = mapOf(
                                        "version" to "1.0.0",
                                        "update" to "2020.01.14",
                                         "comment" to "update UI"


    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        container_main.adapter = adapter
        adapter.setItemClickListener(object  : MainViewAdapter.ItemClickListener{
            val contexts = applicationContext

            override fun onClick(view: View, position: Int) {
                Log.d("SSS", "${position}번 리스트 선택")

                screenChagne(position)
                if(position == 3){

                    Toast.makeText(contexts, "${versionInfo}", Toast.LENGTH_SHORT).show()
                }
            }
        })


        container_main.setHasFixedSize(true)
        container_main.layoutManager = GridLayoutManager(this,1,RecyclerView.VERTICAL,false)

    }

    fun screenChagne(pos:Int){

        when(pos){
            0 -> {
                val intent = Intent(this, ItemRegisterActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                startActivity(intent)
            }
            1 -> {
                val intent = Intent(this, ItemLogActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                startActivity(intent)
            }
            2 -> {
                val intent = Intent(this, SMSActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                startActivity(intent)
            }
        }
    }


}

