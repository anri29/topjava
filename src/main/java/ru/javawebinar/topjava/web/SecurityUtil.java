package ru.javawebinar.topjava.web;

import static ru.javawebinar.topjava.util.MealsUtil.DEFAULT_CALORIES_PER_DAY;
//util for security
public class SecurityUtil {

    public static int authUserId() {
        return 1;
    }

    public static int authUserCaloriesPerDay() {
        return DEFAULT_CALORIES_PER_DAY;
    }
}