package com.example.pendaftaranbimbileaqila

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class absensi : AppCompatActivity() {
    lateinit var Absen_Guru: TextView
    lateinit var nama_guru: AutoCompleteTextView
    lateinit var keterangan_absensi: AutoCompleteTextView
    lateinit var btn_absensi: AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_absensi)

        Absen_Guru = findViewById(R.id.Absen_Guru)
        nama_guru = findViewById(R.id.nama_guru)
        keterangan_absensi = findViewById(R.id.keterangan_absensi)
        btn_absensi = findViewById(R.id.btn_absensi)

        Absen_Guru.visibility = View.GONE

        btn_absensi.setOnClickListener {
            if (nama_guru.text.toString().isEmpty() or keterangan_absensi.text.toString()
                    .isEmpty()
            ) {
                Toast.makeText(this@absensi, "Masukan Semua Data", Toast.LENGTH_SHORT)
                    .show()
            } else {

                val url = "https://script.google.com/macros/s/AKfycbxG5_uKATHJU9-v6iZavFBMhATZjNvdV7GF5nY4rztOx8DnZfgdVlcyDK-UlWA5U7DHJQ/exec"
                val stringRequest = object : StringRequest(Request.Method.POST, url,
                    Response.Listener {
                        Toast.makeText(this@absensi, it.toString(), Toast.LENGTH_SHORT)
                            .show()
                    },
                    Response.ErrorListener {
                        Toast.makeText(this@absensi, it.toString(), Toast.LENGTH_SHORT)
                            .show()
                    }) {
                    override fun getParams(): MutableMap<String, String> {
                        val params = HashMap<String, String>()
                        params["namaguru"] = nama_guru.text.toString()
                        params["keteranganAbsensi"] = keterangan_absensi.text.toString()
                        return params
                    }
                }
                val queue = Volley.newRequestQueue(this@absensi)
                queue.add(stringRequest)
            }
        }

        val namaGuru = listOf(
            "Contoh guru 1",
            "contoh guru 2",
            "contoh guru 3",
            "contoh guru 4",
            "contoh guru 5",
            "contoh guru 6",
            "contoh guru 7",
            "contoh guru 8",
            "contoh guru 9",
            "contoh guru 10"
        )
        val autoComplete: AutoCompleteTextView = findViewById(R.id.nama_guru)
        val adapter = ArrayAdapter(this, R.layout.list_item, namaGuru)

        autoComplete.setAdapter(adapter)

        autoComplete.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, view, i, l ->

                val keteranganabsensi = listOf("Absen Masuk", "Absen Keluar")
                val autoComplete: AutoCompleteTextView = findViewById(R.id.keterangan_absensi)
                val adapter = ArrayAdapter(this, R.layout.list_item, keteranganabsensi)

                autoComplete.setAdapter(adapter)
                autoComplete.onItemClickListener =
                    AdapterView.OnItemClickListener { adapterView, view, i, l ->

                    }
            }


    }
}