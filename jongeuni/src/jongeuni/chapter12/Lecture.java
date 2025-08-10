package jongeuni.chapter12;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Lecture {
    private int pass;
    private String title;
    @Getter
    private List<Integer> scores = new ArrayList<>();

    public double average() {
        return scores.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public String evaluate() {
        return String.format("Pass:%d Fail:%d", passCount(), failCount());
    }

    private long passCount() {
        return scores.stream().filter(score -> score>=pass).count();
    }

    private long failCount() {
        return scores.size() - passCount();
    }

}
