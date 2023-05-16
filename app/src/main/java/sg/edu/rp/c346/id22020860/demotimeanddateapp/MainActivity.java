package sg.edu.rp.c346.id22020860.demotimeanddateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    TextView tvDisplay;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnDisplayDate = findViewById(R.id.buttonDisplayDate);
        btnDisplayTime = findViewById(R.id.buttonDisplayTime);
        tvDisplay = findViewById(R.id.textViewDisplay);
        btnReset = findViewById(R.id.reset);



        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            if (tp.getMinute() < 10 && tp.getHour() >= 10){
                tvDisplay.setText("Time is " + tp.getHour()+":0"+tp.getMinute());
            }
            else if(tp.getHour() < 10 && tp.getMinute() >= 10){
                tvDisplay.setText("Time is 0" + tp.getHour()+":"+tp.getMinute());
                }
            else if(tp.getMinute() < 10 && tp.getHour() < 10){
                tvDisplay.setText("Time is 0" + tp.getHour()+":0"+tp.getMinute());
            }
            else{
                tvDisplay.setText("Time is " + tp.getHour()+":"+tp.getMinute());
            }

            }
        });
        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = dp.getYear();
                int month = dp.getMonth() + 1;
                int dayOfMonth = dp.getDayOfMonth();
                String dateString = ("Date is " + dayOfMonth + "/" + month + "/" + year ) ;
                tvDisplay.setText(dateString);



            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            dp.updateDate(2020,0,1);
            tp.setHour(0);
            tp.setMinute(0);

            }
        });


    }}