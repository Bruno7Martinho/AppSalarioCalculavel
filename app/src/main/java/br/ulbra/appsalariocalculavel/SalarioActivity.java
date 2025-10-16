package br.ulbra.appsalariocalculavel;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SalarioActivity extends AppCompatActivity {
    EditText txtNomeSalario, txtSalario, txtNumFilhos;
    Button btnCalcular;
    RadioGroup rgOpcoes;
    RadioButton rbMas1, rbFem1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.salario_activity);

        txtNomeSalario = findViewById(R.id.txtNomeSalario);
        txtSalario = findViewById(R.id.txtSalario);
        txtNumFilhos = findViewById(R.id.txtNumFilhos);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        rgOpcoes = (RadioGroup)findViewById(R.id.rgOpcoes);
        rbMas1 = (RadioButton)findViewById(R.id.rbMas);
        rbFem1 = (RadioButton)findViewById(R.id.rbFem);



        btnCalcular.setOnClickListener(v -> {

            String nome = txtNomeSalario.getText().toString().trim();
            String salarioStr = txtSalario.getText().toString().trim();
            String numFilhosStr = txtNumFilhos.getText().toString().trim();

            if (nome.isEmpty()) {
                Toast.makeText(this, "Informe o nome", Toast.LENGTH_SHORT).show();
                return;
            }
            if (salarioStr.isEmpty()) {
                Toast.makeText(this, "Informe o salário bruto", Toast.LENGTH_SHORT).show();
                return;
            }
            if (numFilhosStr.isEmpty()) {
                Toast.makeText(this, "Informe o número de filhos", Toast.LENGTH_SHORT).show();
                return;
            }
            int selectedId = rgOpcoes.getCheckedRadioButtonId();
            if (selectedId == -1) {
                Toast.makeText(this, "Selecione o sexo", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                double salarioBruto = Double.parseDouble(salarioStr);
                int filhos = Integer.parseInt(numFilhosStr);

                if (salarioBruto <= 0 || salarioBruto > 1_000_000) {
                    Toast.makeText(this, "Salário inválido", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (filhos < 0) {
                    Toast.makeText(this, "Número de filhos inválido", Toast.LENGTH_SHORT).show();
                    return;
                }


                double inss = CalculadoraSalario.calcularINSS(salarioBruto);
                double ir = CalculadoraSalario.calcularIR(salarioBruto);
                double salarioFamilia = CalculadoraSalario.calcularSalarioFamilia(salarioBruto, filhos);
                double salarioLiquido = CalculadoraSalario.calcularSalarioLiquido(salarioBruto, inss, ir, salarioFamilia);


                String sexo = ((RadioButton)findViewById(selectedId)).getText().toString();
                String tratamento = sexo.equalsIgnoreCase("Masculino") ? "Sr." : "Sra.";

                String resultado = tratamento + " " + nome + "\n" +
                        "Salário Bruto: R$ " + String.format("%.2f", salarioBruto) + "\n" +
                        "Desconto INSS: R$ " + String.format("%.2f", inss) + "\n" +
                        "Desconto IR: R$ " + String.format("%.2f", ir) + "\n" +
                        (salarioFamilia > 0 ? "Salário-Família: R$ " + String.format("%.2f", salarioFamilia) + "\n" : "") +
                        "Salário Líquido: R$ " + String.format("%.2f", salarioLiquido);

                new AlertDialog.Builder(this)
                        .setTitle("Resultado")
                        .setMessage(resultado)
                        .setPositiveButton("OK", null)
                        .show();



            } catch (NumberFormatException e) {
                Toast.makeText(this, "Informe valores numéricos válidos", Toast.LENGTH_SHORT).show();
            }


        });
    }
    }

