package co.icovid_19.Modelo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.nio.DoubleBuffer;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import co.icovid_19.R;

public class CovidPaisAdapter  extends RecyclerView.Adapter<CovidPaisAdapter.ViewHolder>{

    ArrayList<ICoVidPais> iCoVidPaises;
    private Context context;

    public  CovidPaisAdapter(ArrayList<ICoVidPais> iCoVidPais, Context context){
        this.iCoVidPaises = iCoVidPais;
        this.context = context;
    }

    @NonNull
    @Override
    public CovidPaisAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_covid_pais, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ICoVidPais iCoVidPais = iCoVidPaises.get(position);
        holder.tvTotalCasos.setText(iCoVidPais.getmCases());
        holder.tvNombrePais.setText(iCoVidPais.getmCovidCountry());

        Glide.with(context)
                .load(iCoVidPais.getMflag())
                .apply(new RequestOptions().override(240, 160))
                .into(holder.imgBanderPais);

    }

    @Override
    public int getItemCount() {
        return iCoVidPaises.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTotalCasos, tvNombrePais;
        ImageView imgBanderPais;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTotalCasos = itemView.findViewById(R.id.tvTotalcasos);
            tvNombrePais = itemView.findViewById(R.id.tvNombrePais);
            imgBanderPais = itemView.findViewById(R.id.imgBanderPaises);
        }
    }
}
