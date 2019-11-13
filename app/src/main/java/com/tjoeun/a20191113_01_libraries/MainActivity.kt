package com.tjoeun.a20191113_01_libraries

import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        var imgUrl = "https://img1.yna.co.kr/photo/yna/YH/2017/12/02/PYH2017120207500001300_P2.jpg"
        Glide.with(mContext).load(imgUrl).into(mainCirImg)
    }

    override fun setValues() {
    }
}
