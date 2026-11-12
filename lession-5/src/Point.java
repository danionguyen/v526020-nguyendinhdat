public class Point implements Shape {
    private double x;
    private double y;

    public Point() {
        this(0, 0);
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point other) {
        this(other.x, other.y);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distance(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public void rotate(double angleDegrees, Point pivot) {
        double rad = Math.toRadians(angleDegrees);
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);
        double dx = x - pivot.x;
        double dy = y - pivot.y;
        this.x = pivot.x + dx * cos - dy * sin;
        this.y = pivot.y + dx * sin + dy * cos;
    }

    public void zoom(double factor, Point pivot) {
        this.x = pivot.x + (x - pivot.x) * factor;
        this.y = pivot.y + (y - pivot.y) * factor;
    }

    // ===== Cài đặt Shape =====

    @Override
    public double area() {
        return 0; 
    }

    @Override
    public double perimeter() {
        return 0;
    }

    @Override
    public Point getCenter() {
        return new Point(this);
    }

    @Override
    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public void rotate(double angleDegrees) {
    }

    @Override
    public void zoom(double factor) {
    }

    @Override
    public String toString() {
        return String.format("Point(%.2f, %.2f)", x, y);
    }
}
