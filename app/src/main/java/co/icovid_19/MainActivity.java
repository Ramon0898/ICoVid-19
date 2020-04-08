package co.icovid_19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import co.icovid_19.Interfaces.IComunicarFragment;
import co.icovid_19.actividades.InformacionesActivity;
import co.icovid_19.actividades.MapActivity;
import co.icovid_19.actividades.MundialActivity;
import co.icovid_19.actividades.PaisActivity;
import co.icovid_19.actividades.RepublicaDominicana;
import co.icovid_19.actividades.TestActivity;
import co.icovid_19.actividades.ui.main.PageViewModel;
import co.icovid_19.actividades.ui.main.PlaceholderFragment;
import co.icovid_19.actividades.ui.main.SectionsPagerAdapter;
import co.icovid_19.fragments.AtencionMedicaFragment;
import co.icovid_19.fragments.InicioFragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements IComunicarFragment, InicioFragment.OnFragmentInteractionListener{

    Fragment fragmentInicio;
    Button btnconsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentInicio = new InicioFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment,fragmentInicio).commit();

    }



    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void DataMundial() {
        Intent i = new Intent (this, MundialActivity.class);
        startActivity(i);
    }

    @Override
    public void DataPais() {

        Intent i = new Intent (this, PaisActivity.class);
        startActivity(i);
    }

    @Override
    public void Test() {

        Intent i = new Intent (this, TestActivity.class);
        startActivity(i);
    }

    @Override
    public void Ayuda() {
        Intent i = new Intent (this, InformacionesActivity.class);
        startActivity(i);
    }

    @Override
    public void Mapa() {
        Intent i = new Intent (this, MapActivity.class);
        startActivity(i);
    }

    @Override
    public void DR() {
        Intent i = new Intent (this, RepublicaDominicana.class);
        startActivity(i);
    }
}
