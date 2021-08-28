package com.example.reza.pbobeta;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class barangAdapter extends RecyclerView.Adapter<barangAdapter.BarangViewHolder> {

    private Activity mCtx;
    private List<ListBarang> barangListing;

    public barangAdapter(Activity mCtx, List<ListBarang> barangList) {
        this.mCtx = mCtx;
        this.barangListing = barangList;
    }

    @Override
    public BarangViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewbarang, parent, false);
        BarangViewHolder barangViewHolder = new BarangViewHolder(view);
        return barangViewHolder;
    }


    @Override
    public void onBindViewHolder(BarangViewHolder holder, int position) {
        final ListBarang listBarangFinal = barangListing.get(position);


        holder.textViewTitle.setText(listBarangFinal.getNama_barang());

    }

    @Override
    public int getItemCount() {
        return barangListing.size();
    }

    class BarangViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        TextView textViewStok;
        View view;

        public BarangViewHolder(View itemView) {
            super(itemView);
            view = itemView;

            textViewTitle = itemView.findViewById(R.id.namabarang);
            textViewStok = itemView.findViewById(R.id.stokbarang);

        }
    }
}

