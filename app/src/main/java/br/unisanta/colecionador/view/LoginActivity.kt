package br.unisanta.colecionador.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.unisanta.colecionador.R

class LoginActivity : AppCompatActivity(R.layout.activity_login) {

    private lateinit var edtUsuario: EditText
    private lateinit var edtSenha: EditText
    private lateinit var btnLogin: Button

    private val usuarioCorreto = "Arthur"
    private val senhaCorreta = "1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        edtUsuario = findViewById(R.id.edtUsuario)
        edtSenha = findViewById(R.id.edtSenha)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val usuario = edtUsuario.text.toString().trim()
            val senha = edtSenha.text.toString().trim()

            if (usuario == usuarioCorreto && senha == senhaCorreta) {
                Toast.makeText(this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Usuário ou senha incorretos!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
