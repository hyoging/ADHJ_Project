package ks.hs.emirim.hyojin.adhj_project;


import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class StatisticsActivity extends AppCompatActivity {
    PieChart pieChart;

    public StatisticsActivity() {
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        Toolbar toolbar = findViewById(R.id.next_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//뒤로가기
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitleTextColor(Color.rgb(100, 98, 98));

        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(btnListener1);

        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(btnListener2);

        Button btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(btnListener3);

        Button btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(btnListener4);

        pieChart = (PieChart) findViewById(R.id.piechart);

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5, 10, 5, 5);

        pieChart.setDragDecelerationFrictionCoef(0.95f);

        pieChart.setDrawHoleEnabled(false);
        pieChart.setHoleColor(Color.YELLOW);
        pieChart.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> yValues = new ArrayList<PieEntry>();

        yValues.add(new PieEntry(34f, "식비"));
        yValues.add(new PieEntry(23f, "교통비"));
        yValues.add(new PieEntry(14f, "취미"));
        yValues.add(new PieEntry(35f, "생필품"));
        yValues.add(new PieEntry(40f, "뷰티"));

        PieDataSet dataSet = new PieDataSet(yValues, "account book");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(35);
        dataSet.setValueTextSize(25);
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        PieData data = new PieData((dataSet));
        data.setValueTextSize(25);
        data.setValueTextColor(Color.YELLOW);

        pieChart.setData(data);

    }

    View.OnClickListener btnListener1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
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
            Intent intent = new Intent(getApplicationContext(), DayActivity.class);
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

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

}