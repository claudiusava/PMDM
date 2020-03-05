package com.example.practicaversiones.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.practicaversiones.R;
import com.example.practicaversiones.utils.Version;
import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.HolderAdapterPropio> {

    Context context;
    ArrayList<Version> listaVersiones;
    OnMiRecyclerListener listener;

    public AdaptadorRecycler(Context context1, ArrayList<Version> listaVersiones) {
        this.context = context1;
        this.listaVersiones = listaVersiones;
        listener = (OnMiRecyclerListener) context1;
    }


    @NonNull
    @Override
    public HolderAdapterPropio onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler_layout, parent, false);
        HolderAdapterPropio miHolder = new HolderAdapterPropio(view);
        return miHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull HolderAdapterPropio holder, int position) {

        final Version actual = listaVersiones.get(position);
        holder.getImagen().setImageResource(actual.getLogo());
        holder.getNombre().setText(actual.getNombre());

        holder.getLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onMiRecycler(actual);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listaVersiones.size();
    }


    class HolderAdapterPropio extends RecyclerView.ViewHolder {

        private ImageView imagen;
        private TextView nombre;
        private LinearLayout layout;

        public HolderAdapterPropio(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.logo);
            nombre = itemView.findViewById(R.id.version);
            layout = itemView.findViewById(R.id.layout_recycler);
        }

        public ImageView getImagen() {
            return imagen;
        }

        public TextView getNombre() {
            return nombre;
        }

        public LinearLayout getLayout() {
            return layout;
        }
    }

    public interface OnMiRecyclerListener {
        public void onMiRecycler(Version version);
    }
}