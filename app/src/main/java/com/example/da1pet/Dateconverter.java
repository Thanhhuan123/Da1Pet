package com.example.da1pet;

import android.content.Context;

import androidx.room.TypeConverter;

import java.text.DateFormat;
import java.util.Date;

public class Dateconverter {
        @TypeConverter
        public static Date toDate(Long dateLong){
            return dateLong == null ? null: new Date(dateLong);
        }

        @TypeConverter
        public static Long fromDate(Date date){
            return date == null ? null : date.getTime();
        }

}
