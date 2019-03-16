package mx.mobilestudio.placefinder.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

import mx.mobilestudio.placefinder.R;
import mx.mobilestudio.placefinder.model.Venue;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapsResultsFragment extends Fragment implements OnMapReadyCallback{



    public ArrayList<Venue> venues;


    public MapsResultsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_maps_results, container, false); //Se crea una referencia a la vista

        MapFragment mapFragment = (MapFragment) getChildFragmentManager().findFragmentById(R.id.map_fragment); //Jalar la referencia al mapfragment y poderle agregar cosasa

        mapFragment.getMapAsync(this); //Cuando termine de cargar el mapa, me va avisar a traves del mètodo OnMapReady

        return view;

    }

    public ArrayList<Venue> getVenues() {
        return venues;
    }

    public void setVenues(ArrayList<Venue> venues) {
        this.venues = venues;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        Toast.makeText(getActivity(), "Mapa cargó exitosamente", Toast.LENGTH_LONG).show();

        LatLng latLng = new LatLng (19.395209, -99.1544203); //Dato Duro por el momento

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 14f); //Nivel de Zoom La variable CamUpdate te posiciona

        googleMap.moveCamera(cameraUpdate);


    }
}
