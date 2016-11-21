package com.paladino.favores.presentation;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paladino.favores.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class CadastroFavorActivityFragment extends Fragment {

    public CadastroFavorActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cadastro_favor, container, false);
    }
}
