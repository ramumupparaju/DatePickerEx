package com.example.govin.datepickerex;

import android.app.DatePickerDialog;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         textView= (TextView)findViewById(R.id.startDate);
         textView2= (TextView)findViewById(R.id.endDate);
         textView.setOnClickListener(this);
         textView2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int dialogType = 0;
        switch (view.getId()) {
            case R.id.startDate:
                dialogType = 1;
                break;
            case R.id.endDate:
                dialogType = 2;
                break;

            default:
                //do nothing
                break;
        }
        showDatePicker(Calendar.getInstance(), dialogType);
    }


    private void showDatePicker(Calendar calendar, int dateDialogType) {
        CustomDateListener customDateDialog = new CustomDateListener(dateDialogType, dateDialogCallback);
        int customStyle = android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
                ? R.style.DatePickerDialogTheme : android.R.style.Theme_DeviceDefault_Light_Dialog;
        DatePickerDialog datePicker = new DatePickerDialog(this,
                customStyle,
                customDateDialog,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        datePicker.setCancelable(false);
        datePicker.show();
    }

    DateDialogCallback dateDialogCallback = new DateDialogCallback() {
        @Override
        public void onDateSet(int dialogType, DatePicker view, int year,
                              int month, int dayOfMonth) {
            Calendar selectedDateTime = Calendar.getInstance();
            selectedDateTime.set(year, month, dayOfMonth);
            String formattedDate = DateUtils1.convertMillsToDateString("dd-E-MMMM-yyyy", selectedDateTime.getTimeInMillis());
            switch (dialogType) {
                case 1:
                    textView.setText(formattedDate);
                    break;
                case 2:
                    if (!ValidationUtils.isFutureDate(selectedDateTime)) {
                        Toast.makeText(getApplicationContext(),"canot select past date",Toast.LENGTH_LONG).show();
                        return;
                    }
                    textView2.setText(formattedDate);
                    break;


            }
        }
    };
}
