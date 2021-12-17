package com.patrickrafael.minhasanotaes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabButton;
    private AnotacoesPreferencias preferencias;
    private EditText editAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editAnotacao = findViewById(R.id.editTextAnotacao);


        preferencias = new AnotacoesPreferencias(getApplicationContext());

        fabButton = findViewById(R.id.fab);


        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String textoRecuperado = editAnotacao.getText().toString();

                //validar oque foi escrito
                if (textoRecuperado.equals("")) {

                    Snackbar.make(view, "Preencha O texto!", Snackbar.LENGTH_LONG).show();

                } else {

                    preferencias.salvarAnotacao(textoRecuperado);
                    Snackbar.make(view, "Anotação Salva!", Snackbar.LENGTH_LONG).show();


                }

            }
        });

        String anotacao = preferencias.recuperarAnotacao();
        if (!anotacao.equals("")) {
            editAnotacao.setText( anotacao);


        } else {

        }

    }
}