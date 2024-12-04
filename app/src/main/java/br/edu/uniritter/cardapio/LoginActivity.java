package br.edu.uniritter.cardapio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.edu.uniritter.cardapio.data.UserDAO;

public class LoginActivity extends AppCompatActivity {

    private UserDAO userDAO; // Classe que lida com o banco de dados para autenticação

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inicializa o UserDAO para manipular os dados no SQLite
        userDAO = new UserDAO(this);

        // Configuração do layout principal como LinearLayout (vertical)
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(16, 16, 16, 16);

        // Campo de entrada para o email
        EditText edEmail = new EditText(this);
        edEmail.setHint("Email"); // Placeholder para o campo
        layout.addView(edEmail);

        // Campo de entrada para a senha
        EditText edPassword = new EditText(this);
        edPassword.setHint("Senha"); // Placeholder para o campo
        layout.addView(edPassword);

        // Botão para realizar o login
        Button btnLogin = new Button(this);
        btnLogin.setText("Login");
        layout.addView(btnLogin);

        // Configura a ação do botão de login
        btnLogin.setOnClickListener(v -> {
            // Obtém o email e a senha digitados
            String email = edEmail.getText().toString().trim();
            String password = edPassword.getText().toString().trim();

            // Valida as credenciais no banco de dados
            if (userDAO.authenticateUser(email, password)) {
                // Login bem-sucedido, navega para a tela de boas-vindas
                Toast.makeText(LoginActivity.this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, WelcomeActivity.class));
                finish(); // Evita que o usuário volte para a tela de login
            } else {
                // Credenciais incorretas
                Toast.makeText(LoginActivity.this, "Email ou senha incorretos!", Toast.LENGTH_SHORT).show();
            }
        });

        // Define o layout criado como o conteúdo da Activity
        setContentView(layout);
    }
}
