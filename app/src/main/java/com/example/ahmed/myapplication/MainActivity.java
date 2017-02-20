package com.example.ahmed.myapplication;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    DrawerLayout drawer ;
    ListView listView;

    Button b1;

    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = (DrawerLayout)findViewById(R.id.DrawerLayout);
        listView=(ListView)findViewById(R.id.listView);

        b1=(Button) findViewById(R.id.button);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawer.openDrawer(Gravity.LEFT);
            }
        });

        list.add("Setting");
        list.add("Profile");
        list.add("Home");

        MyAdapter adapter = new MyAdapter(list);


        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                drawer.closeDrawers();
                Toast.makeText(MainActivity.this,String.valueOf(position),Toast.LENGTH_SHORT).show();
            }
        });
    }


    private class MyAdapter extends BaseAdapter{

        ArrayList<String> Data = new ArrayList<>();

        MyAdapter(ArrayList<String> list){

            Data=list;
        }

        @Override
        public int getCount() {
            return Data.size();
        }

        @Override
        public Object getItem(int position) {
            return Data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            LayoutInflater inflater = getLayoutInflater();

            View view = inflater.inflate(R.layout.listview_layout,parent,false);

            TextView t1= (TextView)view.findViewById(R.id.textView);

            t1.setText(Data.get(position));


            return view;
        }
    }
}
