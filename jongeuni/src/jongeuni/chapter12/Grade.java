package jongeuni.chapter12;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Grade {
    @Getter
    private String name;
    private int upper, lower;

    public boolean isName(String name) {
        return this.name.equals(name);
    }

    public boolean include(int score) {
        return score >= lower && score <= upper;
    }
}
