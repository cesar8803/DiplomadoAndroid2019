package mx.mobilestudio.promohunters.fragment;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import mx.mobilestudio.promohunters.R;
import mx.mobilestudio.promohunters.interfaces.onModeSelection;

/**
 * A simple {@link Fragment} subclass.
 */
public class InitialSelectionFragment extends Fragment implements View.OnClickListener {


    private onModeSelection onModeSelection;

    public InitialSelectionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        onModeSelection = (onModeSelection) getActivity();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewRoot =  inflater.inflate(R.layout.fragment_initial_selection, container, false);

        Button onlineButton = viewRoot.findViewById(R.id.online);

        Button physicalButton = viewRoot.findViewById(R.id.physical);


        onlineButton.setOnClickListener(this);
        physicalButton.setOnClickListener(this);


        return viewRoot;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.physical:
                break;

            case R.id.online:
                onModeSelection.onModeSelected(R.id.online);
                break;
        }

    }


}
