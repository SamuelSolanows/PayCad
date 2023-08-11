package com.example.paycad2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.paycad2.databinding.ActivityVerificationBinding

class Verification : AppCompatActivity() {
    lateinit var binding: ActivityVerificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var num1 = intent.getStringExtra("num1")
        var num2 = intent.getStringExtra("num2")
        var num3 = intent.getStringExtra("num3")
        var num4 = intent.getStringExtra("num4")
        var num5 = intent.getStringExtra("num5")
        var name = intent.getStringExtra("name")
        var saldo = intent.getStringExtra("saldo")


        binding.apply {
            generarcodi.setOnClickListener {
                startActivity(Intent(this@Verification, Generation_Code::class.java))
            }
            back.setOnClickListener {
                startActivity(Intent(this@Verification, Identification::class.java))
            }
            button.setOnClickListener {

                if (etxtnum1.text.toString() == num1 && etxtnum2.text.toString() == num2 && etxtnum3.text.toString() == num3 && etxtnum4.text.toString() == num4 && etxtnum5.text.toString() == num5) {
                    startActivity(Intent(this@Verification,Home::class.java).putExtra("nombre",name))
                }else{
                    Toast.makeText(this@Verification, "Codigo incorrecto", Toast.LENGTH_SHORT).show()
                }

            }
            txtName.setText("Hello $name!")


        }
    }
}