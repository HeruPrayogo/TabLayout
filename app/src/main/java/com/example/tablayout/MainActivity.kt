@file:Suppress("DEPRECATION")

package com.example.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.tablayout.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.title = "TabPager"
        supportActionBar?.elevation = 0.0f
        val adapter = TabAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        binding.viewPager.adapter = adapter

        binding.tabs.setupWithViewPager(binding.viewPager)
    }
    /* Untuk Memberi nama kepada viewPager */
    class TabAdapter(fm: FragmentManager, behavior: Int) : FragmentStatePagerAdapter(fm, behavior) {
        private val tabName : Array<String> = arrayOf("Home", "Status", "Profile")
        private val COUNT = 3

        override fun getItem(position: Int): Fragment = when (position) {
            0 -> HomeFragment()
            1 -> StatusFragment()
            2 -> ProfileFragment()
            else -> HomeFragment()
        }

        override fun getCount(): Int {
            return COUNT
        }
        override fun getPageTitle(position: Int): CharSequence? {
          return tabName.get(position)
        }
    }
    /* Untuk Menampilakn file menu */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.item, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
