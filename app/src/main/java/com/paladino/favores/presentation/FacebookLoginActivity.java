package com.paladino.favores.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.paladino.favores.R;

import java.util.Arrays;

public class FacebookLoginActivity extends AppCompatActivity implements FacebookCallback<LoginResult> {
    private LoginButton loginButton;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_login);

        this.callbackManager = CallbackManager.Factory.create();

        loginButton = (LoginButton) findViewById(R.id.btn_login);
        loginButton.setReadPermissions(Arrays.asList("email", "public_profile"));

        loginButton.registerCallback(callbackManager, this);
        if (AccessToken.getCurrentAccessToken() != null) {
            onSuccess(null);
        }
    }

    @Override
    public void onSuccess(LoginResult loginResult) {
        if (Profile.getCurrentProfile() != null) {
            goHome();
        } else {
            ProfileTracker profileTracker = new ProfileTracker() {
                @Override
                protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                    Profile.setCurrentProfile(currentProfile);
                    goHome();
                }
            };
            profileTracker.startTracking();
        }
    }

    private void goHome() {
        Intent intent = new Intent(FacebookLoginActivity.this, PainelPrincipalActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onCancel() {
        Toast.makeText(this, "Não cancela porra...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(FacebookException error) {
        Toast.makeText(this, "Erro: " + error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
