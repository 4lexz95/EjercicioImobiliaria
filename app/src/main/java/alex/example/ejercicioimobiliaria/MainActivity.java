package alex.example.ejercicioimobiliaria;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import alex.example.ejercicioimobiliaria.Models.Piso;
import alex.example.ejercicioimobiliaria.configuraciones.Constantes;
import alex.example.ejercicioimobiliaria.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private ArrayList<Piso> pisoList;
    private ActivityResultLauncher<Intent> addPisoLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        pisoList = new ArrayList<>();
        inicializalaunchers();



        setSupportActionBar(binding.toolbar);




        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: OJO CREAR EL EVENTO
                addPisoLauncher.launch(new Intent(MainActivity.this, AddPisoActivity.class));
            }
        });
    }

    private void inicializalaunchers() {
        addPisoLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        //
                        if (result.getResultCode() == RESULT_OK){
                            if (result.getData() != null) {
                                if (result.getData().getExtras()!= null ){
                                    Piso piso = (Piso) result.getData().getExtras().getSerializable(Constantes.INMUEBLE);

                                    if (piso != null){
                                        pisoList.add(piso);
                                        mostrarPiso();



                                    }
                                    else {
                                        Toast.makeText(MainActivity.this, "No hay piso en el Bundle", Toast.LENGTH_SHORT).show();
                                    }

                                }
                                else {
                                    Toast.makeText(MainActivity.this, "NO HAY BUNDLE EN EL INTENT", Toast.LENGTH_SHORT).show();

                                }

                            }else {
                                Toast.makeText(MainActivity.this, "SET RESULT NO TIENE INTENT", Toast.LENGTH_SHORT).show();

                            }

                        }
                        else  {
                            Toast.makeText(MainActivity.this, "VENTANA CANCELADA", Toast.LENGTH_SHORT).show();

                        }
                    }
                }


        );


    }

    private void mostrarPiso() {

        binding.contenedor.contenedor.removeAllViews();

        for (int i = 0; i < pisoList.size(); i++) {
            Piso piso = pisoList.get(i);

            View pisoView = LayoutInflater.from(MainActivity.this).inflate(R.layout.piso_model_view,null);
            TextView lblDireccion = pisoView.findViewById(R.id.lblDireccionPisoView);
            TextView lblNumero = pisoView.findViewById(R.id.lblNumDireccion);
            TextView lblProvincia = pisoView.findViewById(R.id.lblProvinciaPisoView);
            TextView lblCiudad = pisoView.findViewById(R.id.lblCiudadPisoView);
            RatingBar rbValoracion =pisoView.findViewById(R.id.ratingBar);

            lblDireccion.setText(piso.getDireccion());
            lblCiudad.setText(piso.getCiudad());
            lblProvincia.setText(piso.getProvincia());
            lblNumero.setText(String.valueOf(piso.getNumero()));
            rbValoracion.setRating(piso.getValoracion());

            binding.contenedor.contenedor.addView(pisoView);

        }
    }


}