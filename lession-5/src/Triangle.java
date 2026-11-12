public class Triangle extends Polygon {

    public Triangle() {
        this(new Point(0, 0), new Point(1, 0), new Point(0, 1));
    }

    public Triangle(Point a, Point b, Point c) {
        super(a, b, c);
        checkValid();
    }

    private void checkValid() {
        if (area() < 1e-9) {
            throw new IllegalArgumentException("3 điểm thẳng hàng, không tạo thành tam giác");
        }
    }

    public Point getA() { return getVertex(0); }
    public Point getB() { return getVertex(1); }
    public Point getC() { return getVertex(2); }

    public void setA(Point a) { setVertex(0, a); }
    public void setB(Point b) { setVertex(1, b); }
    public void setC(Point c) { setVertex(2, c); }

    private void setVertex(int i, Point p) {
        Point old = vertices[i];
        vertices[i] = new Point(p);
        try {
            checkValid();
        } catch (IllegalArgumentException e) {
            vertices[i] = old; 
            throw e;
        }
    }

    @Override
    public String getName() {
        return "Triangle";
    }
}
