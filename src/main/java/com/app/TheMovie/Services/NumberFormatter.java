package com.app.TheMovie.Services;

public class NumberFormatter {
    public static String formatPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() != 11) {
            return phoneNumber;
        }
        return phoneNumber.substring(0, 1) + "-" + phoneNumber.substring(1, 4) + "-" +
                phoneNumber.substring(4, 7) + "-" + phoneNumber.substring(7, 9) + "-" + phoneNumber.substring(9);
    }
}
