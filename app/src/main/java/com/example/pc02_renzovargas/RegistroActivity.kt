package com.example.pc02_renzovargas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.FirebaseFirestore

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val txtName: EditText = findViewById(R.id.txtName)
        val txtAnio: EditText = findViewById(R.id.txtAnio)
        val txtTitulos: EditText = findViewById(R.id.txtTitul)
        val txtImg: EditText = findViewById(R.id.txtImg)
        val btnSave: Button = findViewById(R.id.btnSave)

        val db = FirebaseFirestore.getInstance()
        val collectionRef = db.collection("liga1")
        val auth = FirebaseFirestore.getInstance()

        btnSave.setOnClickListener {
            val name = txtName.text.toString()
            val anio = txtAnio.text.toString()
            val tit = txtTitulos.text.toString()
            val img = txtImg.text.toString()

            db.collection("liga1")
                .addSnapshotListener(this){task, e ->
                    if(e!=null){
                        Snackbar
                            .make(
                                findViewById(android.R.id.content)
                                ,"Ingreso de datos exitosos"
                                , Snackbar.LENGTH_LONG
                            ).show()
                    }else {
                        Snackbar
                            .make(
                                findViewById(android.R.id.content)
                                ,"Credenciales inválidas"
                                , Snackbar.LENGTH_LONG
                            ).show()
                        startActivity(Intent(this, ListadoActivity::class.java))
                    }
                }
        }
    }
}