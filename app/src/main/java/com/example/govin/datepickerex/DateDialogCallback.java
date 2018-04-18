package com.example.govin.datepickerex;

import android.widget.DatePicker;

public interface DateDialogCallback {
    void onDateSet(int dialogType, DatePicker view, int year, int month, int dayOfMonth);
}
