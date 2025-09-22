package br.unisanta.colecionador.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.colecionador.R
import br.unisanta.colecionador.adapter.ItemAdapter
import br.unisanta.colecionador.model.ItemDaoImpl

class ListaActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter
    private val dao = ItemDaoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = ItemAdapter(dao.obterItem().toMutableList()) { pos ->
            dao.deletarItem(dao.obterItem()[pos].nome)
            adapter.notifyItemRemoved(pos)
        }

        recyclerView.adapter = adapter

        val btnVoltar = findViewById<Button>(R.id.btnVoltarCadastro)
        btnVoltar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
