package com.example.reza.pbobeta;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LaporanAdapter extends CursorAdapter {


    private final tampilLaporan activity;

    public LaporanAdapter(tampilLaporan context, Cursor c) {
        super(context, c, 0);
        this.activity = context;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.list_laporan, viewGroup, false);
    }

    @Override
    public void bindView(View view, final Context context, final Cursor cursor) {

        TextView txtNamaLama = (TextView) view.findViewById(R.id.oldproduct_name);
        TextView txtNamaBaru = (TextView) view.findViewById(R.id.newproduct_name);

        TextView txtStokLama = (TextView) view.findViewById(R.id.oldquantity);
        TextView txtStokBaru = (TextView) view.findViewById(R.id.newquantity);

        TextView txtHargaLama = (TextView) view.findViewById(R.id.oldprice);
        TextView txtHargaBaru = (TextView) view.findViewById(R.id.newprice);
        TextView txtTanggal = (TextView) view.findViewById(R.id.tanggal);



        String namaLama = cursor.getString(cursor.getColumnIndex(TabelLaporan.EntryLaporan.COLUMN_OLDNAME));
        String namaBaru = cursor.getString(cursor.getColumnIndex(TabelLaporan.EntryLaporan.COLUMN_NEWNAME));

        String stokBaru = cursor.getString(cursor.getColumnIndex(TabelLaporan.EntryLaporan.COLUMN_STOKBARU));
        String stokLama = cursor.getString(cursor.getColumnIndex(TabelLaporan.EntryLaporan.COLUMN_STOKLAMA));

        String hargaLama = cursor.getString(cursor.getColumnIndex(TabelLaporan.EntryLaporan.COLUMN_HARGALAMA));
        String hargaBaru = cursor.getString(cursor.getColumnIndex(TabelLaporan.EntryLaporan.COLUMN_HARGABARU));

        String tanggal = cursor.getString(cursor.getColumnIndex(TabelLaporan.EntryLaporan.COLUMN_DATE));


        txtNamaLama.setText(namaLama);
        if(namaLama.equals(namaBaru)){
            txtNamaBaru.setText("-");
        }else{
            txtNamaBaru.setText(namaBaru);
        }

        txtHargaLama.setText(hargaLama);
        if(hargaLama.equals(hargaBaru)){
            txtHargaBaru.setText("-");
        }else{
            txtHargaBaru.setText(hargaBaru);
        }

        txtStokLama.setText(stokLama);
        if(stokLama.equals(stokBaru)){
            txtStokBaru.setText("-");
        }else{
            txtStokBaru.setText(stokBaru);
        }
        txtTanggal.setText(tanggal);
        final long id = cursor.getLong(cursor.getColumnIndex(TabelLaporan.EntryLaporan._ID));

//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                activity.clickOnViewItem(id);
//            }
//        });
//
//        sale.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                activity.clickOnSale(id,
//                        quantity);
//            }
//        });
    }
}
