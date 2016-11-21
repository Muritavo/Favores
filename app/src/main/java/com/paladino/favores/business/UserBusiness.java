package com.paladino.favores.business;

import android.os.Bundle;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.paladino.favores.pesistence.entidades.CategoriaHorario;
import com.paladino.favores.pesistence.entidades.Pessoa;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.Semaphore;

/**
 * Created by murit on 20/11/2016.
 */

public class UserBusiness {
    private static Pessoa usuario;

    public static Pessoa getUser() throws InterruptedException, JSONException {
        if (usuario == null) {
            GraphRequest graphRequest = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), null);
            Bundle parameter = new Bundle();
            parameter.putString("fields", "id, first_name, last_name, email, location");
            graphRequest.setParameters(parameter);
            JSONObject jsonUsuario = graphRequest.executeAndWait().getJSONObject();
            Log.d("Facebook", jsonUsuario.toString());
            usuario = new Pessoa(jsonUsuario.getString("first_name"), jsonUsuario.getString("email"), CategoriaHorario.Manha);
            return usuario;
        } else {
            return usuario;
        }
    }
}
