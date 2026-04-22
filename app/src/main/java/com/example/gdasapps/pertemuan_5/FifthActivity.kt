package com.example.gdasapps.pertemuan_5

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gdasapps.R
import com.google.android.material.card.MaterialCardView

class FifthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fifth)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
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
        val btnWebView = findViewById<Button>(R.id.btnWebView)
        btnWebView.setOnClickListener {

            // animasi klik
            btnWebView.animate()
                .scaleX(0.95f)
                .scaleY(0.95f)
                .setDuration(100)
                .withEndAction {
                    btnWebView.animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .duration = 100
                }

            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)

            Toast.makeText(this, "Membuka WebView...", Toast.LENGTH_SHORT).show()
        }

        // =========================
        // CARD MODERN (UI APP)
        // =========================
        val cardWebView = findViewById<MaterialCardView>(R.id.cardWebView)
        cardWebView.setOnClickListener {

            // animasi klik card
            cardWebView.animate()
                .scaleX(0.97f)
                .scaleY(0.97f)
                .setDuration(100)
                .withEndAction {
                    cardWebView.animate()
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
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
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