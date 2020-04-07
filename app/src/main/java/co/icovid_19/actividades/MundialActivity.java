package co.icovid_19.actividades;

import androidx.appcompat.app.AppCompatActivity;
import co.icovid_19.MainActivity;
import co.icovid_19.R;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.ReferenceQueue;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class MundialActivity extends AppCompatActivity {

    TextView tvTotalConfirmados, tvTotalMuertes, tvTotalRecuperados, tvUltimaActualizacion;
    Button btnFinalizarCargaMundial;
    ProgressBar progressBar;
    private RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mundial);

        //queue = Volley.newRequestQueue(this);

        //tvDataMundial = findViewById(R.id.tvDataMundial);
        tvTotalConfirmados = findViewById(R.id.tvtotalconfirmados);
        tvTotalMuertes = findViewById(R.id.tvtotalmuertos);
        tvTotalRecuperados = findViewById(R.id.tvtotalrecuperados);
        tvUltimaActualizacion = findViewById(R.id.tvUltimaActualizacion);
        progressBar = findViewById(R.id.progressBarMundial);




        getDataMundial();

    }

    private String getFecha(long milliSecond){
        // Viernes, 3 Abril 2020 06:19:04 PM
        SimpleDateFormat formattter = new SimpleDateFormat("EEE, dd MMM yyyy hh:mm:ss aaa");

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSecond);

        return formattter.format(calendar.getTime());
    }

    private void getDataMundial() {
        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "https://corona.lmao.ninja/all";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);

                try {
                    JSONObject jsonObject = new JSONObject(response.toString());
                    DecimalFormat dd = new DecimalFormat("0,000");
                    int casos= jsonObject.getInt("cases");
                    int muertes = jsonObject.getInt("deaths");
                    int recuperados = jsonObject.getInt("recovered");



                    tvTotalConfirmados.setText(dd.format(casos));
                    tvTotalMuertes.setText(dd.format(muertes));
                    tvTotalRecuperados.setText(dd.format(recuperados));
                    tvUltimaActualizacion.setText("Última Actualización "+"\n"+getFecha(jsonObject.getLong("updated")));
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
