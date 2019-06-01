package mx.mobilestudio.promohunters.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import mx.mobilestudio.promohunters.adapter.PromoHunterAdapter;
import mx.mobilestudio.promohunters.model.Promo;



import java.util.ArrayList;

import mx.mobilestudio.promohunters.R;
import mx.mobilestudio.promohunters.model.Promo;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotPromoFragment extends Fragment implements ValueEventListener {

    //public ArrayList<Promo> promos;
    public RecyclerView recyclerView;
    public RecyclerView.Adapter Adapter; //No es usada al momento
    public LinearLayoutManager layoutManager;  // Esta clase calcula cuantas vistas y viewholder caben en la pantalla

    //Variables adicionales a las que necesita la App
    public ArrayList<Promo> promoList = new ArrayList<>();
    private DatabaseReference databaseReference;

        public HotPromoFragment() {
            // Required empty public constructor
            databaseReference = FirebaseDatabase.getInstance().getReference("promo");
            databaseReference.addValueEventListener(this);



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // se elimina return inflater.inflate(R.layout.fragment_hot_promo, container, false);

        //Comienza

        View viewRoot =   inflater.inflate(R.layout.fragment_hot_promo, container, false); //1

        //super.onCreate(savedInstanceState);//2
        //setContentView(R.layout.my_activity);//2.1


        recyclerView =  viewRoot.findViewById(R.id.hot_promo); //una forma
        //recyclerView = (RecyclerView) findViewById(R.id.hot_promo); //Segunda forma

        //Usa esta configuración para mejorar el performance si no sabes que cambio
        //El contenido no cambia el tamaño de Layout del RecyclerView
        recyclerView.setHasFixedSize(true);

        //Usa un Linear Layout Manager
        layoutManager = new LinearLayoutManager(getActivity()); // Inicializamos en linear layout manager
        recyclerView.setLayoutManager(layoutManager);





        return  viewRoot;

        //Termina




    }

//Benjamin Claro NIIETOoo haban
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//Cada vez que hay informaciòn nueva nos llega este método sin nosotros solicitarlo, en el orden que se requiera (Fecha, Top, Como llega de la bd)

        for(DataSnapshot child : dataSnapshot.getChildren()){

            Promo promo = child.getValue(Promo.class);
            promoList.add(promo); //Se van almacenar todas las promos que tengamos.

            Toast.makeText(getActivity(),promo.getTitle(),Toast.LENGTH_LONG).show();
        }


        //Especifica un adaptador
        PromoHunterAdapter Adapter = new PromoHunterAdapter (promoList);
        recyclerView.setAdapter(Adapter);

        }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }

    //public ArrayList<Promo> getPromos() { return promoList; } //Pendiente

    //public void setPromos(ArrayList<Promo> promoList) {this.promoList = promoList;} //Pendiente


}
