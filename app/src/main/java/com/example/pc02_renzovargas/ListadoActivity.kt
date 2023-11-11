package com.example.pc02_renzovargas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pc02_renzovargas.adapter.EquipoAdapter
import com.example.pc02_renzovargas.model.EquiposModel
import com.google.firebase.firestore.FirebaseFirestore

class ListadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado)

        val rvEquipo = findViewById<RecyclerView>(R.id.rvEquipos)

        val db = FirebaseFirestore.getInstance()
        var lstEquipo: List<EquiposModel>

        db.collection("liga1")
            .addSnapshotListener{snap, e->
                if(e != null){
                    Log.i("ERROR", "Ocurrió un error")
                    return@addSnapshotListener
                }

                lstEquipo = snap!!.documents.map { document ->
                    EquiposModel(
                        document["nombreequipo"].toString(),
                        document["anio"].toString(),
                        document["titulos"].toString(),
                        document["url"].toString()
                    )
                }

                rvEquipo.adapter = EquipoAdapter(lstEquipo)
                rvEquipo.layoutManager = LinearLayoutManager(this)

            }
    }
}
