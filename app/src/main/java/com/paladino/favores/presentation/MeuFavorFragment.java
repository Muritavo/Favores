package com.paladino.favores.presentation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paladino.favores.R;
import com.paladino.favores.pesistence.entidades.Favor;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link MeuFavorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MeuFavorFragment extends Fragment {
    private Favor favor;

    public MeuFavorFragment() {
    }

    public MeuFavorFragment(Favor favor) {
        this.favor = favor;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment MeuFavorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MeuFavorFragment newInstance(Favor favor) {
        MeuFavorFragment fragment = new MeuFavorFragment(favor);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favor, container, false);
    }
}
