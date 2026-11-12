public class Main {

    static void printInfo(Shape s) {
        System.out.println("  " + s);
        System.out.printf("    area = %.2f, perimeter = %.2f, center = %s%n",
                s.area(), s.perimeter(), s.getCenter());
    }

    public static void main(String[] args) {
        Shape[] shapes = {
                new Point(1, 2),
                new Circle(new Point(0, 0), 2),
                new Line(new Point(0, 0), new Point(3, 4)),
                new Triangle(new Point(0, 0), new Point(4, 0), new Point(0, 3)),
                new Rectangle(new Point(0, 0), 4, 2)
        };

        System.out.println("===== Ban đầu =====");
        for (Shape s : shapes) printInfo(s);

        System.out.println("\n===== Khoảng cách tâm Circle -> các hình khác =====");
        for (Shape s : shapes) {
            System.out.printf("  -> %-10s: %.2f%n", s.getClass().getSimpleName(), shapes[1].distance(s));
        }

        System.out.println("\n===== move(2, 3) =====");
        for (Shape s : shapes) {
            s.move(2, 3);
            printInfo(s);
        }

        System.out.println("\n===== rotate(90) =====");
        for (Shape s : shapes) {
            s.rotate(90);
            printInfo(s);
        }

        System.out.println("\n===== zoom(2) =====");
        for (Shape s : shapes) {
            s.zoom(2);
            printInfo(s);
        }

        System.out.println("\n===== Getter / setter =====");
        Rectangle r = new Rectangle(new Point(1, 1), 3, 2);
        System.out.println("  " + r + "  w=" + r.getWidth() + ", h=" + r.getHeight());
        r.setWidth(5);
        r.setHeight(4);
        System.out.printf("  sau setWidth(5), setHeight(4): %s%n    area = %.2f, diagonal = %.2f%n",
                r, r.area(), r.diagonal());

        Circle c = new Circle();
        c.setRadius(3);
        System.out.printf("  %s  area = %.2f%n", c, c.area());

        System.out.println("\n===== Kiểm tra dữ liệu không hợp lệ =====");
        try {
            new Triangle(new Point(0, 0), new Point(1, 1), new Point(2, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("  Lỗi: " + e.getMessage());
        }
        try {
            new Circle(new Point(), -1);
        } catch (IllegalArgumentException e) {
            System.out.println("  Lỗi: " + e.getMessage());
        }
    }
}
