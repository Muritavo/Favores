package com.paladino.favores.presentation;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;
import com.paladino.favores.R;
import com.paladino.favores.business.UserBusiness;
import com.paladino.favores.pesistence.entidades.CategoriaHorario;
import com.paladino.favores.pesistence.entidades.Pessoa;

import org.json.JSONException;

import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link PerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilFragment extends Fragment implements FacebookCallback<LoginResult> {
    private CallbackManager callbackManager;
    private Pessoa eu;
    private TextView lblNome;
    private TextView lblEmail;
    private EditText inputLocation;
    private Spinner selectTurno;

    public PerfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PerfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PerfilFragment newInstance() {
        return new PerfilFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callbackManager = CallbackManager.Factory.create();
        new LoadUSerTask().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Profile currenteProfile = Profile.getCurrentProfile();
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        lblNome = (TextView) view.findViewById(R.id.lbl_nome_usuario);
        lblEmail = (TextView) view.findViewById(R.id.lbl_email);
        inputLocation = (EditText) view.findViewById(R.id.editText);
        selectTurno = (Spinner) view.findViewById(R.id.spinner);
        selectTurno.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, Arrays.asList(CategoriaHorario.Manha, CategoriaHorario.Tarde, CategoriaHorario.Noite)));

        ProfilePictureView profilePictureView = (ProfilePictureView)view.findViewById(R.id.image_profile_picture);
        profilePictureView.setProfileId(currenteProfile.getId());

        LoginButton loginButton =(LoginButton)view.findViewById(R.id.btn_logout);
        loginButton.setFragment(this);
        loginButton.registerCallback(callbackManager, this);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onSuccess(LoginResult loginResult) {
        Toast.makeText(getActivity(), "Adeus", Toast.LENGTH_SHORT).show();
        getActivity().finish();
    }

    @Override
    public void onCancel() {

    }

    @Override
    public void onError(FacebookException error) {

    }

    public class LoadUSerTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            lblNome.setText(eu.getNome());
            lblEmail.setText(eu.getEmail());
            inputLocation.setText("Av. Ipiranga Nº 9000");
            selectTurno.setSelection(eu.getTurno().ordinal());
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                eu = UserBusiness.getUser();
            } catch (InterruptedException | JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
