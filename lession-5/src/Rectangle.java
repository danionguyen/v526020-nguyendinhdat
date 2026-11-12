
public class Rectangle extends Polygon {

    public Rectangle() {
        this(new Point(0, 0), 1, 1);
    }

    public Rectangle(Point a, double width, double height) {
        super(a,
              new Point(a.getX() + width, a.getY()),
              new Point(a.getX() + width, a.getY() + height),
              new Point(a.getX(), a.getY() + height));
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Chiều rộng và chiều cao phải > 0");
        }
    }

    public double getWidth() {
        return vertices[0].distance(vertices[1]);
    }

    public double getHeight() {
        return vertices[0].distance(vertices[3]);
    }

    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Chiều rộng phải > 0");
        }
        double k = width / getWidth();
        double ux = (vertices[1].getX() - vertices[0].getX()) * k;
        double uy = (vertices[1].getY() - vertices[0].getY()) * k;
        vertices[1] = new Point(vertices[0].getX() + ux, vertices[0].getY() + uy);
        vertices[2] = new Point(vertices[3].getX() + ux, vertices[3].getY() + uy);
    }

    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Chiều cao phải > 0");
        }
        double k = height / getHeight();
        double vx = (vertices[3].getX() - vertices[0].getX()) * k;
        double vy = (vertices[3].getY() - vertices[0].getY()) * k;
        vertices[3] = new Point(vertices[0].getX() + vx, vertices[0].getY() + vy);
        vertices[2] = new Point(vertices[1].getX() + vx, vertices[1].getY() + vy);
    }

    public double diagonal() {
        return vertices[0].distance(vertices[2]);
    }

    @Override
    public double area() {
        return getWidth() * getHeight();
    }

    @Override
    public double perimeter() {
        return 2 * (getWidth() + getHeight());
    }

    @Override
    public String getName() {
        return "Rectangle";
    }
}
