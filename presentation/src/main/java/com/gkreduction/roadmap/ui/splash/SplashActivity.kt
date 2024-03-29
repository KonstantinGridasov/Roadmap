package com.gkreduction.roadmap.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.gkreduction.roadmap.R
import com.gkreduction.roadmap.ui.main.MainActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onStart() {
        super.onStart()
        timer()
    }

    private fun timer() {
        val timer = object : CountDownTimer(1000, 500) {
            override fun onFinish() {
                navigationToMain()
            }

            override fun onTick(p0: Long) {
            }
        }
        timer.start()
    }

    fun navigationToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()

    }
}