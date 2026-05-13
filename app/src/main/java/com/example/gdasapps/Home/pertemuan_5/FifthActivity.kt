package com.example.gdasapps.Home.pertemuan_5

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gdasapps.R
import com.example.gdasapps.databinding.ActivityFifthBinding
import com.google.android.material.card.MaterialCardView

class FifthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFifthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding = ActivityFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            title = "Activity Fifth"
            subtitle = "Ini adalah subtitle"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }

        // =========
        // BUTTON
        // =========
        binding.btnWebView.setOnClickListener {

            binding.btnWebView.animate()
                .scaleX(0.95f)
                .scaleY(0.95f)
                .setDuration(100)
                .withEndAction {
                    binding.btnWebView.animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .duration = 100
                }

            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)

            Toast.makeText(this, "Membuka WebView...", Toast.LENGTH_SHORT).show()
        }

        // =========================
        // CARD MODERN
        // =========================
        binding.cardWebView.setOnClickListener {

            binding.cardWebView.animate()
                .scaleX(0.97f)
                .scaleY(0.97f)
                .setDuration(100)
                .withEndAction {
                    binding.cardWebView.animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .duration = 100
                }

            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)

            Toast.makeText(this, "Membuka WebView dari Card", Toast.LENGTH_SHORT).show()
        }

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

        // BUTTON KEMBALI
        binding.btnKembali.setOnClickListener {
            finish()
        }
    }

    // MENU
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // HANDLE MENU + BACK
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }

            R.id.action_search -> {
                Toast.makeText(this, "Fitur Search belum tersedia", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.action_settings -> {
                Toast.makeText(this, "Membuka Settings...", Toast.LENGTH_SHORT).show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}