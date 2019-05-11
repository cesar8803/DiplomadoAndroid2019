package mx.mobilestudio.promohunters.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mx.mobilestudio.promohunters.R;
import mx.mobilestudio.promohunters.model.Promo;

import static android.widget.Toast.makeText;

/**
 * A simple {@link Fragment} subclass.
 */
public class OnlineFormFragment extends Fragment implements View.OnClickListener {

    Button savePromo;
    EditText editTextTitle;
    EditText editTextPrice;
    EditText editTextLink;
    EditText editTextDesc;

    Promo promo;


    public OnlineFormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewRoot = inflater.inflate(R.layout.fragment_online_form, container, false);

        Button savePromo = viewRoot.findViewById(R.id.addNewPromo);

        editTextTitle = viewRoot.findViewById(R.id.title);
        editTextPrice = viewRoot.findViewById(R.id.precio);
        editTextLink = viewRoot.findViewById(R.id.link);
        editTextDesc = viewRoot.findViewById(R.id.description);

        savePromo.setOnClickListener(this);

        return viewRoot;


    }



    @Override
    public void onClick(View v) {

        String validateResult = validateForm();

        if(validateResult.isEmpty()){

            Toast.makeText(getActivity(), "Los datos son válidos", Toast.LENGTH_LONG).show();

            createNewPromo();

        } else {

            Toast.makeText(getActivity(), validateResult, Toast.LENGTH_LONG).show();
        }

    }

    public String validateForm(){

        String validateString="";

        if(editTextTitle.getText().toString().isEmpty()){

            validateString = validateString + " Debes colocar un Titulo Válido\n ";

        }

        if(editTextPrice.getText().toString().isEmpty()){

            validateString = validateString + " Debes colocar un Precio Válido\n ";

        }

        boolean isValidURL = URLUtil.isValidUrl(editTextLink.getText().toString());

        //Toast.makeText(getActivity(),  String.valueOf(isValidURL), Toast.LENGTH_LONG).show();


        if(!isValidURL || editTextLink.getText().toString().isEmpty()){

            validateString = validateString + " Debes colocar un Link Válido\n ";

        }

        if(editTextDesc.getText().toString().isEmpty()){

            validateString = validateString + " Debes colocar una Descripción Válida\n ";

        }

        return validateString;
    }

    public void createNewPromo(){

        promo = new Promo();

        promo.setTitle(editTextTitle.getText().toString());
        promo.setPrice(Float.valueOf(editTextPrice.getText().toString()));
        promo.setLink(editTextLink.getText().toString());
        promo.setDescription(editTextDesc.getText().toString());

    }
}
