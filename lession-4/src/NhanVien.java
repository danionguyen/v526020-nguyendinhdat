import java.util.Scanner;

public class NhanVien extends Nguoi {
    private int soNamCongTac;
    private double hsl;
    private static final double LCB = 1500000;
    private static final double PHU_CAP_MOI_NAM = 200000;

    public NhanVien() {
        super();
    }

    public NhanVien(String hoTen, int tuoi, int soNamCongTac, double hsl) {
        super(hoTen, tuoi);
        this.soNamCongTac = soNamCongTac;
        this.hsl = hsl;
    }

    public int getSoNamCongTac() {
        return soNamCongTac;
    }

    public void setSoNamCongTac(int soNamCongTac) {
        this.soNamCongTac = soNamCongTac;
    }

    public double getHsl() {
        return hsl;
    }

    public void setHsl(double hsl) {
        this.hsl = hsl;
    }

    @Override
    public void nhap(Scanner scanner) {
        super.nhap(scanner);
        System.out.print("Nhap so nam cong tac: ");
        this.soNamCongTac = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhap he so luong: ");
        this.hsl = Double.parseDouble(scanner.nextLine());
    }

    public double tinhLuong() {
        double phuCap = PHU_CAP_MOI_NAM * soNamCongTac;
        return LCB * hsl + phuCap;
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("So nam cong tac: " + soNamCongTac
                + ", he so luong: " + hsl
                + ", luong: " + String.format("%.0f", tinhLuong()));
    }
}
