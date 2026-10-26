import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
//        HinhTron hinhTron = new HinhTron(1, 1, 3.5);
//        HinhTron hinhtron2 = new HinhTron();
//        System.out.println((hinhTron));
//        System.out.println(hinhtron2);
//
//        System.out.println("dien tich hinh tron 1 la:" + hinhTron.dientich());
//        //cho biet hinh nao co dien tich lon hon
//
//        if (hinhTron.dientich() > hinhtron2.dientich()) {
//            System.out.println("hinh tron 1 co dien tich lon hon");
//        } else if (hinhTron.dientich() < hinhtron2.dientich()) {
//            System.out.println("hinh tron 2 co dien tich lon hon");
//        } else {
//            System.out.println("hai hinh tron co dien tich bang nhau");
//        }
//
//        //nhap vao 1 gia tri d, tịnh tiến hinh tron theo gia tri d
//        try (Scanner scanner = new Scanner(System.in)) {
//            System.out.print("Nhap vao gia tri d: ");
//            double d = scanner.nextDouble();
//            hinhTron.tinhTien(d);
//            System.out.println("Hinh tron sau khi tinh tien: " + hinhTron);
//        }

        //phan so
        PhanSo a = new PhanSo(1, 2);
        PhanSo b = new PhanSo(3, 4);
        System.out.println("a = " + a + ", b = " + b);

        System.out.println("a + b = " + a.cong(b));
        System.out.println("a - b = " + a.tru(b));
        System.out.println("a * b = " + a.nhan(b));
        System.out.println("a / b = " + a.chia(b));

        int ss = a.soSanh(b);
        if (ss > 0) {
            System.out.println("a lon hon b");
        } else if (ss < 0) {
            System.out.println("a nho hon b");
        } else {
            System.out.println("a bang b");
        }

        PhanSo c = new PhanSo(6, -8);
        System.out.print("Rut gon " + c + " = ");
        c.rutGon();
        System.out.println(c);

        //tap hop cac phan so
        PhanSo[] dsPhanSo = {
                new PhanSo(1, 2),
                new PhanSo(4, 2),
                new PhanSo(-3, 4),
                new PhanSo(7, 3),
                new PhanSo(9, 3),
                new PhanSo(5, 6)
        };
        System.out.print("Tap phan so: ");
        for (PhanSo ps : dsPhanSo) {
            System.out.print(ps + "  ");
        }
        System.out.println();

        //tim phan so lon nhat
        PhanSo max = dsPhanSo[0];
        for (PhanSo ps : dsPhanSo) {
            if (ps.soSanh(max) > 0) {
                max = ps;
            }
        }
        System.out.println("Phan so lon nhat: " + max);

        //tinh tong cac phan so
        PhanSo tong = new PhanSo();
        for (PhanSo ps : dsPhanSo) {
            tong = tong.cong(ps);
        }
        System.out.println("Tong cac phan so: " + tong);

        //dem so phan so khong phai so nguyen
        int dem = 0;
        for (PhanSo ps : dsPhanSo) {
            if (ps.getTuSo() % ps.getMauSo() != 0) {
                dem++;
            }
        }
        System.out.println("So phan so khong phai so nguyen: " + dem);

    }
}