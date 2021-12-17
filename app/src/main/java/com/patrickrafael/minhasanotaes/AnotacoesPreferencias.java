package com.patrickrafael.minhasanotaes;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacoesPreferencias {

    private Context context;
    private SharedPreferences preferences;
    private final String  NOME_ARQUIVO = "anotacao.preferencias";
    private SharedPreferences.Editor editor;
    private final String CHAVE_NOME = "nome";


    public AnotacoesPreferencias(Context c) {
        this.context = c;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, 0);
        editor = preferences.edit();

    }

    public void salvarAnotacao(String anotatacao){

        editor.putString(CHAVE_NOME, anotatacao);
        editor.commit();

    }

    public String recuperarAnotacao(){

        return preferences.getString(CHAVE_NOME,"");

    }




}
