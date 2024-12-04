package br.edu.uniritter.cardapio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.edu.uniritter.cardapio.data.UserDAO;

public class RegisterActivity extends AppCompatActivity {

    private UserDAO userDAO; // Classe que lida com o banco de dados para registrar usuários

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inicializa o UserDAO para manipular os dados no SQLite
        userDAO = new UserDAO(this);

        // Configuração do layout principal como LinearLayout (vertical)
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(16, 16, 16, 16);

        // Campo de entrada para o nome
        EditText edName = new EditText(this);
        edName.setHint("Nome"); // Placeholder para o campo
        layout.addView(edName);

        // Campo de entrada para o email
        EditText edEmail = new EditText(this);
        edEmail.setHint("Email");
        layout.addView(edEmail);

        // Campo de entrada para a senha
        EditText edPassword = new EditText(this);
        edPassword.setHint("Senha");
        layout.addView(edPassword);

        // Botão para registrar o usuário
        Button btnRegister = new Button(this);
        btnRegister.setText("Cadastrar");
        layout.addView(btnRegister);

        // Configura a ação do botão de cadastro
        btnRegister.setOnClickListener(v -> {
            // Obtém os valores digitados
            String name = edName.getText().toString().trim();
            String email = edEmail.getText().toString().trim();
            String password = edPassword.getText().toString().trim();

            // Tenta registrar o usuário no banco de dados
            if (userDAO.registerUser(name, email, password)) {
                // Cadastro bem-sucedido
                Toast.makeText(RegisterActivity.this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish(); // Evita voltar à tela de cadastro
            } else {
                // Erro no cadastro
                Toast.makeText(RegisterActivity.this, "Erro ao cadastrar!", Toast.LENGTH_SHORT).show();
            }
        });

        // Define o layout criado como o conteúdo da Activity
        setContentView(layout);
    }
}
