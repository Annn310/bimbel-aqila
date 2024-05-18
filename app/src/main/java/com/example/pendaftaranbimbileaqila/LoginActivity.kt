package com.example.pendaftaranbimbileaqila


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


import com.example.pendaftaranbimbileaqila.databinding.ActivityLoginBinding



class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        emailFocusListener()

        passwordFocusListener()




        binding.btnLogin.setOnClickListener { submit() }



    }


    private fun submit()
    {

        binding.tilEmail.helperText = validEmail()
        binding.tilPassword.helperText = validPassword()

        val validEmail = binding.tilEmail.helperText == null
        val validPassword = binding.tilPassword.helperText == null
        var pesan = ""

        if (validEmail && validPassword)

            binding.btnLogin.setOnClickListener {
                startActivity(Intent(this, Dasboard::class.java))
                pesan = "Berhasil masuk"

                Toast.makeText(this," $pesan", Toast.LENGTH_SHORT).show()

            }

                else
                    infalidForm()


    }





    private fun infalidForm() {
        var message = ""

        if (binding.tilEmail.helperText != null)
            message += "\n\nEmail:" + binding.tilEmail.helperText

        if (binding.tilPassword.helperText != null)
            message += "\n\nPassword:" + binding.tilPassword.helperText

        AlertDialog.Builder(this)
            .setTitle("Terjadi Kesalahan")
            .setMessage(message)
            .setPositiveButton("Okay") { _, _ ->
                // do nothing
            }
            .show()
    }



    private fun emailFocusListener() {
        binding.etEmail.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.tilEmail.helperText = validEmail()

            }
        }
    }

    private fun validEmail(): String?
    {
        val onEmail = binding.etEmail.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(onEmail).matches())
        {
            return "Invalid Email Addres"

        }
            return null

    }
    private fun passwordFocusListener() {
        binding.etPassword.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.tilPassword.helperText = validPassword()

            }
        }
    }

    private fun validPassword(): String?
    {
        val etPassword = binding.etPassword.text.toString()
      if (etPassword.length < 8)
      {
          return "Minimum 8 Character Password"

      }

        return null

    }


    }



