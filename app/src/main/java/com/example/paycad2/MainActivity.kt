package com.example.paycad2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.paycad2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fullPantalla()
        CuentaRegrsiva()
    }




    private fun CuentaRegrsiva() {
        object : CountDownTimer(10000, 1000) {
            var time = 10
            override fun onTick(millisUntilFinished: Long) {
                binding.txttiempo.text = time.toString() + "s"
                time -= 1
            }

            override fun onFinish() {
                startActivity(Intent(this@MainActivity, About::class.java))
                finish()
            }
        }.start()
    }


    fun fullPantalla() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, window.decorView).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }


}