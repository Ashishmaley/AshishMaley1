package com.example.ashishmaley1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.ashishmaley1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),ViewPagerAdapter.OnboardingListener  {
    private var binding: ActivityMainBinding? = null
    private var viewPagerAdapter: ViewPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        val viewPager = binding!!.pager
        viewPagerAdapter = ViewPagerAdapter(this)
        viewPagerAdapter?.onboardingListener = this // Set the activity as the listener
        viewPager.adapter = viewPagerAdapter
    }
    override fun onNextClicked() {
        val viewPager=binding!!.pager
        val currentItem = viewPager.currentItem
        val nextPage = currentItem + 1
        if (nextPage < (viewPager.adapter?.count ?: 0)) {
            viewPager.currentItem = nextPage
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    fun ready(view: View) {
        startActivity(Intent(this,WelcomeActivity::class.java))
    }

}