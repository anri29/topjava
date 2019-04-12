package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;

import java.util.Collection;
//repository of memory for all meal
public interface MealRepository {
    Meal save(Meal meal);

    void delete(int id);

    Meal get(int id);

    Collection<Meal> getAll();
}
