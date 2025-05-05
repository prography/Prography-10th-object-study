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

    public Money getFee() {
        return fee;
    }

    public void setFee(Money fee) {
        this.fee = fee;
    }

    public List<DisCountCondition> getDisCountConditions() {
        return disCountConditions;
    }

    public void setDisCountConditions(List<DisCountCondition> disCountConditions) {
        this.disCountConditions = disCountConditions;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public Money getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Money discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }
}
