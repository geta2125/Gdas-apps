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
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gdasapps.AuthActivity
import com.example.gdasapps.Data.model.PhotoApiClient
import com.example.gdasapps.Home.pertemuan_10.TenthActivity
import com.example.gdasapps.Home.pertemuan_2.SecondActivity
import com.example.gdasapps.Home.pertemuan_3.ThirdActivity
import com.example.gdasapps.Home.pertemuan_4.FourthActivity
import com.example.gdasapps.Home.pertemuan_5.FifthActivity
import com.example.gdasapps.Home.pertemuan_7.SevenActivity
import com.example.gdasapps.Home.pertemuan_9.NinthActivity
import com.example.gdasapps.Home.photo.PhotoAdapter
import com.example.gdasapps.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.launch

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
        binding.btnToNinth.setOnClickListener {
            startActivity(Intent(requireContext(), NinthActivity::class.java))
        }
        binding.btnToTenth.setOnClickListener {
            startActivity(Intent(requireContext(), TenthActivity::class.java))
        }
        loadPhoto()

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
    private fun loadPhoto() {
        lifecycleScope.launch {
            try {
                val photos = PhotoApiClient.apiService.getPhotos()
                val adapter = PhotoAdapter(photos)
                binding.rvGallery.adapter = adapter

                /** 1. Atur agar tampil secara Horizontal */
                binding.rvGallery.layoutManager = LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.HORIZONTAL,
                    false
                )

                /** 2. Matikan nested scroll bawaan RecyclerView */
                // Ini wajib agar RecyclerView tidak berebut kendali scroll dengan NestedScrollView utama
                binding.rvGallery.isNestedScrollingEnabled = false

            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Gagal memuat gambar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}