package ru.javawebinar.topjava.model;

import java.time.LocalDateTime;
//еда пользователя
public class Meal {
    private final LocalDateTime dateTime;//время приема пищи

    private final String description;//описание еды

    private final int calories;//каллории еды

    public Meal(LocalDateTime dateTime, String description, int calories) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }
}
