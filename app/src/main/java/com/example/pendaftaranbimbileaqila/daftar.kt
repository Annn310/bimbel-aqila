package com.example.pendaftaranbimbileaqila

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pendaftaranbimbileaqila.databinding.ActivityDaftarBinding

class daftar : AppCompatActivity() {
    private lateinit var binding: ActivityDaftarBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tvHaventAccount.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}