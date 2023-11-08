package com.clicker.qwr.tqwt

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.clicker.qwr.tqwt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        var countClicks = 0
        var changeClicksForClick = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.img.setOnClickListener {
            countClicks += changeClicksForClick
            binding.textCountClicks.text = upg_menu.countClicksOnBalance(resources)
            binding.textClicksForClick.text = upg_menu.countClicksForClicks(resources)


        }
        binding.buttonClickUpg.setOnClickListener {
            val upgradeIntent = Intent(this, upg_menu::class.java)
            startActivity(upgradeIntent)
        }
    }

    override fun onResume() {
        super.onResume()
        binding.textCountClicks.text = upg_menu.countClicksOnBalance(resources)
        binding.textClicksForClick.text = upg_menu.countClicksForClicks(resources)
    }
}




