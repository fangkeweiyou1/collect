package com.collect.annotationstest;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.collect.contants.Test3Constants.*;

/**
 * Created by zhangyuncai on 2017/8/26.
 */
@IntDef({SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY})
@Retention(RetentionPolicy.SOURCE)
public @interface WeekDays {
}
