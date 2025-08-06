package jongeuni.chapter14;

import java.util.List;

// 적용 조건을 구현하는 추상화
public interface FeeCondition {
    List<DateTimeInterval> findTimeIntervals(Call call);
}
