package mx.mobilestudio.promohunters.fragment;


import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import mx.mobilestudio.promohunters.R;
import mx.mobilestudio.promohunters.Utilerias.LocationHandler;
import mx.mobilestudio.promohunters.model.Promo;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhysicalFormFragment extends Fragment implements View.OnClickListener , OnSuccessListener, OnFailureListener {

    Button buttonSavePromo;
    EditText editTextTitle;
    EditText editTextPrice;
    EditText editTextDesc;
    ImageButton imagePromoButton;
    StorageReference storageReference; // jala referencia al directorio remoto raiz /
    StorageReference imageReference;// Sera una  referencia al directorio y archivo de la imagen a subir


    ProgressDialog progressDialog;
    UploadTask uploadTask;

    private Uri selectImage;

    private FirebaseStorage firebaseStorage;// Almacenar archivos, imagenes, videos
    private DatabaseReference databaseReference; // Para conectarse con realtime database de firebase
    private LocationHandler locationHandler;

    Promo promo;


    public PhysicalFormFragment() {
        // Required empty public constructor
        // Required empty public constructor
        databaseReference = FirebaseDatabase.getInstance().getReference();
        firebaseStorage = FirebaseStorage.getInstance();
        storageReference=firebaseStorage.getReference();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewRoot =  inflater.inflate(R.layout.fragment_physical_form, container, false);


        buttonSavePromo = viewRoot.findViewById(R.id.addNewPromo);

        editTextTitle = viewRoot.findViewById(R.id.title);
        editTextPrice = viewRoot.findViewById(R.id.precio);
        editTextDesc = viewRoot.findViewById(R.id.description);

        imagePromoButton = viewRoot.findViewById(R.id.imagePromoButton);
        imagePromoButton.setOnClickListener(this);
        imagePromoButton.setImageResource(R.drawable.common_full_open_on_phone);

        buttonSavePromo.setOnClickListener(this);

        //Hacemos un Toast con la latitud y longitud

        Toast.makeText(getActivity(), "LAT " + locationHandler.lastLatitude + " LNG " + locationHandler.lastLongitud, Toast.LENGTH_LONG ).show();

        return viewRoot;
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
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.imagePromoButton:
                selectImage();

                break;

            case R.id.addNewPromo:

                String validateResult = validateForm();

                if(validateResult.isEmpty()){

                    Toast.makeText(getActivity(),"Los datos son validos!! ",Toast.LENGTH_LONG).show();


                    if(selectImage != null){
                        uploadImage();
                    }

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

        if(editTextDesc.getText().toString().isEmpty()){
            validateString = validateString +"Debes colocar una Descripción valida\n";

        }
        return validateString;
    }


    public void createNewPromo(String imageURL){

        promo = new Promo();

        promo.setTitle(editTextTitle.getText().toString());
        promo.setPrice(Float.valueOf(editTextPrice.getText().toString()));
        promo.setDescription(editTextDesc.getText().toString());
        promo.setImageLink(imageURL);
        promo.setLatitude(locationHandler.lastLatitude);
        promo.setLongitud(locationHandler.lastLongitud);


        String promoID = databaseReference.push().getKey();
        databaseReference.child("promo").child(promoID).setValue(promo).addOnSuccessListener(this).addOnFailureListener(this);

    }



    //Este es el metodo encargado de subir la imagen a Firebase (Cloud Storage)

    public void uploadImage(){
        imageReference = storageReference.child("images/"+selectImage.getLastPathSegment());
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMax(100);
        progressDialog.setMessage("Subiendo imagen...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();
        progressDialog.setCancelable(false);


        //Iniciamos la subida del archivo ( remota  / local )

        uploadTask = imageReference.putFile(selectImage);

        // Implementamos a travez de una clase anonima el OnProgressListener
        uploadTask.addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();
                progressDialog.incrementProgressBy((int) progress);


            }
        });

        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(getActivity(),"Error al subir imagen!!",Toast.LENGTH_LONG).show();
                progressDialog.dismiss();

            }
        });

        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                Task<Uri> downloadURL = taskSnapshot.getMetadata().getReference().getDownloadUrl();
                progressDialog.dismiss();
                Toast.makeText(getActivity(),"Upload de imagen correcto!!",Toast.LENGTH_SHORT).show();

                //Extraer la URL de la imagen

                taskSnapshot.getStorage().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Toast.makeText(getActivity(), "URL"+uri.toString(),Toast.LENGTH_SHORT).show();

                        createNewPromo(uri.toString());//Crea la promo en la base de datos de firebase ya con la URL de la imagen

                        Picasso.with(getActivity()).load(uri.toString()).into(imagePromoButton);

                    }
                });


            }
        });






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

    public LocationHandler getLocationHandler() {
        return locationHandler;
    }

    public void setLocationHandler(LocationHandler locationHandler) {
        this.locationHandler = locationHandler;
    }
}