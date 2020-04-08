package co.icovid_19.actividades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import co.icovid_19.Modelo.CovidPaisAdapter;
import co.icovid_19.Modelo.ICoVidPais;
import co.icovid_19.Modelo.ItemClickSupport;
import co.icovid_19.R;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PaisActivity extends AppCompatActivity {

    RecyclerView rvCovidPais;
    ProgressBar progressBar;
    TextView tvTotalPais;
    int NUmero;

    private  static final String TAG = PaisActivity.class.getSimpleName();

    ArrayList<ICoVidPais> iCoVidPaises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pais);

        rvCovidPais = findViewById(R.id.rvPais);
        progressBar = findViewById(R.id.progressBarPais);
        rvCovidPais.setLayoutManager(new LinearLayoutManager(this));
        tvTotalPais = findViewById(R.id.tvTotalPais);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvCovidPais.getContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.linea_divisora));
        rvCovidPais.addItemDecoration(dividerItemDecoration);
        getDataPais();
    }

    private void showRecyclerView(){
        CovidPaisAdapter covidPaisAdapter = new CovidPaisAdapter(iCoVidPaises, this);
        rvCovidPais.setAdapter(covidPaisAdapter);

        ItemClickSupport.addTo(rvCovidPais).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedPaisCovid(iCoVidPaises.get(position));
            }
        });
    }

    private  void showSelectedPaisCovid(ICoVidPais iCoVidPais){
        Intent icovid = new Intent(PaisActivity.this, DetallesPaisActivity.class);
        icovid.putExtra("EXTRA_COVID",iCoVidPais );
        startActivity(icovid);
    }


    private void getDataPais() {
        String url = "https://corona.lmao.ninja/countries/";
        RequestQueue queue = Volley.newRequestQueue(this);


        iCoVidPaises = new ArrayList<>();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);
                if (response != null) {
                    Log.e(TAG, "onResponse: " + response);
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject data = jsonArray.getJSONObject(i);

                            //Extraer JSONObject inside JSONObject
                            JSONObject conuntryInfo = data.getJSONObject("countryInfo");

                            iCoVidPaises.add(new ICoVidPais(data.getString("country"),  data.getInt("cases"),
                                    data.getInt("todayCases"), data.getInt("deaths"), data.getInt("todayDeaths"),
                                    data.getInt("recovered"), data.getInt("active"), data.getInt("critical"),
                                    conuntryInfo.getString("flag")
                            ));

                        }
                        tvTotalPais.setText("Paises");
                        showRecyclerView();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressBar.setVisibility(View.GONE);
                        Log.e(TAG, "onResponse: "+ error);
                    }
                });
        queue.add(stringRequest);

    }
    /*private void getDataPaisBusqueda() {
        String url = "https://corona.lmao.ninja/countries/";
        RequestQueue queue = Volley.newRequestQueue(this);


        iCoVidPaises = new ArrayList<>();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);
                if (response != null) {
                    Log.e(TAG, "onResponse: " + response);
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject data = jsonArray.getJSONObject(i);

                            //Extraer JSONObject inside JSONObject
                            JSONObject conuntryInfo = data.getJSONObject("countryInfo");

                            iCoVidPaises.add(new ICoVidPais(data.getString("country"),  data.getInt("cases"),
                                    data.getInt("todayCases"), data.getInt("deaths"), data.getInt("todayDeaths"),
                                    data.getInt("recovered"), data.getInt("active"), data.getInt("critical"),
                                    conuntryInfo.getString("flag")
                            ));

                        }
                        tvTotalPais.setText(jsonArray.length()+ " Paises");
                        showRecyclerView();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressBar.setVisibility(View.GONE);
                        Log.e(TAG, "onResponse: "+ error);
                    }
                });
        queue.add(stringRequest);

    }*/
}
