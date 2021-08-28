package com.example.reza.pbobeta;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.zip.Inflater;

public class barangbaru extends AppCompatActivity {

    private final static String LOG_TAG = barangbaru.class.getCanonicalName();
    InventoryDbHelper dbHelper;
    StockCursorAdapter adapter;
    int lastVisibleItem = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barangbaru);
        dbHelper = new InventoryDbHelper(this);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(barangbaru.this, DetailsActivity.class);
                startActivity(intent);
            }
        });

        final ListView listView = (ListView) findViewById(R.id.list_view);
        View emptyView = findViewById(R.id.empty_view);
        listView.setEmptyView(emptyView);

        Cursor cursor = dbHelper.readStock();

        adapter = new StockCursorAdapter( this, cursor);
        listView.setAdapter(adapter);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if(scrollState == 0) return;
                final int currentFirstVisibleItem = view.getFirstVisiblePosition();
                if (currentFirstVisibleItem > lastVisibleItem) {
                    fab.show();
                } else if (currentFirstVisibleItem < lastVisibleItem) {
                    fab.hide();
                }
//                fab.show();
                lastVisibleItem = currentFirstVisibleItem;
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.swapCursor(dbHelper.readStock());
    }

    public void clickOnViewItem(long id) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("itemId", id);
        startActivity(intent);
    }

    public void clickOnSale(long id, int quantity) {
        dbHelper.sellOneItem(id, quantity);
        adapter.swapCursor(dbHelper.readStock());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_add_dummy_data:
                // add dummy data for testing
                addDummyData();
                adapter.swapCursor(dbHelper.readStock());
                Toast.makeText(this,"Data Telah Ditambahkan ",Toast.LENGTH_SHORT).show();
                break;


            case R.id.btn_laporan:
                Intent intent = new Intent(this, page_laporan.class);
                startActivity(intent);
                break;


            case R.id.btn_gantipw:
                Intent pw = new Intent(this, gantipw.class);
                startActivity(pw);
                break;


        }
        return super.onOptionsItemSelected(item);
    }



    /**
     * Add data for demo purposes
     */
    private void addDummyData() {
        StockItem meja = new StockItem(
                "Meja",
                "800000",
                45,
                "android.resource://eu.laramartin.inventorymanager/drawable/empty_white_box");
        dbHelper.insertItem(meja);

        StockItem kursi = new StockItem(
                "Kursi",
                "400000",
                45,
                "android.resource://eu.laramartin.inventorymanager/drawable/empty_white_box");
        dbHelper.insertItem(kursi);

        StockItem ac = new StockItem(
                "AC",
                "1000000",
                3,
                "android.resource://eu.laramartin.inventorymanager/drawable/empty_white_box");
        dbHelper.insertItem(ac);

        StockItem router = new StockItem(
                "Router",
                "450000",
                1,
                "android.resource://eu.laramartin.inventorymanager/drawable/empty_white_box");
        dbHelper.insertItem(router);

        StockItem pc = new StockItem(
                "Komputer",
                "4500000",
                30,
                "android.resource://eu.laramartin.inventorymanager/drawable/empty_white_box");
        dbHelper.insertItem(pc);

        StockItem Mouse = new StockItem(
                "Mouse",
                "100000",
                35,
                "android.resource://eu.laramartin.inventorymanager/drawable/empty_white_box");
        dbHelper.insertItem(Mouse);

        StockItem Keyboard = new StockItem(
                "Keyboard",
                "100000",
                35,
                "android.resource://eu.laramartin.inventorymanager/drawable/empty_white_box");
        dbHelper.insertItem(Keyboard);

    }

}
