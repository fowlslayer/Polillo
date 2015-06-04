package com.example.classi;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends Fragment {

    LoginDataBaseAdapter loginDataBaseAdapter;
    Button btnSignIn, btnSignUp;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        loginDataBaseAdapter = new LoginDataBaseAdapter(getActivity());
        loginDataBaseAdapter = loginDataBaseAdapter.open();

        // Get The Refference Of Buttons
        btnSignIn = (Button) rootView.findViewById(R.id.buttonSignIn);
        btnSignUp = (Button) rootView.findViewById(R.id.registrati);

        final EditText editTextUserName=(EditText)rootView.findViewById(R.id.editTextUserNameToLogin);
        final EditText editTextPassword=(EditText)rootView.findViewById(R.id.editTextPasswordToLogin);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Create Intent for SignUpActivity  and Start The Activity
                Intent singUp = new Intent(getActivity(), SignUpActivity.class);
                startActivity(singUp);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String userName=editTextUserName.getText().toString();
                String password=editTextPassword.getText().toString();

                String storedPassword = loginDataBaseAdapter.getSinlgeEntry(userName);
                if (password.equals(storedPassword)) {



                    loginDataBaseAdapter.setLoggato(userName,"si");

                    Intent logIn = new Intent(getActivity(), MainActivity.class);
                    logIn.putExtra("Username",userName);
                    startActivity(logIn);
                } else {
                    Toast.makeText(getActivity(), "Username or password is incorrect", Toast.LENGTH_LONG).show();
                }

            }
        });
    return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Close The Database
        loginDataBaseAdapter.close();
    }

}