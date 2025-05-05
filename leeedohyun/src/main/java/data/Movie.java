package data;

import java.time.Duration;
import java.util.List;

import movie.DisCountCondition;
import movie.Money;

public class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DisCountCondition> disCountConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;
}
