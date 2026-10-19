import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


interface BaiTap {
    String getName();
    void run();
}

class TienIchNhap {
    private static final Scanner BO_DOC = new Scanner(System.in);

    static String readLine(String loiNhac) {
        System.out.print(loiNhac);
        return BO_DOC.nextLine();
    }

    static int readInt(String loiNhac) {
        while (true) {
            try {
                return Integer.parseInt(readLine(loiNhac).trim());
            } catch (NumberFormatException e) {
                System.out.println("Gia tri khong hop le hoac vuot gioi han int, vui long nhap lai!");
            }
        }
    }

    static int readPositiveInt(String loiNhac) {
        while (true) {
            int giaTri = readInt(loiNhac);
            if (giaTri > 0) {
                return giaTri;
            }
            System.out.println("Gia tri phai lon hon 0!");
        }
    }

    static double readPositiveDouble(String loiNhac) {
        while (true) {
            try {
                double giaTri = Double.parseDouble(readLine(loiNhac).trim());
                if (giaTri > 0 && !Double.isInfinite(giaTri)) {
                    return giaTri;
                }
                System.out.println("Gia tri phai la so duong!");
            } catch (NumberFormatException e) {
                System.out.println("So khong hop le, vui long nhap lai!");
            }
        }
    }

    static int[] readArray(String tenMang) {
        int n = readPositiveInt("Nhap so phan tu cua mang " + tenMang + ": ");
        int[] mang = new int[n];
        for (int i = 0; i < n; i++) {
            mang[i] = readInt(tenMang + "[" + i + "] = ");
        }
        return mang;
    }
}

class BaiTongMang implements BaiTap {
    @Override
    public String getName() {
        return "Tinh tong cac phan tu cua mang";
    }

    @Override
    public void run() {
        int[] mang = TienIchNhap.readArray("a");
        System.out.println("Tong = " + sum(mang));
    }

    static long sum(int[] mang) {
        long tong = 0;
        for (int giaTri : mang) {
            tong += giaTri;
        }
        return tong;
    }
}

class BaiCongHaiMang implements BaiTap {
    @Override
    public String getName() {
        return "Cong hai mang";
    }

    @Override
    public void run() {
        int[] a = TienIchNhap.readArray("a");
        int[] b = TienIchNhap.readArray("b");
        printArray(addArrays(a, b));
    }

    static long[] addArrays(int[] a, int[] b) {
        int n = Math.max(a.length, b.length);
        long[] ketQua = new long[n];
        for (int i = 0; i < n; i++) {
            long x = i < a.length ? a[i] : 0;
            long y = i < b.length ? b[i] : 0;
            ketQua[i] = x + y;
        }
        return ketQua;
    }

    static void printArray(long[] mang) {
        System.out.print("Mang tong: ");
        for (long giaTri : mang) {
            System.out.print(giaTri + " ");
        }
        System.out.println();
    }
}

class BaiTongTuChuoi implements BaiTap {
    @Override
    public String getName() {
        return "Nhap mang bang 1 chuoi, dem so phan tu va tinh tong";
    }

    @Override
    public void run() {
        String dong = TienIchNhap.readLine("Nhap cac so cach nhau boi dau cach: ").trim();

        if (dong.isEmpty()) {
            System.out.println("So phan tu: 0; Tong: 0");
            return;
        }

        String[] cacPhan = dong.split("\\s+");
        long tong = 0;
        try {
            for (String phan : cacPhan) {
                tong += Integer.parseInt(phan);
            }
        } catch (NumberFormatException e) {
            System.out.println("Chuoi nhap co so nguyen khong hop le: " + e.getMessage());
            return;
        }

        System.out.println("So phan tu: " + cacPhan.length + "; Tong: " + tong);
    }
}

interface HinhHoc {
    String getName();
    double perimeter();
    double area();
}

class TamGiac implements HinhHoc {
    private final double canhA, canhB, canhC;

    TamGiac(double canhA, double canhB, double canhC) {
        this.canhA = canhA;
        this.canhB = canhB;
        this.canhC = canhC;
    }

    static boolean isValid(double canhA, double canhB, double canhC) {
        return canhA + canhB > canhC && canhA + canhC > canhB && canhB + canhC > canhA;
    }

    @Override
    public String getName() {
        return "Tam giac";
    }

    @Override
    public double perimeter() {
        return canhA + canhB + canhC;
    }

    @Override
    public double area() {
        double nuaChuVi = perimeter() / 2;
        return Math.sqrt(nuaChuVi * (nuaChuVi - canhA) * (nuaChuVi - canhB) * (nuaChuVi - canhC)); // Heron
    }
}

class HinhChuNhat implements HinhHoc {
    private final double chieuRong, chieuDai;

