package com.paladino.favores.presentation;

import android.os.Bundle;
import android.app.Activity;

import com.paladino.favores.R;

public class CadastroFavorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_favor);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
