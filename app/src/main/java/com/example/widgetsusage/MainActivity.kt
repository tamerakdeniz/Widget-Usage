package com.example.widgetsusage

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.widgetsusage.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var control = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toggleButton.addOnButtonCheckedListener { group, checkedId, isChecked ->
            control = isChecked
            if(isChecked) {
                val selectedButton = findViewById<Button>(checkedId)
                val buttonString = selectedButton.text.toString()
                Log.e("Result", buttonString)
            }
        }

        val countries = ArrayList<String>()
        countries.add("Türkiye")
        countries.add("İtalya")
        countries.add("Japonya")
        countries.add("Malta")
        countries.add("Tameronya")

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,countries)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)

        binding.buttonShow.setOnClickListener {
            if(control) {
                val selectedButton = findViewById<Button>(binding.toggleButton.checkedButtonId)
                val buttonString = selectedButton.text.toString()
                Log.e("Result ( Show )", buttonString)
            }
            val selectedCountry = binding.autoCompleteTextView.text.toString()
            Log.e("Result", selectedCountry)

        }

        binding.buttonAlert.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Header")
                .setMessage("Message")
                .setPositiveButton("Ok") {d,i ->
                    Toast.makeText(this,"Ok button clicked.",Toast.LENGTH_SHORT).show()

                }
                .setNegativeButton("Cancel") {d,i ->
                    Toast.makeText(this,"Cancel button clicked.",Toast.LENGTH_SHORT).show()

                }
                .show()
        }
    }
}