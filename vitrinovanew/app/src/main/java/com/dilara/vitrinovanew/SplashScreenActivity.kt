package com.dilara.vitrinovanew


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.dilara.vitrinovanew.ui.main.MainActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val backgroundImg:ImageView=findViewById(R.id.iv_logo)
        val slideAnimation=AnimationUtils.loadAnimation(this,R.anim.slide)
        backgroundImg.startAnimation(slideAnimation)
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        },3000)
    }
}