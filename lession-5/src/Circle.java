public class Circle implements Shape {
    private Point center;
    private double radius;

    public Circle() {
        this(new Point(), 1);
    }

    public Circle(Point center, double radius) {
        this.center = new Point(center);
        setRadius(radius);
    }

    public Point getCenterPoint() {
        return new Point(center);
    }

    public void setCenter(Point center) {
        this.center = new Point(center);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Bán kính phải > 0");
        }
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public Point getCenter() {
        return new Point(center);
    }

    @Override
    public void move(double dx, double dy) {
        center.move(dx, dy);
    }

    @Override
    public void rotate(double angleDegrees) {
        // Hình tròn xoay quanh tâm thì không thay đổi
    }

    @Override
    public void zoom(double factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("Hệ số zoom phải > 0");
        }
        radius *= factor;
    }

    @Override
    public String toString() {
        return String.format("Circle[center=%s, r=%.2f]", center, radius);
    }
}
