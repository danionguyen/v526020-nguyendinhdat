public class HinhTron {

    private double x;
    private double y;
    private double r;

    public HinhTron() {
        x = 1;
        y = 2;
        r = 10;
    }


    public HinhTron(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
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

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    @Override
    public String toString() {
        return "HinhTron{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                '}';
    }

    double dientich() {
        return Math.PI * r * r;
    }

    void tinhTien(double d) {
        x += d;
        y += d;
    }
}
