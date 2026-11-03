public class Point3D extends Point2D {
    private double z;

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }


    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + this.getX() +
                ", y=" + this.getY() +
                ", z=" + z +
                '}';
    }

    @Override
    public double distance() {
        return Math.sqrt(super.distance() * super.distance() + z * z);
    }

    public double distance(Point3D other) {
        double dx = getX() - other.getX();
        double dy = getY() - other.getY();
        double dz = z - other.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public Point3D symmetricOrigin() {
        return new Point3D(-getX(), -getY(), -z);
    }

    public void translate(double dx, double dy, double dz) {
        super.translate(dx, dy);
        z += dz;
    }
}
