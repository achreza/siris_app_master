package com.example.reza.pbobeta;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class barang extends Fragment  {
    @Nullable
//    private RecyclerView recyclerView;
//    List<ListBarang> barangList;
//
//    private RequestQueue mQueue;
//    private CardView daftarbarang;
//    private TextView txtnamaBarang;
//    private TextView txtstokBarang;
//    private RecyclerView.Adapter adapter ;



    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment_barang, container, false);
//        txtnamaBarang= view.findViewById(R.id.namabarang);
//        txtstokBarang= view.findViewById(R.id.stokbarang);
//        recyclerView = (RecyclerView) view.findViewById(R.id.recycleview_barang);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        mQueue = Volley.newRequestQueue(getActivity());










        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        Fragment fragment = getFragmentManager().findFragmentById(android.R.id.content);
        if (fragment == null) {
            fragment = MemberFragment.newInstance();
            getFragmentManager()
                    .beginTransaction()
                    .replace(android.R.id.content, fragment, "")
                    .commit();
        } else {
            getFragmentManager()
                    .beginTransaction()
                    .attach(fragment)
                    .commit();




        }




    return view;
    }
//    public void balik(){
//        Button btnButton;
//
//        btnButton = (Button)getView().findViewById(R.id.buttonBalik);
//        btnButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), mainmenu.class);
//                barang.this.startActivity(intent);
//            }
//    });}



}

//
//
//
//
//
//        getBarang();
//
//        return view;
//
//    }
//
//
//    public barang() {
//        // Required empty public constructor
//    }
//
//    public void getBarang() {
//        String url = "http://192.168.100.11/siris-api/barang";
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            JSONArray jsonArray = response.getJSONArray("barang");
//                            for (int i = 0; i < jsonArray.length(); i++) {
//                                JSONObject dataBarang = jsonArray.getJSONObject(i);
//
//                                barangList.add(new ListBarang(
//                                        dataBarang.getString("ID_BARANG"),
//                                        dataBarang.getString("NAMA_BARANG"),
//                                        dataBarang.getString("STOK")
//                                ));
//                            }
//                                barangAdapter adapter = new barangAdapter(getActivity(),barangList);
//                                recyclerView.setAdapter(adapter);
//                                txtnamaBarang.append(dataBarang.getString("NAMA_BARANG"));
//
//
//
//
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//            }
//        });
//        mQueue.add(request);

//    }




//}
