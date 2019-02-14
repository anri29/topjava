package ru.javawebinar.topjava.model;

import java.time.LocalDateTime;
//еда клиента
public class MealTo {
    private final LocalDateTime dateTime;

    private final String description;

    private final int calories;

    private final boolean excess;//превышен ли порог каллорий пользователя или нет

    public MealTo(LocalDateTime dateTime, String description, int calories, boolean excess) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.excess = excess;
    }
}
