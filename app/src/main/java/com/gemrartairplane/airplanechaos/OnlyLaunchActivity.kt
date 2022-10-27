package com.gemrartairplane.airplanechaos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.gemrartairplane.airplanechaos.databinding.ActivityOnlyLaunchBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class OnlyLaunchActivity : AppCompatActivity() {

    var counterForAlpha = 0.05f
    var diffForAlpha = 0.05f

    private var _binding: ActivityOnlyLaunchBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("ActivityMainBinding = null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            _binding = ActivityOnlyLaunchBinding.inflate(layoutInflater)
            setContentView(binding.root)

            initProgBar()
            cycleUpAndTextAlpha()
            Handler(Looper.myLooper()!!).postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }, SPLASH_SCREEN_TIME_FOR_LOAD)
        } catch (e: Exception) {
            makeError()
        }
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun initProgBar() {
        lifecycleScope.launch {
            for (progress in 1..100) {
                withContext(Dispatchers.Main) {
                    binding.progBarSplashScrn.progress = progress
                }
                delay(SPLASH_SCREEN_TIME_FOR_LOAD / 130)
            }
        }
    }

    companion object {
        private const val SPLASH_SCREEN_TIME_FOR_LOAD: Long = 2300
    }

    private fun cycleUpAndTextAlpha() {
        lifecycleScope.launch {
            while (true) {
                binding.tvLoading.alpha = counterForAlpha
                if (counterForAlpha >= 1f) {
                    diffForAlpha = -0.05f
                }
                if (counterForAlpha <= 0.1f) {
                    diffForAlpha = 0.05f
                }
                delay(60)
                counterForAlpha += diffForAlpha
            }
        }
    }

    private fun makeError(){
        Toast.makeText(
            this,
            "Oops something went wrong, please try again...",
            Toast.LENGTH_SHORT
        ).show()
    }
}