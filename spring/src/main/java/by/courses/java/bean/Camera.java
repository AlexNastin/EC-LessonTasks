package by.courses.java.bean;

public class Camera {

    private String name;

    public Camera() {
    }

    public Camera(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Camera{");
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
