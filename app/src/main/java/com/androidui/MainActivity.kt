package com.androidui

import android.content.Intent
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.androidui.anim.AnimActivity
import com.androidui.customview.CustomViewActivity
import com.androidui.fragment.MyFragmentActivity
import com.androidui.gesture.GestureActivity
import com.androidui.draw.HuiTuActivity
import com.androidui.kotlin.KotlinStudyActivity
import com.androidui.supportlib.SupportLibUIActivity
import com.androidui.systemui.SystemUIActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 颜色对照表
 * https://www.sioe.cn/yingyong/yanse-rgb-16/
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCatalog.typeface = Typeface.createFromAsset(assets, "font/myfont.ttf")

        btnHuiTu.setOnClickListener {
            startActivity(Intent(this, HuiTuActivity::class.java))
            overridePendingTransition(R.anim.my_fade_in, R.anim.my_fade_out)
        }

        btnSystemUI.setOnClickListener {
            startActivity(Intent(this, SystemUIActivity::class.java))
            overridePendingTransition(R.anim.my_fade_in, R.anim.my_fade_out)
        }

        btnSupportLibUI.setOnClickListener {
            startActivity(Intent(this, SupportLibUIActivity::class.java))
            overridePendingTransition(R.anim.my_fade_in, R.anim.my_fade_out)
        }

        btnAnim.setOnClickListener {
            startActivity(Intent(this, AnimActivity::class.java))
            overridePendingTransition(R.anim.my_fade_in, R.anim.my_fade_out)
        }

        btnGesture.setOnClickListener {
            startActivity(Intent(this, GestureActivity::class.java))
            overridePendingTransition(R.anim.my_fade_in, R.anim.my_fade_out)
        }

        btnKotlin.setOnClickListener {
            startActivity(Intent(this, KotlinStudyActivity::class.java))
            overridePendingTransition(R.anim.my_fade_in, R.anim.my_fade_out)
        }

        btnCustomUI.setOnClickListener {
            startActivity(Intent(this, CustomViewActivity::class.java))
            overridePendingTransition(R.anim.my_fade_in, R.anim.my_fade_out)
        }

        btnFragment.setOnClickListener {
            startActivity(Intent(this, MyFragmentActivity::class.java))
            overridePendingTransition(R.anim.my_fade_in, R.anim.my_fade_out)
        }

    }
}
