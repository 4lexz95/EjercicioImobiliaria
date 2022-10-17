package alex.example.ejercicioimobiliaria;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

import alex.example.ejercicioimobiliaria.Models.Piso;
import alex.example.ejercicioimobiliaria.configuraciones.Constantes;
import alex.example.ejercicioimobiliaria.databinding.ActivityAddPisoBinding;

public class AddPisoActivity extends AppCompatActivity {
    // Crear variable binding
    private ActivityAddPisoBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddPisoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle("CREAR");


        binding.btnCancelarAddPiso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
        binding.btnCrearAddPsio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Piso piso = crearPiso();
                if (piso != null){
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(Constantes.INMUEBLE, piso);
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    setResult(RESULT_OK, intent);
                    finish();

                }
                else {
                    Toast.makeText(AddPisoActivity.this, "Faltan DATOS", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private Piso crearPiso() {
        if (
                binding.txtCiudadAddPiso.getText().toString().isEmpty()||
                binding.txtCpAddPiso.getText().toString().isEmpty()||
                binding.txtProvinciaAddPiso.getText().toString().isEmpty()||
                binding.txtNumAddPiso.getText().toString().isEmpty()||
                binding.txtDireccionAddPiso.getText().toString().isEmpty()


        )
            return null;

        return  new Piso(
                binding.txtDireccionAddPiso.getText().toString(),
                binding.txtCiudadAddPiso.getText().toString(),
                binding.txtProvinciaAddPiso.getText().toString(),
                binding.txtCpAddPiso.getText().toString(),
                Integer.parseInt(binding.txtNumAddPiso.getText().toString()),
                binding.rbValoracionpiso.getRating()
        );


    }
}
