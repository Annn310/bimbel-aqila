package com.example.pendaftaranbimbileaqila

import android.content.Intent
import android.media.tv.TvContract
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pendaftaranbimbileaqila.databinding.ActivityDasboardBinding
import com.example.pendaftaranbimbileaqila.databinding.ActivityMainBinding

class Dasboard : AppCompatActivity() {

    private lateinit var binding: ActivityDasboardBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDasboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.keluar.setOnClickListener {
            startActivity(Intent(this, ActivityMainBinding::class.java))
        }
        binding.pendaftaran.setOnClickListener {
            startActivity(Intent(this, RegisterActyvity::class.java))
        }
        binding.mapel1.setOnClickListener {
            startActivity(Intent(this, Jadwal::class.java))
        }
        binding.absen.setOnClickListener {
            startActivity(Intent(this, absensi::class.java))
        }
        binding.program.setOnClickListener {
            startActivity(Intent(this, Program::class.java))
        }
        binding.profil.setOnClickListener {
            startActivity(Intent(this, profil::class.java))
        }
    }
}