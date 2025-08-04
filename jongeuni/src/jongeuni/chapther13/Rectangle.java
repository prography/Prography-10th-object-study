package jongeuni.chapther13;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Rectangle {
    private int x;
    private int y;
    @Getter
    @Setter
    private int width;
    @Getter
    @Setter
    private int height;

    public int getArea() {
        return width * height;
    }
}
