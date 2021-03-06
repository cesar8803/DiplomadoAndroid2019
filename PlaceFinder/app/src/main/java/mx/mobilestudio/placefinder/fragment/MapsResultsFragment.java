package mx.mobilestudio.placefinder.fragment;


import android.app.Fragment;
import android.graphics.BitmapFactory;
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
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import mx.mobilestudio.placefinder.R;
import mx.mobilestudio.placefinder.model.Venue;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapsResultsFragment extends Fragment implements OnMapReadyCallback {



    public ArrayList<Venue> venues;
    private GoogleMap googleMap;


    public MapsResultsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_maps_results, container, false);

        MapFragment mapFragment = (MapFragment) getChildFragmentManager().findFragmentById(R.id.map_fragment);




        mapFragment.getMapAsync(this);

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
        Toast.makeText(getActivity(), "Mapa cargo exitosamente",Toast.LENGTH_LONG).show();

        LatLng latLng = new LatLng(19.395209,-99.1544203);

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng,14f);
        googleMap.moveCamera(cameraUpdate);

        this.googleMap = googleMap;


        //Agregamos un marcador para nuestra ubicación

        MarkerOptions markerOptions = new MarkerOptions(); // Esta clase representa la configuración de un marcador

        markerOptions.position(latLng);
        markerOptions.title("MobileStudio");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));


        googleMap.addMarker(markerOptions);

        paintFourSuareMarkersinMap();

    }


    public void paintFourSuareMarkersinMap(){


        for(Venue currentVenue : venues){

            Double lat = currentVenue.location.lat;

            Double lmg = currentVenue.location.lng;

            String name = currentVenue.name;


            LatLng latLng = new LatLng(lat,lmg);


            MarkerOptions markerOptions = new MarkerOptions(); // Esta clase representa la configuración de un marcador

            markerOptions.position(latLng);
            markerOptions.title(name);



            googleMap.addMarker(markerOptions);


        }



    }



}
