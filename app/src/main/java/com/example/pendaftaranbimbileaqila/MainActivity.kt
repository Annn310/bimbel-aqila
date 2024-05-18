package com.example.pendaftaranbimbileaqila



import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pendaftaranbimbileaqila.databinding.ActivityDaftarBinding
import com.example.pendaftaranbimbileaqila.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMasuk.setOnClickListener {
            startActivity(Intent(this, Dasboard::class.java))
        }
    }

}