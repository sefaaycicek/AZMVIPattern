package com.sirketismi.azmvipattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.sirketismi.azmvipattern.databinding.ActivityMainBinding
import com.sirketismi.azmvipattern.databinding.FragmentSecondBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        val title = arrayListOf("Tab-1", "Tab-2", "Tab-3")
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position->
            tab.text = title.getOrNull(position)
        }.attach()

    }
}