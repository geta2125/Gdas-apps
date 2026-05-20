package com.example.gdasapps.Home.pertemuan_10

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gdasapps.R
import com.example.gdasapps.databinding.ActivityTenthBinding
import com.google.android.material.tabs.TabLayoutMediator

class TenthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTenthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding = ActivityTenthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->

            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        // Setup Toolbar
        setSupportActionBar(binding.toolbar)

        supportActionBar?.apply {
            title = "Halaman Tenth"
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        // Inisialisasi Adapter
        val tabsAdapter = TenthTabsAdapter(this)

        // Set adapter ke ViewPager2
        binding.viewPager.adapter = tabsAdapter

        // Hubungkan TabLayout dengan ViewPager2
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->

            when (position) {

                0 -> {
                    tab.text = "Tab A"

                    // Icon
                    tab.icon = ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_home
                    )

                    // Badge titik
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
                }

                1 -> {
                    tab.text = "Tab B"

                    // Icon
                    tab.icon = ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_home
                    )

                    // Badge angka
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
                    badge.number = 5
                }
                2 -> {
                    tab.text = "Tab C"

                    // Icon
                    tab.icon = ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_home
                    )

                    // Badge angka
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
                    badge.number = 10
                }
            }

        }.attach()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {

            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}