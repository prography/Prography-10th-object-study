package lecture;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class GradeLecture extends Lecture {
    private List<Grade> grades;

    public GradeLecture(int pass, String title, List<Integer> scores, List<Grade> grades) {
        super(pass, title, scores);
        this.grades = grades;
    }

    @Override
    public String evaluate() {
        return super.evaluate() + ", " + gradesStatistics();
    }

    @Override
    public String getEvaluationMethod() {
        return "Grade";
    }

    public double average(String gradeName) {
        return grades.stream()
                .filter(each -> each.isName(gradeName))
                .findFirst()
                .map(this::gradeAverage)
                .orElse(0d);
    }

    private double gradeAverage(Grade grade) {
        return getScores().stream()
                .filter(grade::include)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    private String gradesStatistics() {
        return grades.stream()
                .map(grade -> format(grade))
                .collect(joining(" "));
    }

    private String format(Grade grade) {
        return String.format("%s: %d", grade.getName(), gradeCount(grade));
    }

    private long gradeCount(Grade grade) {
        return getScores().stream()
                .filter(grade::include)
                .count();
    }
}
