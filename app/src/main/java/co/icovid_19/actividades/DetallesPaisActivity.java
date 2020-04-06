package co.icovid_19.actividades;

import androidx.appcompat.app.AppCompatActivity;
import co.icovid_19.Modelo.ICoVidPais;
import co.icovid_19.R;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetallesPaisActivity extends AppCompatActivity {

    TextView tvDetallePais, tvDetalleTotalCasos, tvDetalleCasosHoy, tvDetalleTotalMuertes, tvDetalleMuertesHoy, tvDetalleTotalRecuperados, tvDetalleTotalActivos, tvDetalleTotalCriticos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_pais);

        tvDetallePais = findViewById(R.id.tvDetallesNombrePais);
        tvDetalleTotalCasos = findViewById(R.id.tvDetalleTotalCasos);
        tvDetalleCasosHoy = findViewById(R.id.tvDetalleTotalCasosHoy);
        tvDetalleTotalMuertes = findViewById(R.id.tvDetalleTotalmuertes);
        tvDetalleMuertesHoy = findViewById(R.id.tvDetalleTotalmuertesHoy);
        tvDetalleTotalActivos = findViewById(R.id.tvDetalleTotalActivos);
        tvDetalleTotalRecuperados = findViewById(R.id.tvDetalleTotalRecuperados);
        tvDetalleTotalCriticos = findViewById(R.id.tvDetalleTotalCriticos);

        //Llamamos paisCovid

        ICoVidPais iCoVidPais = getIntent().getParcelableExtra("EXTRA_COVID");

        tvDetallePais.setText(iCoVidPais.getmCovidCountry());
        tvDetalleTotalCasos.setText(iCoVidPais.getmCases());
        tvDetalleCasosHoy.setText(iCoVidPais.getmTodayCases());
        tvDetalleTotalMuertes.setText(iCoVidPais.getmDeaths());
        tvDetalleMuertesHoy.setText(iCoVidPais.getmTodayDeaths());
        tvDetalleTotalRecuperados.setText(iCoVidPais.getmRecovered());
        tvDetalleTotalActivos.setText(iCoVidPais.getmActive());
        tvDetalleTotalCriticos.setText(iCoVidPais.getmCritical());
    }
}
