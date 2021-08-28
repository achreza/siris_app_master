package com.example.reza.pbobeta;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

public class tampilLaporan extends AppCompatActivity {
    InventoryDbHelper dbHelper;
    LaporanAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_laporan);
        dbHelper = new InventoryDbHelper(this);
        String date1 = getIntent().getStringExtra("date1");
        String date2 = getIntent().getStringExtra("date2");
//        Cursor cursor = dbHelper.readLaporan();
        Cursor cursor = dbHelper.readLaporanByTanggal(date1,date2);
        final ListView listView = (ListView) findViewById(R.id.list_view);
//        TextView emptyViewText = findViewById(R.id.empty_view_text);
//        emptyViewText.setText(date1+"-"+date2);
//        listView.setEmptyView(emptyView);


        adapter = new LaporanAdapter( this, cursor);
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_laporan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.btn_gantipw:
                Intent intent = new Intent(this, gantipw.class);
                startActivity(intent);
                break;


            case R.id.btn_utama:
                Intent pw = new Intent(this, barangbaru.class);
                startActivity(pw);
                break;


        }
        return super.onOptionsItemSelected(item);
    }



}
