package co.icovid_19.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import co.icovid_19.Interfaces.IComunicarFragment;
import co.icovid_19.MainActivity;
import co.icovid_19.R;
import co.icovid_19.actividades.InformacionesActivity;
import co.icovid_19.actividades.TestActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AtencionMedicaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AtencionMedicaFragment extends Fragment {

    Button btnFinalizarPrueba;
    Activity actividad;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private InicioFragment.OnFragmentInteractionListener mListener;

    public AtencionMedicaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AtencionMedicaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AtencionMedicaFragment newInstance(String param1, String param2) {
        AtencionMedicaFragment fragment = new AtencionMedicaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view = inflater.inflate(R.layout.fragment_atencion_medica, container, false);



        btnFinalizarPrueba = view.findViewById(R.id.btnFinalizarAyuda);
        btnFinalizarPrueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        return view;
    }


    public void  showDialog() {


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getLayoutInflater();

        View view = inflater.inflate(R.layout.dialog_test, null);
        builder.setView(view);

        final AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button btnsi = view.findViewById(R.id.btnsi);
        btnsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), TestActivity.class);
                startActivity(i);
                dialog.dismiss();
            }
        });

        Button btnno = view.findViewById(R.id.btnno);
        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MainActivity.class);
                startActivity(i);
                dialog.dismiss();
            }
        });

        dialog.show();

    }
}
