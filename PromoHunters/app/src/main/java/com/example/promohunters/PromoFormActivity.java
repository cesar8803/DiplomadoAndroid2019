package com.example.promohunters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.promohunters.fragment.InitialSectionFragment;



public class PromoFormActivity extends AppCompatActivity {


    private FragmentManager fragmentManager; // Clase que me permite agregar fragmentos a mi Activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo_form);

        // Inicializamos fragment manager
        fragmentManager = getFragmentManager();
        attachFragment();
    }

    // Generamos un metodo para agregar (attachar) nuestros Fragmento
    public void attachFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment initialSectionFragment = new InitialSectionFragment();

        fragmentTransaction.replace(R.id.main_container, initialSectionFragment);  // Aqui es donde colocamos el fragmento

        fragmentTransaction.commit();
    }


}