    HinhChuNhat(double chieuRong, double chieuDai) {
        this.chieuRong = chieuRong;
        this.chieuDai = chieuDai;
    }

    @Override
    public String getName() {
        return "Hinh chu nhat";
    }

    @Override
    public double perimeter() {
        return 2 * (chieuRong + chieuDai);
    }

    @Override
    public double area() {
        return chieuRong * chieuDai;
    }
}

class HinhTron implements HinhHoc {
    private final double banKinh;

    HinhTron(double banKinh) {
        this.banKinh = banKinh;
    }

    @Override
    public String getName() {
        return "Hinh tron";
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * banKinh;
    }

    @Override
    public double area() {
        return Math.PI * banKinh * banKinh;
    }
}

class NhapHinh {
    static HinhHoc readShape() {
        System.out.println("Ban muon nhap hinh gi?");
        System.out.println("1. Tam giac");
        System.out.println("2. Hinh chu nhat");
        System.out.println("3. Hinh tron");

        while (true) {
            int luaChon = TienIchNhap.readInt("Lua chon cua ban: ");
            switch (luaChon) {
                case 1:
                    return readTriangle();
                case 2:
                    return new HinhChuNhat(
                            TienIchNhap.readPositiveDouble("Chieu rong: "),
                            TienIchNhap.readPositiveDouble("Chieu dai: "));
                case 3:
                    return new HinhTron(TienIchNhap.readPositiveDouble("Ban kinh: "));
                default:
                    System.out.println("Lua chon khong hop le, vui long chon 1, 2 hoac 3!");
            }
        }
    }

    private static TamGiac readTriangle() {
        while (true) {
            double canhA = TienIchNhap.readPositiveDouble("Canh a: ");
            double canhB = TienIchNhap.readPositiveDouble("Canh b: ");
            double canhC = TienIchNhap.readPositiveDouble("Canh c: ");
            if (TamGiac.isValid(canhA, canhB, canhC)) {
                return new TamGiac(canhA, canhB, canhC);
            }
            System.out.println("Ba canh nay khong tao thanh tam giac, vui long nhap lai!");
        }
    }

    static void printShape(HinhHoc hinh) {
        System.out.printf("%s -> Chu vi: %.2f, Dien tich: %.2f%n",
                hinh.getName(), hinh.perimeter(), hinh.area());
    }
}

class BaiNhapNhieuHinh implements BaiTap {
    @Override
    public String getName() {
        return "Nhap N hinh";
    }

    @Override
    public void run() {
        int n = TienIchNhap.readPositiveInt("Ban muon nhap bao nhieu hinh? ");
        List<HinhHoc> danhSachHinh = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("\nHinh thu " + i);
            danhSachHinh.add(NhapHinh.readShape());
        }

        System.out.println("\nBan da nhap " + danhSachHinh.size() + " hinh:");
        for (HinhHoc hinh : danhSachHinh) {
            NhapHinh.printShape(hinh);
        }
    }
}

class BaiChonHinh implements BaiTap {
    @Override
    public String getName() {
        return "Chon loai hinh de nhap";
    }

    @Override
    public void run() {
        HinhHoc hinh = NhapHinh.readShape();
        NhapHinh.printShape(hinh);
    }
}

public class Main {
    private static final List<BaiTap> DANH_SACH_BAI_TAP = new ArrayList<>();

    private static void registerExercises() {
        DANH_SACH_BAI_TAP.add(new BaiTongMang());
        DANH_SACH_BAI_TAP.add(new BaiCongHaiMang());
        DANH_SACH_BAI_TAP.add(new BaiTongTuChuoi());
        DANH_SACH_BAI_TAP.add(new BaiNhapNhieuHinh());
        DANH_SACH_BAI_TAP.add(new BaiChonHinh());
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("========== MENU ==========");
        for (int i = 0; i < DANH_SACH_BAI_TAP.size(); i++) {
            System.out.println((i + 1) + ". " + DANH_SACH_BAI_TAP.get(i).getName());
        }
        System.out.println("0. Thoat");
        System.out.println("==========================");
    }

    public static void main(String[] args) {
        registerExercises();

        while (true) {
            printMenu();
            int luaChon = TienIchNhap.readInt("Chon bai tap: ");

            if (luaChon == 0) {
                System.out.println("Tam biet!");
                break;
            }
            if (luaChon < 1 || luaChon > DANH_SACH_BAI_TAP.size()) {
                System.out.println("Lua chon khong hop le, vui long chon lai!");
                continue;
            }

            BaiTap baiTap = DANH_SACH_BAI_TAP.get(luaChon - 1);
            System.out.println("\n--- " + baiTap.getName() + " ---");
            baiTap.run();
        }
    }
}