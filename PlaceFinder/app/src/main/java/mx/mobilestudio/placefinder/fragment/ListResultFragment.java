package mx.mobilestudio.placefinder.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mx.mobilestudio.placefinder.R;
import mx.mobilestudio.placefinder.adapter.ListFourSquareAdapter;
import mx.mobilestudio.placefinder.model.Location;
import mx.mobilestudio.placefinder.model.Venue;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListResultFragment extends Fragment {

    public ArrayList<Venue> venues;
    public RecyclerView recyclerView;
    public ArrayList<Location> locations;

    public LinearLayoutManager layoutManager;  // Esta clase calcula cuantas vistas y viewholder caben en la pantalla


    public ListResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View viewRoot =   inflater.inflate(R.layout.fragment_list_result, container, false);

        recyclerView =  viewRoot.findViewById(R.id.lista_foursquare);
        layoutManager = new LinearLayoutManager(getActivity()); // Inicializamos en linear layout manager
        recyclerView.setLayoutManager(layoutManager);


        ListFourSquareAdapter adapter = new ListFourSquareAdapter(venues);
        ListFourSquareAdapter adapter1 = new ListFourSquareAdapter(locations); //Se crea un nuevo constructor



        recyclerView.setAdapter(adapter);
        recyclerView.setAdapter(adapter1); //Se Recicla el constructor


        return  viewRoot;
    }



    public ArrayList<Venue> getVenues() {
        return venues;
    }

    public void setVenues(ArrayList<Venue> venues) {
        this.venues = venues;
    }




}
