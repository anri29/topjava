package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class MealsUtil {//логика обработки данных фильтрация списка еды к приемам пищи по пользователю с учетом каллорий на день
    public static void main(String[] args) {
        List<Meal> mealList = Arrays.asList(
                new Meal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new Meal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );
        getFilteredWithExcessCycle(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000);
//        .toLocalDate();
//        .toLocalTime();
    }

    public static List<MealTo> getFilteredWithExcessCycle(List<Meal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        Map<LocalDate, Integer> caloriesPerD = new HashMap<>();
        mealList.forEach(meal ->  {
            caloriesPerD.put(meal.getDateTime().toLocalDate(), caloriesPerD.merge(meal.getDateTime().toLocalDate(),meal.getCalories(),Integer::sum));
        });//.getOrDefault возвращает значение если ключ есть либо дефалт значение если ключа нет
        List<MealTo> mealToList = new ArrayList<>();
        mealList.forEach(meal ->  {
            if (TimeUtil.isBetween(meal.getDateTime().toLocalTime(), startTime, endTime))
                mealToList.add(new MealTo(meal.getDateTime(), meal.getDescription(), meal.getCalories(), caloriesPerD.get(meal.getDateTime().toLocalDate()) > caloriesPerDay));
        });
        return mealToList;
    }
    public static List<MealTo> getFilteredWithExcessStreams(List<Meal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay){

        Map<LocalDate, Integer> caloriesSumPerDay = mealList.stream().collect(Collectors.groupingBy(um -> um.getDateTime().toLocalDate(), Collectors.summingInt(Meal::getCalories)));
        List<MealTo> fillteredMealList = mealList.stream().filter(um -> TimeUtil.isBetween(um.getDateTime().toLocalTime(), startTime, endTime))
                .map(um -> new MealTo(um.getDateTime(), um.getDescription(), um.getCalories(), caloriesSumPerDay.get(um.getDateTime().toLocalDate()) > caloriesPerDay))
                .collect(Collectors.toList());
        return fillteredMealList;
    }



}