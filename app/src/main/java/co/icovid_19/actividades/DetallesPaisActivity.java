package co.icovid_19.actividades;

import androidx.appcompat.app.AppCompatActivity;
import co.icovid_19.Modelo.ICoVidPais;
import co.icovid_19.R;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

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

        DecimalFormat d = new DecimalFormat("0,000");

        if (iCoVidPais.getmCases()<999)
        {
            String casess = String.valueOf(iCoVidPais.getmCases());
            tvDetalleTotalCasos.setText(casess);
        }
        else
            {
                String casess = String.valueOf(d.format(iCoVidPais.getmCases()));
                tvDetalleTotalCasos.setText(casess);
            }



        if(iCoVidPais.getmTodayCases()<999)
        {
            String casess1 = String.valueOf(iCoVidPais.getmTodayCases());
            tvDetalleCasosHoy.setText(casess1);
        }
        else {
        String casess1 = String.valueOf(d.format(iCoVidPais.getmTodayCases()));
        tvDetalleCasosHoy.setText(casess1); }

        if(iCoVidPais.getmDeaths()<999)
        {
            String casess2 = String.valueOf(iCoVidPais.getmDeaths());
            tvDetalleTotalMuertes.setText(casess2);
        }
        else{
            String casess2 = String.valueOf(d.format(iCoVidPais.getmDeaths()));
            tvDetalleTotalMuertes.setText(casess2);}

        if(iCoVidPais.getmTodayDeaths()<999)
        {
            String casess3 = String.valueOf(iCoVidPais.getmTodayDeaths());
            tvDetalleMuertesHoy.setText(casess3);
        }else{
            String casess3 = String.valueOf(d.format(iCoVidPais.getmTodayDeaths()));
            tvDetalleMuertesHoy.setText(casess3); }

        if (iCoVidPais.getmRecovered()<999)
        {
            String casess4 = String.valueOf(iCoVidPais.getmRecovered());
            tvDetalleTotalRecuperados.setText(casess4);
        }
        else
            {
                String casess4 = String.valueOf(d.format(iCoVidPais.getmRecovered()));
                tvDetalleTotalRecuperados.setText(casess4);
            }
        if (iCoVidPais.getmActive()<999)
        {
            String casess5 = String.valueOf(iCoVidPais.getmActive());
            tvDetalleTotalActivos.setText(casess5);
        }
        else
            {
                String casess5 = String.valueOf(d.format(iCoVidPais.getmActive()));
                tvDetalleTotalActivos.setText(casess5);
            }


        if (iCoVidPais.getmCritical()<999)
        {
            String casess6 = String.valueOf(iCoVidPais.getmCritical());
            tvDetalleTotalCriticos.setText(casess6);
        }
        else
            {
                String casess6 = String.valueOf(d.format(iCoVidPais.getmCritical()));
                tvDetalleTotalCriticos.setText(casess6);
            }

    }
}
