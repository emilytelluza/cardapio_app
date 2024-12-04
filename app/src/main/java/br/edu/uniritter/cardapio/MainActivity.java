package br.edu.uniritter.cardapio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Configuração do layout principal como LinearLayout (vertical)
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(16, 16, 16, 16);

        // Botão para acessar a tela de login
        Button btnLogin = new Button(this);
        btnLogin.setText("Login"); // Texto do botão
        layout.addView(btnLogin);

        // Botão para acessar a tela de cadastro
        Button btnRegister = new Button(this);
        btnRegister.setText("Cadastro"); // Texto do botão
        layout.addView(btnRegister);

        // Navega para a tela de login ao clicar no botão
        btnLogin.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, LoginActivity.class)));

        // Navega para a tela de cadastro ao clicar no botão
        btnRegister.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, RegisterActivity.class)));

        // Define o layout criado como o conteúdo da Activity
        setContentView(layout);
    }
}
