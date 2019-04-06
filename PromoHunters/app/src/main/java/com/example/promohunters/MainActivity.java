package com.example.promohunters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;


public class MainActivity extends AppCompatActivity implements OnSuccessListener, View.OnClickListener {

    private String token;
    private ImageButton imageButton; //Creacion de la variable botón
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton = findViewById(R.id.mybuttonaddnewpromo); //Referenciar id de Layout a imagen
        imageButton .setOnClickListener(this); //Nos referimos a la clase donde estamos

        //Inicializamos FirebaseAuth

        firebaseAuth = FirebaseAuth.getInstance();

        //Iniciamos FirebaseInstance que nos sirven para obtener un token para las pushnotificaciones

        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(MainActivity.this, this );
    }

    @Override
    public void onSuccess(Object o) {

        InstanceIdResult instanceIdResult = (InstanceIdResult) o;
        token = instanceIdResult.getToken();

        Toast.makeText(MainActivity.this, token, Toast.LENGTH_LONG).show();

    }


    @Override
    //Se define el comportamiento del botón
    public void onClick(View v) {

        if(firebaseAuth.getCurrentUser() == null) {

            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);

        }
        else{
            //Usuario Logueado
        }
        Intent intent = new Intent(this, PromoFormActivity.class);
        startActivity(intent);
        }

}

