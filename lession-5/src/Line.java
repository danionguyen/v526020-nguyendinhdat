public class Line implements Shape {
    private Point start;
    private Point end;

    public Line() {
        this(new Point(0, 0), new Point(1, 0));
    }

    public Line(Point start, Point end) {
        this.start = new Point(start);
        this.end = new Point(end);
    }

    public Point getStart() {
        return new Point(start);
    }

    public void setStart(Point start) {
        this.start = new Point(start);
    }

    public Point getEnd() {
        return new Point(end);
    }

    public void setEnd(Point end) {
        this.end = new Point(end);
    }

    // Độ dài đoạn thẳng
    public double length() {
        return start.distance(end);
    }

    @Override
    public double area() {
        return 0; // đoạn thẳng không có diện tích
    }

    @Override
    public double perimeter() {
        return length();
    }

    @Override
    public Point getCenter() {
        return new Point((start.getX() + end.getX()) / 2, (start.getY() + end.getY()) / 2);
    }

    @Override
    public void move(double dx, double dy) {
        start.move(dx, dy);
        end.move(dx, dy);
    }

    @Override
    public void rotate(double angleDegrees) {
        Point c = getCenter();
        start.rotate(angleDegrees, c);
        end.rotate(angleDegrees, c);
    }

    @Override
    public void zoom(double factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("Hệ số zoom phải > 0");
        }
        Point c = getCenter();
        start.zoom(factor, c);
        end.zoom(factor, c);
    }

    @Override
    public String toString() {
        return String.format("Line[%s -> %s]", start, end);
    }
}
