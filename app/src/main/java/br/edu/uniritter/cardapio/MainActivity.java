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

        // Layout Principal
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(16, 16, 16, 16);

        // Botão de Login
        Button btnLogin = new Button(this);
        btnLogin.setText("Login");
        layout.addView(btnLogin);

        // Botão de Cadastro
        Button btnRegister = new Button(this);
        btnRegister.setText("Cadastro");
        layout.addView(btnRegister);

        // Navegação
        btnLogin.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, LoginActivity.class)));
        btnRegister.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, RegisterActivity.class)));

        // Define o layout como o conteúdo da atividade
        setContentView(layout);
    }
}
