package br.unisanta.colecionador.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.unisanta.colecionador.R
import br.unisanta.colecionador.model.Item
import br.unisanta.colecionador.model.ItemDaoImpl

class MainActivity : AppCompatActivity() {

    private lateinit var edtNome: EditText
    private lateinit var edtValor: EditText
    private lateinit var edtImagem: EditText
    private lateinit var btnCadastrar: Button
    private lateinit var btnListar: Button

    private val dao = ItemDaoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtNome = findViewById(R.id.edtNome)
        edtValor = findViewById(R.id.edtValor)
        edtImagem = findViewById(R.id.edtImagem)
        btnCadastrar = findViewById(R.id.btnCadastrar)
        btnListar = findViewById(R.id.btnListar)

        btnCadastrar.setOnClickListener {
            val nome = edtNome.text.toString().trim()
            val valorTexto = edtValor.text.toString().trim()
            val imagem = edtImagem.text.toString().trim()

            if (nome.isEmpty() || valorTexto.isEmpty() || imagem.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val valor = valorTexto.toDoubleOrNull()
            if (valor == null) {
                Toast.makeText(this, "Valor inválido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val novoItem = Item(nome, valor, imagem)
            dao.adcionarItem(novoItem)

            Toast.makeText(this, "Item cadastrado com sucesso!", Toast.LENGTH_SHORT).show()

            edtNome.text.clear()
            edtValor.text.clear()
            edtImagem.text.clear()
        }

        btnListar.setOnClickListener {
            val intent = Intent(this, ListaActivity::class.java)
            startActivity(intent)
        }
    }
}
