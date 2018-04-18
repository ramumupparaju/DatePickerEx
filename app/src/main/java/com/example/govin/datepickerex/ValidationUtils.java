package com.example.govin.datepickerex;

import java.util.Calendar;

/**
 * Created by govin on 18-04-2018.
 */

public class ValidationUtils {

    public static boolean isFutureDate(Calendar dobDate) {
        // current date
        Calendar currentDate = Calendar.getInstance();
        if (dobDate.after(currentDate)) {
            return true;
        }
        return false;
    }
}
