package ks.hs.emirim.hyojin.adhj_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class WeekActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week);

        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(btnListener1);

        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(btnListener2);

        Button btn3 = findViewById(R.id.calendar_week_btn);
        btn3.setOnClickListener(btnListener3);

        Button btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(btnListener4);

        ListView listView = findViewById(R.id.listView);


        List list = new ArrayList();
        list.add("1월");
        list.add("2월");
        list.add("3월");
        list.add("4월");
        list.add("5월");
        list.add("6월");
        list.add("7월");
        list.add("8월");
        list.add("9월");
        list.add("10월");
        list.add("11월");
        list.add("12월");

        ArrayAdapter<String> adpater = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1,list);
        listView.setAdapter(adpater);
        listView.setDividerHeight(30);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a_parent, View a_view, int a_position, long a_id) {
//                final PhCountryItem item = (PhCountryItem) mCountryAdapter.getItem(a_position);
                Intent intent = new Intent(getApplicationContext(),graphActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    View.OnClickListener btnListener1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        }
    };
    View.OnClickListener btnListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), WeekActivity.class);
            startActivity(intent);
            finish();
        }
    };
    View.OnClickListener btnListener3 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), TaTCalendarWeekActivity.class);
            startActivity(intent);
            finish();
        }
    };
    View.OnClickListener btnListener4 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), StatisticsActivity.class);
            startActivity(intent);
            finish();
        }

    };
}