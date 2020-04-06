package co.icovid_19.actividades;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import co.icovid_19.R;
import co.icovid_19.actividades.ui.main.SectionsPagerAdapter;
import co.icovid_19.fragments.FiebreFragment;

public class InformacionesActivity extends AppCompatActivity {


    private LinearLayout linearPuntos;
    private TextView[] puntosSlide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informaciones);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        //TabLayout tabs = findViewById(R.id.tabs);
        //tabs.setupWithViewPager(viewPager);


        linearPuntos = findViewById(R.id.idLinearPuntos);

        AgregarIndicadorPuntos(0);

        viewPager.addOnPageChangeListener(viewListener);


    }

    private void AgregarIndicadorPuntos(int pos) {
        puntosSlide = new TextView[5];
        linearPuntos.removeAllViews();

        for (int i = 0; i < puntosSlide.length; i++) {
            puntosSlide[i] = new TextView(this);
            puntosSlide[i].setText(Html.fromHtml("&#8226;"));
            puntosSlide[i].setTextSize(35);
            puntosSlide[i].setTextColor(getResources().getColor(R.color.colorBlancoTransparente));
            linearPuntos.addView(puntosSlide[i]);
        }

        if (puntosSlide.length > 0) {
            puntosSlide[pos].setTextColor(getResources().getColor(R.color.colorBlanco));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            AgregarIndicadorPuntos(position);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}