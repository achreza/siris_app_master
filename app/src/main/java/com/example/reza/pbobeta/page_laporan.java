package com.example.reza.pbobeta;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class page_laporan extends AppCompatActivity {
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private TextView tvDateResult;
    private Button btDatePicker;
    private TextView tvDateResult1;
    private Button btDatePicker1;
    private LinearLayout awal;
    private LinearLayout akhir;
    InventoryDbHelper dbHelper;
    LaporanAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_laporan);
        dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

        awal = (LinearLayout) findViewById(R.id.mulaitanggal);
        akhir = (LinearLayout) findViewById(R.id.akhirtanggal);

        tvDateResult = (TextView) findViewById(R.id.tv_dateresult);
//        btDatePicker = (Button) findViewById(R.id.bt_datepicker);
        awal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });
        tvDateResult1 = (TextView) findViewById(R.id.tv_dateresult1);
//        btDatePicker1 = (Button) findViewById(R.id.bt_datepicker1);
        akhir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog1();
            }
        });
        final Button lihatLaporan = (Button) findViewById(R.id.btnLihatLaporan);





        lihatLaporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                if (tvDateResult.getText().toString().equals("Tanggal Awal") && tvDateResult1.getText().toString().equals("Tanggal Akhir"))
                {
                    Toast.makeText(page_laporan.this,"Silahkan Pilih Tanggal Terlebih Dahulu",Toast.LENGTH_LONG).show();
                }else{
                    String date1 = (String) tvDateResult.getText();
                    String date2 = (String) tvDateResult1.getText();

                    Intent intent = new Intent(page_laporan.this, tampilLaporan.class);
                    intent.putExtra("date1", date1);
                    intent.putExtra("date2", date2);
                    startActivity(intent);
                }



            }



//                Cursor cursor = dbHelper.readLaporanByTanggal(date1,date2);
//        adapter = new LaporanAdapter(this,cursor);


        });


    }
    private void showDateDialog(){

        /**
         * Calendar untuk mendapatkan tanggal sekarang
         */
        Calendar newCalendar = Calendar.getInstance();

        /**
         * Initiate DatePicker dialog
         */
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                /**
                 * Method ini dipanggil saat kita selesai memilih tanggal di DatePicker
                 */

                /**
                 * Set Calendar untuk menampung tanggal yang dipilih
                 */
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                /**
                 * Update TextView dengan tanggal yang kita pilih
                 */
                tvDateResult.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        /**
         * Tampilkan DatePicker dialog
         */
        datePickerDialog.show();
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



    private void showDateDialog1(){

        /**
         * Calendar untuk mendapatkan tanggal sekarang
         */
        Calendar newCalendar = Calendar.getInstance();

        /**
         * Initiate DatePicker dialog
         */
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                /**
                 * Method ini dipanggil saat kita selesai memilih tanggal di DatePicker
                 */

                /**
                 * Set Calendar untuk menampung tanggal yang dipilih
                 */
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                /**
                 * Update TextView dengan tanggal yang kita pilih
                 */
                tvDateResult1.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        /**
         * Tampilkan DatePicker dialog
         */
        datePickerDialog.show();
    }


    public page_laporan() {
        // Required empty public constructor
    }

}
