package com.example.govin.datepickerex;

import android.app.DatePickerDialog;
import android.widget.DatePicker;


public class CustomDateListener implements DatePickerDialog.OnDateSetListener {

    private DateDialogCallback dateDialogCallback;
    private int dialogType;

    public CustomDateListener(int dialogType, DateDialogCallback dateDialogCallback) {
        this.dateDialogCallback = dateDialogCallback;
        this.dialogType = dialogType;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        dateDialogCallback.onDateSet(dialogType, view, year, month, dayOfMonth);
    }
}
