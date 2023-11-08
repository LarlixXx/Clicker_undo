package com.clicker.qwr.tqwt


import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.clicker.qwr.tqwt.MainActivity.Companion.changeClicksForClick
import com.clicker.qwr.tqwt.MainActivity.Companion.countClicks
import com.clicker.qwr.tqwt.databinding.UpgMenuBinding

class upg_menu : AppCompatActivity() {
    private lateinit var binding: UpgMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UpgMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            clicksCountUpgText.text = countClicksOnBalance(resources)

            upg1Button.setOnClickListener {
                upgradeFun(25, 1)
                clicksCountUpgText.text = countClicksOnBalance(resources)

            }
            upg2Button.setOnClickListener {
                upgradeFun(100, 3)
                clicksCountUpgText.text = countClicksOnBalance(resources)

            }
            upg3Button.setOnClickListener {
                upgradeFun(500, 10)
                clicksCountUpgText.text = countClicksOnBalance(resources)

            }
            upg4Button.setOnClickListener {
                upgradeFun(1500, 30)
                clicksCountUpgText.text = countClicksOnBalance(resources)

            }
            upg5Button.setOnClickListener {
                upgradeFun(2500, 50)
                clicksCountUpgText.text = countClicksOnBalance(resources)

            }
            upg6Button.setOnClickListener {
                upgradeFun(4000, 150)
                clicksCountUpgText.text = countClicksOnBalance(resources)

            }
            upg7Button.setOnClickListener {
                upgradeFun(20000, 500)
                clicksCountUpgText.text = countClicksOnBalance(resources)

            }

            backToMainButton.setOnClickListener {
                onBackPressed()
            }

        }


    }

    companion object {
        fun countClicksOnBalance(resources: Resources): String {
            return resources.getString(
                R.string.clicks_on_balance,
                resources.getQuantityString(
                    R.plurals.clicks,
                    countClicks,
                    countClicks
                )
            )
        }

        fun countClicksForClicks(resources: Resources): String {
            return resources.getString(
                R.string.clicks_for_click,
                resources.getQuantityString(
                    R.plurals.clicks,
                    changeClicksForClick,
                    changeClicksForClick
                )
            )
        }
    }

    private fun upgradeFun(count: Int, change: Int) {
        if (countClicks >= count) {
            changeClicksForClick += change
            countClicks -= count
        }
    }
}
