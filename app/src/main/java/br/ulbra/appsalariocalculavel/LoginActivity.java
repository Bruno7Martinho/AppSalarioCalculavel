package br.ulbra.appsalariocalculavel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText txtEmailLogin, txtSenhaLogin;
    Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login_activity);

        txtEmailLogin = findViewById(R.id.txtEmailLogin);
        txtSenhaLogin = findViewById(R.id.txtSenhaLogin);
        btnEntrar = findViewById(R.id.btnEntrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailDigitado = txtEmailLogin.getText().toString().trim();
                String senhaDigitada = txtSenhaLogin.getText().toString().trim();

                DBHelper dbHelper = new DBHelper(LoginActivity.this);
                boolean valido = dbHelper.validarLogin(emailDigitado, senhaDigitada);

                if (valido) {
                    Toast.makeText(LoginActivity.this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, SalarioActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Nome ou senha incorretos!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}