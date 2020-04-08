package co.icovid_19.actividades;

import androidx.appcompat.app.AppCompatActivity;
import co.icovid_19.MainActivity;
import co.icovid_19.R;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.ReferenceQueue;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class RepublicaDominicana extends AppCompatActivity {

    TextView tvTotalConfirmados, tvTotalMuertes, tvTotalRecuperados, tvUltimaActualizacion, PaisNombre, detallesCasosRD,tvDetalleTotalCasosHoyRD, tvDetalleTotalmuertesRD,
            tvDetalleTotalmuertesHoyRD, tvDetalleTotalActivosRD,tvDetalleTotalCriticosRD, tvDetalleTotalRecuperadosRD;
    Button btnFinalizarCargaMundial;
    ProgressBar progressBar;
    private RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_republica_dominicana);

        //queue = Volley.newRequestQueue(this);

        //tvDataMundial = findViewById(R.id.tvDataMundial);
        tvTotalConfirmados = findViewById(R.id.tvtotalconfirmados);
        tvTotalMuertes = findViewById(R.id.tvtotalmuertos);
        tvTotalRecuperados = findViewById(R.id.tvtotalrecuperados);
        tvUltimaActualizacion = findViewById(R.id.tvUltimaActualizacion);
        progressBar = findViewById(R.id.progressBarRd);
        PaisNombre = findViewById(R.id.Nombre);
        detallesCasosRD = findViewById(R.id.tvDetalleTotalCasosRD);
        tvDetalleTotalCasosHoyRD =findViewById(R.id.tvDetalleTotalCasosHoyRD);
        tvDetalleTotalmuertesRD=findViewById(R.id.tvDetalleTotalmuertesRD);
        tvDetalleTotalmuertesHoyRD =findViewById(R.id.tvDetalleTotalmuertesHoyRD);
        tvDetalleTotalActivosRD = findViewById(R.id.tvDetalleTotalActivosRD);
        tvDetalleTotalCriticosRD = findViewById(R.id.tvDetalleTotalCriticosRD);
        tvDetalleTotalRecuperadosRD = findViewById(R.id.tvDetalleTotalRecuperadosRD);


        getDataRd();

    }



    private void getDataRd() {
        RequestQueue queue = Volley.newRequestQueue(this);


        String url = "https://corona.lmao.ninja/countries/DO";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);

                try {
                    JSONObject jsonObject = new JSONObject(response.toString());
                    String country = jsonObject.getString("country");
                    int updated = jsonObject.getInt("updated");
                    int cases = jsonObject.getInt("cases");
                    int deaths= jsonObject.getInt("deaths");
                    int deathTd = jsonObject.getInt("todayDeaths");
                    int todayCases =jsonObject.getInt("todayCases");
                    int recovered =jsonObject.getInt("recovered");
                    int active = jsonObject.getInt("active");
                    int criticos = jsonObject.getInt("critical");
                    int casesPerOneMillion = jsonObject.getInt("casesPerOneMillion");
                    int deathsPerOneMillion = jsonObject.getInt("deathsPerOneMillion");
                    int tests = jsonObject.getInt("tests");
                    int testsPerOneMillion = jsonObject.getInt("testsPerOneMillion");



                    DecimalFormat dd = new DecimalFormat("0,000");

                    if (cases<=999)
                    {
                        String casos = String.valueOf(cases);
                        detallesCasosRD.setText(casos);
                    }
                    else
                        {
                            String casos = String.valueOf(dd.format(cases));
                            detallesCasosRD.setText(casos);
                        }

                    if (deaths<=999)
                    {
                        String deat= String.valueOf(deaths);
                        tvDetalleTotalmuertesRD.setText(deat);
                    }
                    else
                        {
                            String deat= String.valueOf(dd.format(deaths));
                            tvDetalleTotalmuertesRD.setText(deat);
                        }
                    if(deathTd<=999)
                    {
                        String Deathtd= String.valueOf(deathTd);
                        tvDetalleTotalmuertesHoyRD.setText(Deathtd);
                    }
                    else
                        {
                            String Deathtd= String.valueOf(dd.format(deathTd));
                            tvDetalleTotalmuertesHoyRD.setText(Deathtd);
                        }
                    if(recovered<=999)
                    {
                        String recovere =String.valueOf(recovered);
                        tvDetalleTotalRecuperadosRD.setText(recovere);
                    }
                    else
                        {
                            String recovere =String.valueOf(dd.format(recovered));
                            tvDetalleTotalRecuperadosRD.setText(recovere);
                        }
                    if(active<=999)
                    {
                        String acti = String.valueOf(active);
                        tvDetalleTotalActivosRD.setText(acti);
                    }
                    else
                        {
                            String acti = String.valueOf(dd.format(active));
                            tvDetalleTotalActivosRD.setText(acti);
                        }
                    if(todayCases<=999)
                    {
                        String casosHoy = String.valueOf(todayCases);
                        tvDetalleTotalCasosHoyRD.setText(casosHoy);

                    }
                    else
                        {
                            String casosHoy = String.valueOf(dd.format(todayCases));
                            tvDetalleTotalCasosHoyRD.setText(casosHoy);
                        }
                    if(criticos<=999)
                    {
                        String critic = String.valueOf(criticos);
                        tvDetalleTotalCriticosRD.setText(critic);
                    }
                    else
                        {
                            String critic = String.valueOf(dd.format(criticos));
                            tvDetalleTotalCriticosRD.setText(critic);
                        }

                    PaisNombre.setText(country);



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                Log.d("Error Response", error.toString());
            }

        });

        queue.add(stringRequest);

    }
}
