package com.tjoeun.a20191113_01_libraries

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

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

        mainBtnCall.setOnClickListener {
            var permissionListener = object : PermissionListener {
                override fun onPermissionGranted() {
                    var uri = Uri.parse("tel:${mainTxtPhoneNum.text.toString().replace("-","")}")
                    var intent = Intent(Intent.ACTION_CALL,uri)
                    startActivity(intent)
                }
                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext,"권한을 설정해야 전화 사용이 가능합니다.",Toast.LENGTH_SHORT).show()
                }
            }

            TedPermission.with(mContext)
                .setPermissionListener(permissionListener)
                .setRationaleMessage("전화 권한을 설정해야 바로 연결 가능합니다.")
                .setDeniedMessage("설정 > 권한에서 허용 가능합니다.")
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()
        }
    }

    override fun setValues() {
    }
}
