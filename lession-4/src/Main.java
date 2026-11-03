import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean dangChay = true;

        while (dangChay) {
            System.out.println("\n===== CHON BAI TAP =====");
            System.out.println("1. Bai 1 - Quan ly nhan vien");
            System.out.println("2. Bai 2 - Thao tac voi diem 3D");
            System.out.println("3. Bai 3 - Danh sach diem 2D, 3D");
            System.out.println("4. Bai diem 2D - Khoang cach, doi xung, tinh tien");
            System.out.println("0. Thoat");
            System.out.print("Lua chon: ");

            String luaChon = scanner.nextLine().trim();
            switch (luaChon) {
                case "1":
                    Bai1NhanVien.run(scanner);
                    break;
                case "2":
                    chayBaiDiem3D(scanner);
                    break;
                case "3":
                    chayBaiDanhSachDiem(scanner);
                    break;
                case "4":
                    chayBaiDiem2D(scanner);
                    break;
                case "0":
                    dangChay = false;
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }

        scanner.close();
    }

    private static void chayBaiDiem2D(Scanner scanner) {
        Point2D diemA = nhapDiem2D(scanner, "A");
        Point2D diemB = nhapDiem2D(scanner, "B");

        System.out.println("Khoang cach AB: " + diemA.distance(diemB));
        System.out.println("Diem A doi xung qua goc toa do: " + diemA.symmetricOrigin());

        System.out.println("Nhap do lech de tinh tien diem A:");
        System.out.print("dx: ");
        double dx = Double.parseDouble(scanner.nextLine().trim());
        System.out.print("dy: ");
        double dy = Double.parseDouble(scanner.nextLine().trim());
        diemA.translate(dx, dy);
        System.out.println("Diem A sau khi tinh tien: " + diemA);
    }

    private static Point2D nhapDiem2D(Scanner scanner, String tenDiem) {
        System.out.println("Nhap diem " + tenDiem + ":");
        System.out.print("x: ");
        double x = Double.parseDouble(scanner.nextLine().trim());
        System.out.print("y: ");
        double y = Double.parseDouble(scanner.nextLine().trim());
        return new Point2D(x, y);
    }

    private static void chayBaiDiem3D(Scanner scanner) {
        Point3D diemA = nhapDiem3D(scanner, "A");
        Point3D diemB = nhapDiem3D(scanner, "B");

        System.out.println("Khoang cach AB: " + diemA.distance(diemB));
        System.out.println("Diem A doi xung qua goc toa do: " + diemA.symmetricOrigin());

        System.out.println("Nhap do lech de tinh tien diem A:");
        System.out.print("dx: ");
        double dx = Double.parseDouble(scanner.nextLine().trim());
        System.out.print("dy: ");
        double dy = Double.parseDouble(scanner.nextLine().trim());
        System.out.print("dz: ");
        double dz = Double.parseDouble(scanner.nextLine().trim());
        diemA.translate(dx, dy, dz);
        System.out.println("Diem A sau khi tinh tien: " + diemA);
    }

    private static Point3D nhapDiem3D(Scanner scanner, String tenDiem) {
        System.out.println("Nhap diem " + tenDiem + ":");
        System.out.print("x: ");
        double x = Double.parseDouble(scanner.nextLine().trim());
        System.out.print("y: ");
        double y = Double.parseDouble(scanner.nextLine().trim());
        System.out.print("z: ");
        double z = Double.parseDouble(scanner.nextLine().trim());
        return new Point3D(x, y, z);
    }

    private static void chayBaiDanhSachDiem(Scanner scanner) {
        System.out.print("Nhap so luong diem: ");
        int n = Integer.parseInt(scanner.nextLine().trim());
        if (n < 0) {
            System.out.println("So luong diem khong duoc am.");
            return;
        }

        List<Point2D> danhSachDiem = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("\nDiem thu " + (i + 1) + ":");
            String loaiDiem;
            do {
                System.out.print("Chon loai diem (2 - 2D, 3 - 3D): ");
                loaiDiem = scanner.nextLine().trim();
                if (!"2".equals(loaiDiem) && !"3".equals(loaiDiem)) {
                    System.out.println("Loai diem khong hop le, vui long chon 2 hoac 3.");
                }
            } while (!"2".equals(loaiDiem) && !"3".equals(loaiDiem));

            System.out.print("Nhap x: ");
            double x = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("Nhap y: ");
            double y = Double.parseDouble(scanner.nextLine().trim());

            if ("2".equals(loaiDiem)) {
                danhSachDiem.add(new Point2D(x, y));
            } else {
                System.out.print("Nhap z: ");
                double z = Double.parseDouble(scanner.nextLine().trim());
                danhSachDiem.add(new Point3D(x, y, z));
            }
        }

        double tongKhoangCach2D = 0;
        double tongKhoangCach3D = 0;
        List<Point2D> danhSachDoiXung = new ArrayList<>();
        for (Point2D diem : danhSachDiem) {
            if (diem instanceof Point3D) {
                tongKhoangCach3D += diem.distance();
                danhSachDoiXung.add(diem.symmetricOrigin());
            } else {
                tongKhoangCach2D += diem.distance();
                danhSachDoiXung.add(diem.symmetricOrigin());
            }
        }
        danhSachDiem.addAll(danhSachDoiXung);

        System.out.println("\nTong khoang cach cac diem 2D den goc toa do: " + tongKhoangCach2D);
        System.out.println("Tong khoang cach cac diem 3D den goc toa do: " + tongKhoangCach3D);
        System.out.println("\nDanh sach diem goc va diem doi xung:");
        for (Point2D diem : danhSachDiem) {
            System.out.println(diem);
        }
    }
}
