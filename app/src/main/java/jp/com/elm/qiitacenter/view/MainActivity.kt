package jp.com.elm.qiitacenter.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pager = findViewById<ViewPager>(R.id.pager)
        setPagerInfo(pager)
    }

    private fun setPagerInfo(pager : ViewPager){
        pager.adapter = PageAdapter(supportFragmentManager)
    }
}