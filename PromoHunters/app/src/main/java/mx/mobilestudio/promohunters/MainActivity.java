package mx.mobilestudio.promohunters;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import mx.mobilestudio.promohunters.fragment.HotPromoFragment;

public class MainActivity extends AppCompatActivity implements OnSuccessListener, View.OnClickListener {

    private String token;
    private ImageButton imageButton;
    private FirebaseAuth firebaseAuth;
    private FragmentManager fragmentManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton = findViewById(R.id.mybuttonaddnewpromo);

        imageButton.setOnClickListener(this);


        // Inicializamos firebaseAuth que nos sirve para Autenticar a usuarios dentro de nuestra App

        firebaseAuth = FirebaseAuth.getInstance();
        fragmentManager = getSupportFragmentManager();

        // Inicializamos FirebaseInstanceId que nos sirve para Obtener un Token para las PushNotifications
        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(MainActivity.this, this );

        attachHotPromoFragment();
    }

    @Override
    public void onSuccess(Object o) {

        InstanceIdResult instanceIdResult = (InstanceIdResult) o;
        token = instanceIdResult.getToken();

        Toast.makeText(MainActivity.this, token, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {

        if(firebaseAuth.getCurrentUser() == null){

            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);


        }else{
            // El usuario esta loggeado

            Intent intent = new Intent(this, PromoFormActivity.class);
            startActivity(intent);

        }


    }





    public void attachHotPromoFragment(){


        Fragment hotPromoFragment = new HotPromoFragment();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.main_home_container,hotPromoFragment);

        fragmentTransaction.commit();


    }

}
