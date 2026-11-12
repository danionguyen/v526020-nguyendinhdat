/**
 * Interface Shape: mô tả các thao tác chung cho mọi hình trong ứng dụng Paint.
 */
public interface Shape {


    double area();

    double perimeter();

    Point getCenter();

    default double distance(Shape other) {
        return getCenter().distance(other.getCenter());
    }


    void move(double dx, double dy);

    void rotate(double angleDegrees);

    void zoom(double factor);
}
