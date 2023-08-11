package com.example.paycad2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import com.example.paycad2.databinding.ActivityGenerationCodeBinding
import kotlin.random.Random

class Generation_Code : AppCompatActivity() {
    lateinit var binding: ActivityGenerationCodeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGenerationCodeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            button.setOnClickListener {
                startActivity(Intent(this@Generation_Code, Identification::class.java).putExtra("num1", txtnum1.text).putExtra("num2", txtnum2.text).putExtra("num3", txtnum3.text).putExtra("num4", txtnum4.text).putExtra("num5", txtnum5.text))
            }


            codigo_random()



            object : CountDownTimer(10000, 1000) {
                var time = 10
                override fun onTick(millisUntilFinished: Long) {
                    txttime.text = "  " + time.toString() + "s"
                    time -= 1
                }

                override fun onFinish() {
                    codigo_random()
                    time = 10
                    start()
                }
            }.start()
        }
    }

    private fun ActivityGenerationCodeBinding.codigo_random() {
        txtnum1.random();txtnum2.random();txtnum3.random();txtnum4.random();txtnum5.random()
    }


    fun TextView.random() {
        this.text = Random.nextInt(0, 10).toString()
    }
}