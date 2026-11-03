import java.util.Arrays;
import java.util.Scanner;

public class Bai1NhanVien {
    public static void main(String[] args) {
        run(new Scanner(System.in));
    }

    public static void run(Scanner scanner) {
        System.out.print("Nhap so luong nhan vien: ");
        int n = Integer.parseInt(scanner.nextLine().trim());

        if (n <= 0) {
            System.out.println("So luong nhan vien phai lon hon 0.");
            return;
        }

        NhanVien[] danhSachNhanVien = new NhanVien[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap thong tin nhan vien thu " + (i + 1) + ":");
            danhSachNhanVien[i] = new NhanVien();
            danhSachNhanVien[i].nhap(scanner);
        }

        NhanVien nhanVienLonNhat = danhSachNhanVien[0];
        for (int i = 1; i < danhSachNhanVien.length; i++) {
            if (danhSachNhanVien[i].getSoNamCongTac() > nhanVienLonNhat.getSoNamCongTac()) {
                nhanVienLonNhat = danhSachNhanVien[i];
            }
        }

        Arrays.sort(danhSachNhanVien, (a, b) -> Double.compare(b.tinhLuong(), a.tinhLuong()));

        System.out.println("\nNhan vien co so nam cong tac nhieu nhat:");
        nhanVienLonNhat.xuat();

        System.out.println("\nDanh sach nhan vien theo thu tu luong giam dan:");
        for (NhanVien nhanVien : danhSachNhanVien) {
            nhanVien.xuat();
        }
    }
}
