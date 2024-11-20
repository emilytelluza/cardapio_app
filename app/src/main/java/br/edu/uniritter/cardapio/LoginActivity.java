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

    private UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inicializar o UserDAO para manipulação do banco de dados
        userDAO = new UserDAO(this);

        // Criar o layout principal programaticamente
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(16, 16, 16, 16);

        // Criar o campo de email
        EditText edEmail = new EditText(this);
        edEmail.setHint("Email");
        layout.addView(edEmail);

        // Criar o campo de senha
        EditText edPassword = new EditText(this);
        edPassword.setHint("Senha");
        layout.addView(edPassword);

        // Criar o botão de login
        Button btnLogin = new Button(this);
        btnLogin.setText("Login");
        layout.addView(btnLogin);

        // Configurar a ação do botão de login
        btnLogin.setOnClickListener(v -> {
            String email = edEmail.getText().toString().trim();
            String password = edPassword.getText().toString().trim();

            // Validar credenciais
            if (userDAO.authenticateUser(email, password)) {
                Toast.makeText(LoginActivity.this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show();

                // Navegar para a tela de boas-vindas
                startActivity(new Intent(LoginActivity.this, WelcomeActivity.class));
                finish(); // Impede o retorno à tela de login
            } else {
                Toast.makeText(LoginActivity.this, "Email ou senha incorretos!", Toast.LENGTH_SHORT).show();
            }
        });

        // Configurar o layout como conteúdo da Activity
        setContentView(layout);
    }
}
