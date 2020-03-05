package com.example.gestion_alumnos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.gestion_alumnos.R;
import com.example.gestion_alumnos.utils.UserUser;
import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.HolderAdapter> {

    Context c;
    ArrayList <UserUser> data;
    View v;

    public AdaptadorRecycler(ArrayList data, Context c) {
        this.data = data;
        this.c = c;
    }

    @Override
    public HolderAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        v = LayoutInflater.from(c).inflate(R.layout.activity_main, parent, false);
        return new HolderAdapter(v);
    }

    @Override
    public void onBindViewHolder(HolderAdapter holder, int position) {


        UserUser actual = data.get(position);
        holder.getName().setText(actual.getName());
        holder.getSurname().setText(actual.getSurname());
        holder.getPhone().setText(String.valueOf(actual.getPhone()));
        holder.getImage().setImageResource(R.drawable.user);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class HolderAdapter extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name, surname, phone;

        public HolderAdapter(View itemView) {
            super(itemView);

            image = v.findViewById(R.id.imageView);
            name = v.findViewById(R.id.nombre);
            surname = v.findViewById(R.id.apellido);
            phone = v.findViewById(R.id.telefono);
        }

        public ImageView getImage() {
            return image;
        }

        public TextView getName() {
            return name;
        }

        public TextView getSurname() {
            return surname;
        }

        public TextView getPhone() {
            return phone;
        }
    }
}