package modeling;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private List<Course> courses = new ArrayList<>();

    public void registerCourse(Course course) {
        this.courses.add(course);
    }
    public void dropCourse(Course course) {
        this.courses.remove(course);
    }
}
