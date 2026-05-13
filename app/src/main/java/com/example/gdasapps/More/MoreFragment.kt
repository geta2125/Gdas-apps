package com.example.gdasapps.More

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.gdasapps.databinding.FragmentMoreBinding

class MoreFragment : Fragment() {

    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!

    // DATA LIST
    private val dataListWithDesc = listOf(
        mapOf("title" to "Kotlin", "desc" to "Bahasa untuk Android modern"),
        mapOf("title" to "Java", "desc" to "Bahasa OOP yang populer"),
        mapOf("title" to "Python", "desc" to "Bahasa yang mudah dipahami"),
        mapOf("title" to "C++", "desc" to "Bahasa performa tinggi"),
        mapOf("title" to "JavaScript", "desc" to "Bahasa untuk Web Development"),
        mapOf("title" to "Dart", "desc" to "Bahasa utama Flutter"),
        mapOf("title" to "Swift", "desc" to "Bahasa untuk iOS"),
        mapOf("title" to "Go", "desc" to "Bahasa ringan dari Google"),
        mapOf("title" to "PHP", "desc" to "Bahasa backend website")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TOOLBAR
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)

        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "More"
        }

        // ADAPTER
        val adapter = SimpleAdapter(
            requireContext(),
            dataListWithDesc,
            android.R.layout.simple_list_item_2,
            arrayOf("title", "desc"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )

        // SET ADAPTER
        binding.listViewItems.adapter = adapter

        // CLICK ITEM
        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->

            val selectedItem = dataListWithDesc[position]

            val title = selectedItem["title"]
            val desc = selectedItem["desc"]

            Toast.makeText(
                requireContext(),
                "Kamu memilih: $title ($desc)",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}