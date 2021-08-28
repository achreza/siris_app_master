package com.example.reza.pbobeta;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by docotel on 3/7/16.
 */
public class MemberFragment extends Fragment {

    private RecyclerView listMember;
    private LinearLayoutManager linearLayoutManager;
    private MemberListAdapter memberListAdapter;
    private RequestQueue mQueue;
    protected Context context;

    public static MemberFragment newInstance(){
        return new MemberFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.isibarang, container, false);

        listMember = (RecyclerView) rootView.findViewById(R.id.listMember);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        linearLayoutManager = new LinearLayoutManager(context);
        memberListAdapter = new MemberListAdapter();

        listMember.setLayoutManager(linearLayoutManager);
        listMember.setAdapter(memberListAdapter);

        loadData();
    }

    private void loadData(){
        List<Member> memberList = new ArrayList<>();


        String name[] = {"Meja","Kursi","Komputer","AC"};

        String team[] = {"30","30","15","6"};
//        String url = "http://192.168.43.12/siris-api/barang";
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        List<Member> memberList = new ArrayList<>();
//                        Member member;
//                        String idBarang;
//                        String namaBarang;
//                        String stokBarang;
//                        try {
//                            JSONArray jsonArray = response.getJSONArray("barang");
//                            for (int i = 0; i < jsonArray.length(); i++) {
//                                member = new Member();
//                                JSONObject dataBarang = jsonArray.getJSONObject(i);
//                                idBarang = dataBarang.getString("ID_BARANG");
//                                namaBarang = dataBarang.getString("NAMA_BARANG");
//                                stokBarang = dataBarang.getString("STOK");
//                                member.setId(idBarang);
//                                member.setName(namaBarang);
//                                member.setTeam(stokBarang);
//                                memberList.add(member);
//                            }
//                            memberListAdapter.addAll(memberList);
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
        Member member;
        for(int i=0; i < name.length; i++){
            member = new Member();

            member.setId("1");
            member.setName(name[i]);
            member.setTeam(team[i]);


            memberList.add(member);
        }

        memberListAdapter.addAll(memberList);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}