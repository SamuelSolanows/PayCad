package com.example.paycad2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.paycad2.databinding.ActivityIdentificationBinding

class Identification : AppCompatActivity() {
    lateinit var binding: ActivityIdentificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIdentificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var num1 = intent.getStringExtra("num1")
        var num2 = intent.getStringExtra("num2")
        var num3 = intent.getStringExtra("num3")
        var num4 = intent.getStringExtra("num4")
        var num5 = intent.getStringExtra("num5")

        binding.apply {
            back.setOnClickListener {
                startActivity(Intent(this@Identification, Generation_Code::class.java))

            }

            button.setOnClickListener {
                if (txtname.text!!.isEmpty() || txtsaldo.text!!.isEmpty()) {
                    Toast.makeText(this@Identification, "Campos nesesarios para seguir", Toast.LENGTH_SHORT).show()
                } else {
                    startActivity(Intent(this@Identification, Verification::class.java).putExtra("num1", num1).putExtra("num2", num2).putExtra("num3", num3).putExtra("num4", num4).putExtra("num5", num5).putExtra("name",txtname.text).putExtra("saldo",txtsaldo.text.toString()))
                }
            }


        }
    }
}
