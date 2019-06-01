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

import java.util.ArrayList;
import java.util.List;

import mx.mobilestudio.promohunters.R;
import mx.mobilestudio.promohunters.model.Promo;
import mx.mobilestudio.promohunters.adapter.PromoHunterAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotPromoFragment extends Fragment implements ValueEventListener {

    public RecyclerView recyclerView;
    public LinearLayoutManager layoutManager;
    public ArrayList<Promo> promoList = new ArrayList<>();
    private DatabaseReference databaseReference;


    public HotPromoFragment() {
        // Required empty public constructor
        databaseReference = FirebaseDatabase.getInstance().getReference("promos");
        databaseReference.addValueEventListener(this);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_hot_promo, container, false);

        recyclerView=viewRoot.findViewById(R.id.lista_promohunter);

        layoutManager= new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);

        PromoHunterAdapter adapter = new PromoHunterAdapter(promoList);

        recyclerView.setAdapter(adapter);

        return viewRoot;

    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        // Cada vez que hay informacion nueva nos llega a este metodo sin nosotros solicitarlo

        for(DataSnapshot child : dataSnapshot.getChildren()){

            Promo promo = child.getValue(Promo.class);
            promoList.add(promo);


            Toast.makeText(getActivity(),promo.getTitle(),Toast.LENGTH_LONG).show();
        }




    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
}
