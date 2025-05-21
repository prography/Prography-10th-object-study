package jongeuni.chapther05;

import lombok.Getter;

import java.time.LocalDateTime;

public class Screening {
    // 2 - 책임에 필요한 인스턴스 변수 결정
    private Movie movie;
    @Getter
    private int sequence;
    @Getter
    private LocalDateTime whenScreened;

    // 1 - 예매하라 책임 결정
//    public Reservation reserve(Customer customer, int audienceCount) {
//
//    }
//
//    // 3 - 가격을 계산하 (송신자 입장 의도 표현)
//    private Money calculateFee(int audienceCount) {
//
//    }


}
