package ks.hs.emirim.hyojin.adhj_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WeekActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week);

        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(btnListener1);

        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(btnListener2);

        Button btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(btnListener3);

        Button btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(btnListener4);
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
}