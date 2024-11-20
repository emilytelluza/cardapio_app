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

    private UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userDAO = new UserDAO(this);

        // Layout Principal
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(16, 16, 16, 16);

        // Campo de Nome
        EditText edName = new EditText(this);
        edName.setHint("Nome");
        layout.addView(edName);

        // Campo de Email
        EditText edEmail = new EditText(this);
        edEmail.setHint("Email");
        layout.addView(edEmail);

        // Campo de Senha
        EditText edPassword = new EditText(this);
        edPassword.setHint("Senha");
        layout.addView(edPassword);

        // Botão de Cadastro
        Button btnRegister = new Button(this);
        btnRegister.setText("Cadastrar");
        layout.addView(btnRegister);

        btnRegister.setOnClickListener(v -> {
            String name = edName.getText().toString().trim();
            String email = edEmail.getText().toString().trim();
            String password = edPassword.getText().toString().trim();

            if (userDAO.registerUser(name, email, password)) {
                Toast.makeText(RegisterActivity.this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish(); // Evita voltar à tela de cadastro
            } else {
                Toast.makeText(RegisterActivity.this, "Erro ao cadastrar!", Toast.LENGTH_SHORT).show();
            }
        });

        // Define o layout como o conteúdo da atividade
        setContentView(layout);
    }
}
