package com.infowave.redstar.eazylo.activity;

import android.app.Application;
import android.content.Context;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.infowave.redstar.eazylo.MainActivity;
import com.infowave.redstar.eazylo.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;
    private String[] item;

    private ExpandableListView mExpandableListView;
    private ExpandableListAdapter mExpandableAdapter;
    private List<String> mExpandableListTitle;

    private Map<String, List<String>> mExpandableListData;

    private RecyclerView horizontal_recycler_view;

    HorizontalAdapter horizontalAdapter;

    private List<Data> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        horizontal_recycler_view = (RecyclerView) findViewById(R.id.horizontal_recycler_view);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mExpandableListView = (ExpandableListView) findViewById(R.id.nav_list);


        data = fill_with_data();

        horizontalAdapter = new HorizontalAdapter(data, getApplication());

        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManager);
        horizontal_recycler_view.setAdapter(horizontalAdapter);

    }

    public List<Data> fill_with_data() {

        List<Data> data = new ArrayList<>();

        data.add(new Data(R.drawable.mobile, "Mobile"));
        data.add(new Data(R.drawable.mobile, "DTH"));
        data.add(new Data(R.drawable.mobile, "Data Card"));
        data.add(new Data(R.drawable.mobile, "Landline"));
        data.add(new Data(R.drawable.mobile, "Electricity"));
        data.add(new Data(R.drawable.mobile, "Gas"));
        data.add(new Data(R.drawable.mobile, "Insurance"));
        data.add(new Data(R.drawable.mobile, "Bronband"));
        data.add(new Data(R.drawable.mobile, "Image 3"));

        return data;
    }

    public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {


        List<Data> horizontalList = Collections.emptyList();
        Context context;


        public HorizontalAdapter(List<Data> horizontalList, Context context) {
            this.horizontalList = horizontalList;
            this.context = context;
        }


        public class MyViewHolder extends RecyclerView.ViewHolder {

            ImageView imageView;
            TextView txtview;

            public MyViewHolder(View view) {
                super(view);
                imageView = (ImageView) view.findViewById(R.id.imageview);
                txtview = (TextView) view.findViewById(R.id.txtview);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }
        }


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recharge_pay_itemlist, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {

            holder.imageView.setImageResource(horizontalList.get(position).imageId);
            holder.txtview.setText(horizontalList.get(position).txt);

            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    String list = horizontalList.get(position).txt.toString();
                    Toast.makeText(HomeActivity.this, list, Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(HomeActivity.this, MobileRechargeActivity.class);
                    startActivity(intent);
                }

            });

        }


        @Override
        public int getItemCount() {
            return horizontalList.size();
        }
    }

}
