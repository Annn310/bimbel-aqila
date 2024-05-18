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

class RegisterActyvity : AppCompatActivity() {
    lateinit var tv_register_title:TextView
    lateinit var  et_NamaSiswa:EditText
    lateinit var et_Alamat: EditText
    lateinit var  et_AsalSklh : EditText
    lateinit var  et_NamaAyah : EditText
    lateinit var et_NamaIbu : EditText
    lateinit var  et_Pekerjaan : EditText
    lateinit var  et_Nomor : EditText
    lateinit var  jenis_kelamin : AutoCompleteTextView
    lateinit var Kelas : AutoCompleteTextView
    lateinit var Mapel : AutoCompleteTextView
    lateinit var  program : AutoCompleteTextView
    lateinit var Hari : AutoCompleteTextView
    lateinit var jam : AutoCompleteTextView
    lateinit var tv_havent_account : AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_actyvity)

       tv_register_title=findViewById(R.id.tv_register_title)
        et_NamaSiswa=findViewById(R.id.et_NamaSiswa)
        et_Alamat=findViewById(R.id.et_Alamat)
        et_AsalSklh=findViewById(R.id.et_AsalSklh)
        et_NamaAyah=findViewById(R.id.et_NamaAyah)
        et_NamaIbu=findViewById(R.id.et_NamaIbu)
        et_Pekerjaan=findViewById(R.id.et_Pekerjaan)
        et_Nomor=findViewById(R.id.et_Nomor)
        jenis_kelamin=findViewById(R.id.jenis_kelamin)
        Kelas=findViewById(R.id.Kelas)
        Mapel=findViewById(R.id.Mapel)
        program=findViewById(R.id.program)
        Hari=findViewById(R.id.Hari)
        jam=findViewById(R.id.jam)
        tv_havent_account=findViewById(R.id.tv_havent_account)

        tv_register_title.visibility=View.GONE

        tv_havent_account.setOnClickListener {
            if (et_NamaSiswa.text.toString().isEmpty() or et_Alamat.text.toString().isEmpty() or
                et_AsalSklh.text.toString().isEmpty() or et_NamaAyah.text.toString().isEmpty() or
                et_NamaIbu.text.toString().isEmpty() or et_Pekerjaan.text.toString().isEmpty() or
                et_Nomor.text.toString().isEmpty() or jenis_kelamin.text.toString().isEmpty() or
                Kelas.text.toString().isEmpty() or Mapel.text.toString()
                    .isEmpty() or program.text.toString().isEmpty() or
                Hari.text.toString().isEmpty() or jam.text.toString().isEmpty()
            ) {
                Toast.makeText(this@RegisterActyvity, "Masukan Semua data", Toast.LENGTH_SHORT)
                    .show()
            } else {

                val url = "https://script.google.com/macros/s/AKfycbwwAp6l61vqT74BazmY9h6DOF5M5UKhewunH-UP560cYB14-mhzd_tkkio71Tj-HEm7/exec"
                val stringRequest = object : StringRequest(Request.Method.POST, url,
                    Response.Listener {
                        Toast.makeText(this@RegisterActyvity, it.toString(), Toast.LENGTH_SHORT)
                            .show()
                    },
                    Response.ErrorListener {
                        Toast.makeText(this@RegisterActyvity,it.toString(), Toast.LENGTH_SHORT).show()
                    }){
                    override fun getParams(): MutableMap<String, String> {
                        val params=HashMap<String,String>()
                        params["namaSiswa"]=et_NamaSiswa.text.toString()
                        params["alamat"]=et_Alamat.text.toString()
                        params["asalSekolah"]=et_AsalSklh.text.toString()
                        params["namaAyah"]=et_NamaAyah.text.toString()
                        params["namaIbu"]=et_NamaIbu.text.toString()
                        params["pekerjaan"]=et_Pekerjaan.text.toString()
                        params["nomorTelepon"]=et_Nomor.text.toString()
                        params["jenisKelamin"]=jenis_kelamin.text.toString()
                        params["kelas"]=Kelas.text.toString()
                        params["mapel"]=Mapel.text.toString()
                        params["program"]=program.text.toString()
                        params["permintaanHariLes"]=Hari.text.toString()
                        params["permintaanJamLes"]=jam.text.toString()
                        return params
                    }
                }
             val  queue=Volley.newRequestQueue(this@RegisterActyvity)
                queue.add(stringRequest)
            }
        }







            val jeniskelamin = listOf("Laki-laki", "Perempuan")
            val autoComplete: AutoCompleteTextView = findViewById(R.id.jenis_kelamin)
            val adapter = ArrayAdapter(this, R.layout.list_item, jeniskelamin)

            autoComplete.setAdapter(adapter)

            autoComplete.onItemClickListener =
                AdapterView.OnItemClickListener { adapterView, view, i, l ->

                    val Kelas = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
                    val autoComplete: AutoCompleteTextView = findViewById(R.id.Kelas)
                    val adapter = ArrayAdapter(this, R.layout.list_item, Kelas)

                    autoComplete.setAdapter(adapter)

                    autoComplete.onItemClickListener =
                        AdapterView.OnItemClickListener { adapterView, view, i, l ->

                            val Mapel = listOf("Semua Mapel", "Bahasa Inggris")
                            val autoComplete: AutoCompleteTextView = findViewById(R.id.Mapel)
                            val adapter = ArrayAdapter(this, R.layout.list_item, Mapel)

                            autoComplete.setAdapter(adapter)

                            autoComplete.onItemClickListener =
                                AdapterView.OnItemClickListener { adapterView, view, i, l ->

                                    val Program = listOf("Privat", "Reguler")
                                    val autoComplete: AutoCompleteTextView =
                                        findViewById(R.id.program)
                                    val adapter = ArrayAdapter(this, R.layout.list_item, Program)

                                    autoComplete.setAdapter(adapter)

                                    autoComplete.onItemClickListener =
                                        AdapterView.OnItemClickListener { adapterView, view, i, l ->


                                            val Hari = listOf(
                                                "Senin",
                                                "Selasa",
                                                "Rabu",
                                                "Kamis",
                                                "Jumat",
                                                "Sabtu"
                                            )
                                            val autoComplete: AutoCompleteTextView =
                                                findViewById(R.id.Hari)
                                            val adapter =
                                                ArrayAdapter(this, R.layout.list_item, Hari)

                                            autoComplete.setAdapter(adapter)

                                            autoComplete.onItemClickListener =
                                                AdapterView.OnItemClickListener { adapterView, view, i, l ->


                                                    val jam = listOf("15:00-16:30", "16:30-18:00", "18:30-20:00")
                                                    val autoComplete: AutoCompleteTextView =
                                                        findViewById(R.id.jam)
                                                    val adapter =
                                                        ArrayAdapter(this, R.layout.list_item, jam)

                                                    autoComplete.setAdapter(adapter)

                                                    autoComplete.onItemClickListener =
                                                        AdapterView.OnItemClickListener { adapterView, view, i, l ->

                                                        }

                                                }
                                        }
                                }
                        }
                }
        }
    }

