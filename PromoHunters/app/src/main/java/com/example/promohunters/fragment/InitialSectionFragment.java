package com.example.promohunters.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import com.example.promohunters.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InitialSectionFragment extends Fragment implements View.OnClickListener {


    public InitialSectionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewRoot =  inflater.inflate(R.layout.fragment_initial_section, container, false); //Se quitó el return

        Button onlineButton = viewRoot.findViewById(R.id.online);

        Button physicalButton = viewRoot.findViewById(R.id.physical);

        onlineButton.setOnClickListener(this);
        physicalButton.setOnClickListener(this);

        return viewRoot;

    }

    @Override
    public void onClick(View v) {

    }
}
