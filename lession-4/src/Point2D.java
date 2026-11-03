public class Point2D {
    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public double distance() {
       return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    // Khoảng cách giữa 2 điểm
    public double distance(Point2D other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Điểm đối xứng qua gốc tọa độ
    public Point2D symmetricOrigin() {
        return new Point2D(-this.x, -this.y);
    }

    // Tịnh tiến điểm với độ lệch dx, dy
    public void translate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

}
