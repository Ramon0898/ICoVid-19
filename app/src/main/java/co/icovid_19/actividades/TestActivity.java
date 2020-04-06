package co.icovid_19.actividades;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import co.icovid_19.MainActivity;
import co.icovid_19.R;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {

    RadioButton rd1_1, rd2_1, rd1_2, rd2_2, rd1_3, rd2_3, rd1_4, rd2_4, rd1_5, rd2_5;
    Button btnconsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        rd1_1 = findViewById(R.id.radio1pregunta1);
        rd2_1 = findViewById(R.id.radio2pregunta1);
        rd1_2 = findViewById(R.id.radio1pregunta2);
        rd2_2 = findViewById(R.id.radio2pregunta2);
        rd1_3 = findViewById(R.id.radio1pregunta3);
        rd2_3 = findViewById(R.id.radio2pregunta3);
        rd1_4 = findViewById(R.id.radio1pregunta4);
        rd2_4 = findViewById(R.id.radio2pregunta4);
        rd1_5 = findViewById(R.id.radio1pregunta5);
        rd2_5 = findViewById(R.id.radio2pregunta5);
        btnconsultar = findViewById(R.id.btnconsultar);
        Consultar();


    }

    public void Consultar() {
        btnconsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rd1_1.isChecked() && rd1_2.isChecked() && rd1_3.isChecked() && rd1_4.isChecked() == true) {
                    ConsultaPositiva();
                } else if (rd1_2.isChecked() && rd1_2.isChecked() && rd2_3.isChecked() && rd1_4.isChecked() == true) {
                    ConsultaPositiva();
                } else if (rd1_1.isChecked() && rd2_2.isChecked() && rd2_3.isChecked() && rd1_4.isChecked() == true) {
                    ConsultaPositiva();
                } else if (rd1_1.isChecked() && rd2_2.isChecked() && rd1_3.isChecked() && rd1_4.isChecked() == true) {
                    ConsultaPositiva();
                } else if (rd1_2.isChecked() && rd2_2.isChecked() && rd1_3.isChecked() && rd1_4.isChecked() == true) {
                    ConsultaPositiva();
                } else if (rd1_2.isChecked() && rd2_2.isChecked() && rd2_3.isChecked() && rd1_4.isChecked() == true) {
                    ConsultaPositiva();
                } else if (rd1_2.isChecked() && rd2_2.isChecked() && rd1_3.isChecked() && rd1_4.isChecked() == true) {
                    ConsultaPositiva();
                } else if (rd1_2.isChecked() && rd2_2.isChecked() && rd2_3.isChecked() && rd2_4.isChecked() == true) {
                    ConsultaNegativa();
                } else {
                    ConsultaNegativa();
                }
            }
        });
    }

    public void  ConsultaPositiva() {

        AlertDialog.Builder builder = new AlertDialog.Builder(TestActivity.this);

        LayoutInflater inflater = getLayoutInflater();

        View view = inflater.inflate(R.layout.dialog911, null);
        builder.setView(view);

        final AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button btn911 = view.findViewById(R.id.btn911);
        btn911.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri callUri = Uri.parse("tel://911"); Intent callIntent = new Intent(Intent.ACTION_DIAL,callUri);
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_NO_USER_ACTION); startActivity(callIntent);
                dialog.dismiss();
            }
        });
        dialog.show();
    }



    public void ConsultaNegativa(){

        AlertDialog.Builder builder = new AlertDialog.Builder(TestActivity.this);

        LayoutInflater inflater = getLayoutInflater();

        View view = inflater.inflate(R.layout.layoutvolvermenu, null);
        builder.setView(view);

        final AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button btnvolver = view.findViewById(R.id.btnvolver);
        btnvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TestActivity.this, MainActivity.class);
                startActivity(i);
                dialog.dismiss();
            }
        });
        dialog.show();

    }
}
