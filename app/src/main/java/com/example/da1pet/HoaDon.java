package com.example.da1pet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.da1pet.DbRoom.DbRoom;
import com.example.da1pet.Model.Order;
import com.example.da1pet.Model.Order_detail;

import java.text.DateFormat;
import java.util.ArrayList;

public class HoaDon extends AppCompatActivity {
    RecyclerView rv;
    DbRoom db;
    String TAG = "zzzzzzz";
    ArrayList<Order> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don);
        rv = findViewById(R.id.rvorder);
        db = DbRoom.getInstance(this);
        findViewById(R.id.btnback).setOnClickListener(v -> {
            Intent intent = new Intent(HoaDon.this,NavigationActivity.class);
            intent.putExtra("username",getIntent().getExtras().getString("username"));
            startActivity(intent);
        });
        list = (ArrayList<Order>) db.orderDAO().getAllByUser(getIntent().getExtras().getString("username"));
        OrderAdapter adapter = new OrderAdapter(list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);
    }
    public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder>{
        ArrayList<Order> list;

        public OrderAdapter(ArrayList<Order> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public OrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.roworder,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull OrderAdapter.ViewHolder holder, int position) {
            holder.order = list.get(position);
            holder.tv_order_id.setText(String.valueOf(holder.order.getId_order()));
            holder.tv_order_date.setText(holder.order.getDate());
            holder.tvitem.setText(holder.order.getTotal()+" item");
            holder.tv_total.setText(String.valueOf(holder.order.getThanhToan()));
            holder.tvstatus.setText(holder.order.getStatus());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            Order order;
            TextView tv_order_id,tv_order_date,tv_total,tvitem,tvstatus;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                db = DbRoom.getInstance(HoaDon.this);
                tv_order_id = itemView.findViewById(R.id.tv_order_id);
                tvitem = itemView.findViewById(R.id.tvitem);
                tv_order_date = itemView.findViewById(R.id.tv_order_date);
                tv_total = itemView.findViewById(R.id.tv_total);
                tvstatus = itemView.findViewById(R.id.tvstatus);
                itemView.setOnClickListener(v -> {
                    Intent intent = new Intent(HoaDon.this,HoaDonChiTiet.class);
                    order = list.get(getAdapterPosition());
                    intent.putExtra("id_order",order.getId_order());
                    intent.putExtra("username",getIntent().getExtras().getString("username"));
                    startActivity(intent);
                });
            }
        }
    }
}