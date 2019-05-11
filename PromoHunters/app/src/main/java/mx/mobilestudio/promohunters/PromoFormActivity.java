package mx.mobilestudio.promohunters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import mx.mobilestudio.promohunters.fragment.InitialSelectionFragment;
import mx.mobilestudio.promohunters.fragment.OnlineFormFragment;
import mx.mobilestudio.promohunters.fragment.PhysicalFormFragment;
import mx.mobilestudio.promohunters.interfaces.onModeSelection;

public class PromoFormActivity extends AppCompatActivity implements onModeSelection {


    private FragmentManager fragmentManager;
    private final   int  INITAL_DECISION=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo_form);

        fragmentManager = getFragmentManager();

        attachFragment(INITAL_DECISION);
    }

    private void attachFragment(int mood){


        switch (mood){
            case R.id.online:
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                Fragment initialSelectionFragment = new OnlineFormFragment();

                fragmentTransaction.replace(R.id.main_fragment_container, initialSelectionFragment);

                fragmentTransaction.commit();
                break;
            case R.id.physical:


                FragmentTransaction fragmentTransaction3 = fragmentManager.beginTransaction();

                Fragment physicalFragment = new PhysicalFormFragment();

                fragmentTransaction3.replace(R.id.main_fragment_container, physicalFragment);

                fragmentTransaction3.commit();

                break;

            case INITAL_DECISION:
                FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();

                Fragment initialSelectionFragment2 = new InitialSelectionFragment();

                fragmentTransaction2.replace(R.id.main_fragment_container, initialSelectionFragment2);

                fragmentTransaction2.commit();
                break;
        }


    }


    @Override
    public void onModeSelected(int mode) {

        attachFragment(mode);
    }
}
