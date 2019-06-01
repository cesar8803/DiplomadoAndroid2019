package mx.mobilestudio.promohunters.fragment;


import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import mx.mobilestudio.promohunters.R;
import mx.mobilestudio.promohunters.model.Promo;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class OnlineFormFragment extends Fragment implements View.OnClickListener , OnSuccessListener , OnFailureListener {


    Button buttonSavePromo;
    EditText editTextTitle;
    EditText editTextPrice;
    EditText editTextLink;
    EditText editTextDesc;
    ImageButton imagePromoButton;

    private Uri selectImage;

    private FirebaseStorage firebaseStorage;// Almacenar archivos, imagenes, videos
    private DatabaseReference databaseReference; // Para conectarse con realtime database de firebase






    Promo  promo;


    public OnlineFormFragment() {
        // Required empty public constructor
        databaseReference = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 100:
                if(resultCode == RESULT_OK){

                    selectImage = data.getData();
                    Toast.makeText(getActivity(), "Image selected!!  "+selectImage.getLastPathSegment(),Toast.LENGTH_SHORT).show();

                }
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewRoot =  inflater.inflate(R.layout.fragment_online_form, container, false);


        buttonSavePromo = viewRoot.findViewById(R.id.addNewPromo);

        editTextTitle = viewRoot.findViewById(R.id.title);
        editTextPrice = viewRoot.findViewById(R.id.precio);
        editTextLink = viewRoot.findViewById(R.id.link);
        editTextDesc = viewRoot.findViewById(R.id.description);

        imagePromoButton = viewRoot.findViewById(R.id.imagePromoButton);
        imagePromoButton.setOnClickListener(this);
        imagePromoButton.setImageResource(R.drawable.common_full_open_on_phone);

        buttonSavePromo.setOnClickListener(this);

        return viewRoot;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.imagePromoButton:
                selectImage();

                break;

            case R.id.addNewPromo:

                String validateResult = validateForm();

                if(validateResult.isEmpty()){

                    Toast.makeText(getActivity(),"Los datos son validos!! ",Toast.LENGTH_LONG).show();


                    createNewPromo();

                }else{
                    Toast.makeText(getActivity(),validateResult,Toast.LENGTH_LONG).show();

                }

                break;
        }




    }

    public String validateForm(){

        String validateString="";

        if(editTextTitle.getText().toString().isEmpty()){

            validateString = validateString +"Debes colocar un Titulo valido\n";

        }

        if(editTextPrice.getText().toString().isEmpty()){
            validateString = validateString +"Debes colocar un Precio valido\n";

        }

        boolean isValidURL = URLUtil.isValidUrl(editTextLink.getText().toString());

        if(!isValidURL ||  editTextLink.getText().toString().isEmpty()){
            validateString = validateString +"Debes colocar un Link valido\n";

        }

        if(editTextDesc.getText().toString().isEmpty()){
            validateString = validateString +"Debes colocar una Descripción valida\n";

        }
        return validateString;
    }


    public void createNewPromo(){

        promo = new Promo();

        promo.setTitle(editTextTitle.getText().toString());
        promo.setPrice(Float.valueOf(editTextPrice.getText().toString()));
        promo.setLink(editTextLink.getText().toString());
        promo.setDescription(editTextDesc.getText().toString());


        String promoID = databaseReference.push().getKey();
        databaseReference.child("promos").child(promoID).setValue(promo).addOnSuccessListener(this).addOnFailureListener(this);

    }


    @Override
    public void onSuccess(Object o) {

        Toast.makeText(getActivity(), "Se guardo de forma exitosa!! ", Toast.LENGTH_LONG).show();
        getActivity().finish();

    }

    @Override
    public void onFailure(@NonNull Exception e) {

        Toast.makeText(getActivity(), "Ocurrio un error!!  "+e.getStackTrace().toString(), Toast.LENGTH_LONG).show();


    }


    public void selectImage(){
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent,100);//Metodo que inicia una Acivity Externa pero espera un resultado

    }


}
