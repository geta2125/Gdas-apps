package com.example.gdasapps

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gdasapps.databinding.ActivityMainBinding
import com.example.gdasapps.Home.pertemuan_2.SecondActivity
import com.example.gdasapps.Home.pertemuan_3.ThirdActivity
import com.example.gdasapps.Home.pertemuan_4.FourthActivity
import com.example.gdasapps.Home.pertemuan_5.FifthActivity
import com.example.gdasapps.Home.pertemuan_7.SevenActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        binding.btnToSecond.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)
            startActivity(intent)

            binding.btnToThird.setOnClickListener {
                val intent = Intent(this, ThirdActivity::class.java)
                intent.putExtra("name", "Politeknik Caltex Riau")
                intent.putExtra("from", "Rumbai")
                intent.putExtra("age", 25)
                startActivity(intent)
            }
            binding.btnToFourth.setOnClickListener {
                val intent = Intent(this, FourthActivity::class.java)
                intent.putExtra("name", "Politeknik Caltex Riau")
                intent.putExtra("from", "Rumbai")
                intent.putExtra("age", 25)
                startActivity(intent)
            }
            binding.btnToFifth.setOnClickListener {
                intent.putExtra("name", "Politeknik Caltex Riau")
                intent.putExtra("from", "Rumbai")
                intent.putExtra("age", 25)
                startActivity(intent)
                startActivity(Intent(this, FifthActivity::class.java))
            }
            binding.btnToSeven.setOnClickListener {
                intent.putExtra("name", "Politeknik Caltex Riau")
                intent.putExtra("from", "Rumbai")
                intent.putExtra("age", 25)
                startActivity(intent)
                startActivity(Intent(this, SevenActivity::class.java))
            }

            // LOGOUT
            binding.btnLogout.setOnClickListener {

                MaterialAlertDialogBuilder(this)
                    .setTitle("Logout")
                    .setMessage("Apakah ingin logout?")
                    .setPositiveButton("Ya") { _, _ ->

                        Toast.makeText(this, "Berhasil Logout", Toast.LENGTH_SHORT).show()

                        val editor = sharedPref.edit()
                        editor.clear()
                        editor.apply()

                        val intent = Intent(this, AuthActivity::class.java)
                        intent.flags =
                            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                        startActivity(intent)
                        finish()
                    }
                    .setNegativeButton("Tidak", null)
                    .show()
            }
        }
    }
}