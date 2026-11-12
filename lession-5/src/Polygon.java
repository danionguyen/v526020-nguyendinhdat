
public abstract class Polygon implements Shape {
    protected Point[] vertices;

    protected Polygon(Point... vertices) {
        this.vertices = new Point[vertices.length];
        for (int i = 0; i < vertices.length; i++) {
            this.vertices[i] = new Point(vertices[i]);
        }
    }

    public abstract String getName();

    public int getVertexCount() {
        return vertices.length;
    }

    public Point getVertex(int i) {
        return new Point(vertices[i]);
    }

    @Override
    public double area() {
        double sum = 0;
        for (int i = 0; i < vertices.length; i++) {
            Point p = vertices[i];
            Point q = vertices[(i + 1) % vertices.length];
            sum += p.getX() * q.getY() - q.getX() * p.getY();
        }
        return Math.abs(sum) / 2;
    }

    @Override
    public double perimeter() {
        double sum = 0;
        for (int i = 0; i < vertices.length; i++) {
            sum += vertices[i].distance(vertices[(i + 1) % vertices.length]);
        }
        return sum;
    }

    @Override
    public Point getCenter() {
        double sx = 0, sy = 0;
        for (Point p : vertices) {
            sx += p.getX();
            sy += p.getY();
        }
        return new Point(sx / vertices.length, sy / vertices.length);
    }

    @Override
    public void move(double dx, double dy) {
        for (Point p : vertices) {
            p.move(dx, dy);
        }
    }

    @Override
    public void rotate(double angleDegrees) {
        Point c = getCenter();
        for (Point p : vertices) {
            p.rotate(angleDegrees, c);
        }
    }

    @Override
    public void zoom(double factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("Hệ số zoom phải > 0");
        }
        Point c = getCenter();
        for (Point p : vertices) {
            p.zoom(factor, c);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getName()).append("[");
        for (int i = 0; i < vertices.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(vertices[i]);
        }
        return sb.append("]").toString();
    }
}
