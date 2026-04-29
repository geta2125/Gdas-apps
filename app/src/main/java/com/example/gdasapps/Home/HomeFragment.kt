package com.example.gdasapps.Home

import android.content.Intent
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.gdasapps.AuthActivity
import com.example.gdasapps.Home.pertemuan_2.SecondActivity
import com.example.gdasapps.Home.pertemuan_3.ThirdActivity
import com.example.gdasapps.Home.pertemuan_4.FourthActivity
import com.example.gdasapps.Home.pertemuan_5.FifthActivity
import com.example.gdasapps.Home.pertemuan_7.SevenActivity
import com.example.gdasapps.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var sharedPref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPref = requireActivity().getSharedPreferences("session_user", MODE_PRIVATE)

        binding.btnToSecond.setOnClickListener {
            startActivity(Intent(requireContext(), SecondActivity::class.java))
        }

        binding.btnToThird.setOnClickListener {
            startActivity(Intent(requireContext(), ThirdActivity::class.java))
        }

        binding.btnToFourth.setOnClickListener {
            startActivity(Intent(requireContext(), FourthActivity::class.java))
        }

        binding.btnToFifth.setOnClickListener {
            startActivity(Intent(requireContext(), FifthActivity::class.java))
        }

        binding.btnToSeven.setOnClickListener {
            startActivity(Intent(requireContext(), SevenActivity::class.java))
        }

        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah ingin logout?")
                .setPositiveButton("Ya") { _, _ ->

                    Toast.makeText(requireContext(), "Berhasil Logout", Toast.LENGTH_SHORT).show()

                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()

                    val intent = Intent(requireContext(), AuthActivity::class.java)
                    intent.flags =
                        Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                    startActivity(intent)
                    requireActivity().finish()
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }
}