package jongeuni.chapther12;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Professor {
    private String name;
    private Lecture lecture;

    public String compileStatistics() {
        return String.format("[%s] %s - Avg: %.1f", name, lecture.evaluate(), lecture.average());
    }
}
