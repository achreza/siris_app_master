package com.example.reza.pbobeta;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class gantipw extends AppCompatActivity {
    InventoryDbHelper dbHelper;
    Button btngantipw;
    EditText pwlama,pwbaru,pwulang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gantipw);

        dbHelper = new InventoryDbHelper(this);
        btngantipw = (Button)findViewById(R.id.btn_gantipw);
        pwlama = (EditText)findViewById(R.id.passwordlama);
        pwbaru = (EditText)findViewById(R.id.passwordbaru);
        pwulang = (EditText)findViewById(R.id.passwordulang);







        btngantipw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String passlama = pwlama.getText().toString();
                String passbaru = pwbaru.getText().toString();
                String passulang = pwulang.getText().toString();
                Cursor cursor = dbHelper.cekPasswordLama(passlama);

                if (pwbaru.getText().toString().equals("") && pwulang.getText().toString().equals(""))
                {
                    Toast.makeText(gantipw.this,"Silahkan Isi Data Terlebih Dahulu",Toast.LENGTH_LONG).show();
                }else{
                    if (cursor.getCount() > 0){



                        if(passbaru.equals(passulang)){
                            dbHelper.gantiPassword(passbaru);
                            AlertDialog.Builder builder = new AlertDialog.Builder(gantipw.this);
                            builder.setMessage("Password Berhasil diubah !")
                                    .setNegativeButton("Retry", null).create().show();
                            Intent intent = new Intent(gantipw.this, barangbaru.class);
                            gantipw.this.startActivity(intent);
                            finish();
                        }else{

                            AlertDialog.Builder builder = new AlertDialog.Builder(gantipw.this);
                            builder.setMessage("password harus sama")
                                    .setNegativeButton("Retry", null).create().show();
                        }
                    }else {

                        AlertDialog.Builder builder = new AlertDialog.Builder(gantipw.this);
                        builder.setMessage("Password Lama Salah salah!")
                                .setNegativeButton("Retry", null).create().show();
                    }

                }

            }

        });




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_gantipw, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.btn_laporan:
                Intent intent = new Intent(this, page_laporan.class);
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
