package mx.mobilestudio.promohunters.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.mobilestudio.promohunters.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OnlineFormFragment extends Fragment {


    public OnlineFormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_online_form, container, false);
    }

}
