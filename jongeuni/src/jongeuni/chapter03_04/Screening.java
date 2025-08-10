package jongeuni.chapter03_04;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Money calculateFee(int audienceCount) {
        switch (movie.getMovieType()) {
            case AMOUNT_DISCOUNT -> {
                if(movie.isDiscountable(whenScreened, sequence)) {
                    return movie.calculateAmountDiscountFee().times(audienceCount);
                }
            }
            case PERCENT_DISCOUNT -> {
                if(movie.isDiscountable(whenScreened, sequence)) {
                    return movie.calculatePercentDiscountedFee().times(audienceCount);
                }
            }
            case NONE_DISCOUNT -> {
                return movie.calculateNoneDiscountedFee().times(audienceCount);
            }
        };

        return movie.calculateNoneDiscountedFee().times(audienceCount);
    }
}
