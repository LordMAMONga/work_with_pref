package com.geeks.pref

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.geeks.pref.databinding.ActivityMainBinding
import com.geeks.pref.local.data.pref.Pref

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pref: Pref
    private var count = 0
    private var isIncrement = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = Pref(this)
        count = pref.getCount()

        if (count >= 10) {
            isIncrement = false
        } else if (count <= 0) {
            isIncrement = true
        }

        updateUI()

        binding.btnIncrement.setOnClickListener {
            incement()
        }
    }

    private fun incement() {
        if (isIncrement) {
            if (count < 10) {
                count++
            }
            if (count == 10) {
                isIncrement = false
            }
        } else {
            if (count > 0) {
                count--
            }
            if (count == 0) {
                isIncrement = true
            }
        }
        pref.saveCount(count)
        updateUI()
    }

    private fun updateUI() {
        binding.tvCount.text = count.toString()
        binding.btnIncrement.text = if (isIncrement) "+" else "-"
    }
}
