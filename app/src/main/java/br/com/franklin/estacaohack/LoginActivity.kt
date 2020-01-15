package br.com.franklin.estacaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Criando a ação do clique do botão Entrar

        btnEntrar.setOnClickListener {
            val usuario = edtNome.text.toString().trim()
            val senha = edtSenha.text.toString().trim()


            //Condição para verificar se o usuario estão corretor
            if(usuario.isEmpty()){
                //Usuario vazio
                Toast.makeText(this@LoginActivity, "Usuario vazio", Toast.LENGTH_LONG).show()

            }else if(senha.isEmpty()){
                //Senha vazia
                Toast.makeText(this@LoginActivity, "Senha vazia", Toast.LENGTH_LONG).show()

            }else if(usuario == "admin" && senha == "admin"){
                startActivity(Intent(this@LoginActivity,MainActivity::class.java))
            }else{
                AlertDialog.Builder(this@LoginActivity)
                        .setTitle("Erro de Autenticação!")
                        .setMessage("Usuario ou Senha Incorretos ")
                        .setPositiveButton("OK"){ _,_->

                        }
                        .create()
                        .show()
            }
        }

    }
}
