package com.juancho1037.umadefoods.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.juancho1037.umadefoods.MainActivity
import com.juancho1037.umadefoods.R
import com.juancho1037.umadefoods.databinding.SplashActivityBinding
import java.util.*
import kotlin.concurrent.timerTask

class splashActivity : AppCompatActivity() {

    private lateinit var splashBinding: SplashActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = SplashActivityBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)

        val timer = Timer()
        timer.schedule(
            timerTask {
                goToMainActivity()
            }, 2000
        )
    }

    private fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}