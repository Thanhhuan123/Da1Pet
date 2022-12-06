package com.example.da1pet.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.da1pet.R;


public class TopHangFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top_hang, container, false);

        Context context = getActivity();
        RecyclerView rv = view.findViewById(R.id.topHang);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        rv.setLayoutManager(manager);

        return view;
    }
}