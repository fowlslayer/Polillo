package com.example.classi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignUpActivity extends FragmentActivity
{
    //dichiaro il mio blocco di dati
    EditText editTextUserName,editTextPassword,editTextConfirmPassword;
    EditText editTextNome,editTextCognome,editTextTelefono;
    Button btnCreateAccount;

    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        // get Instance  of Database Adapter
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();


        // Get Refferences of Views
        editTextUserName=(EditText)findViewById(R.id.editTextUserName);

        //inizializzo NOME COGNOME TELEFONO
        editTextNome=(EditText)findViewById(R.id.editNome);
        editTextCognome=(EditText)findViewById(R.id.editCognome);
        editTextTelefono=(EditText)findViewById(R.id.editTelefono);

        editTextPassword=(EditText)findViewById(R.id.editTextPassword);
        editTextConfirmPassword=(EditText)findViewById(R.id.editTextConfirmPassword);

        btnCreateAccount=(Button)findViewById(R.id.buttonAggiungiAttivitá);
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                // TODO Auto-generated method stub

                String userName=editTextUserName.getText().toString();
                String password=editTextPassword.getText().toString();

                //trasformo i miei dati in stringhe per verificare se sono inserito nel format
                String nome=editTextNome.getText().toString();
                String cognome=editTextCognome.getText().toString();
                String telefono=editTextTelefono.getText().toString();

                String confirmPassword=editTextConfirmPassword.getText().toString();

                // check if any of the fields are vaccant
                if(userName.equals("")||password.equals("")||confirmPassword.equals("")
                        ||nome.equals("")
                        ||cognome.equals("")
                        ||telefono.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Dati mancanti", Toast.LENGTH_LONG).show();
                    return;
                }
                // check if both password matches
                if(!password.equals(confirmPassword))
                {
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                    return;
                }
                else
                {
                    // Save the Data in Database

                    loginDataBaseAdapter.insertEntry(userName, password, nome, cognome, telefono,"si");

                    Intent logIn = new Intent(getApplicationContext(), MainActivity.class);
                    logIn.putExtra("Username",userName);
                    startActivity(logIn);

                    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        loginDataBaseAdapter.close();
    }
}
