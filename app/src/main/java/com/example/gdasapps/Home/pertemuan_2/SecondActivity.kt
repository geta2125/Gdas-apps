package com.example.gdasapps.Home.pertemuan_2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gdasapps.AuthActivity
import com.example.gdasapps.MainActivity
import com.example.gdasapps.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Komponen
        val inputNama: EditText = findViewById(R.id.inputNama)
        val btnSubmit: Button = findViewById(R.id.btnSubmit)
        val btnKembali: Button = findViewById(R.id.btnKembali)

        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        // SUBMIT
        btnSubmit.setOnClickListener {
            val nama = inputNama.text.toString()
            Log.d("SecondActivity", "Isi inputNama = $nama")

            Toast.makeText(this, "Anda klik Submit", Toast.LENGTH_SHORT).show()
        }

        // KEMBALI ke MainActivity
        btnKembali.setOnClickListener {
            finish()
        }
    }
}