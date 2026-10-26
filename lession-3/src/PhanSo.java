//Mỗi phân số P được định nghĩa bằng 2 thành phần là tử số T và mẫu
//số M và được biểu diễn P = T/M trong đó tử số và mẫu số là các giá
//trị nguyên. Hãy xây dựng lớp phân số.
//        ◼ Định nghĩa các thuộc tính của lớp phân số.
//◼ Xây dựng các hàm tạo: mặc định, có đối.
//◼ Xây dựng các hàm getters, setters và hàm toString.
//        ◼ Xây dựng hàm riêng:
//        ◼ Tính tổng, hiệu, tích và thương của 2 phân số.
//        ◼ So sánh 2 phân số.
//        ◼ Rút gọn phân số.

public class PhanSo {

    private int tuSo;
    private int mauSo;

    public PhanSo() {
        tuSo = 0;
        mauSo = 1;
    }

    public PhanSo(int tuSo, int mauSo) {
        this.tuSo = tuSo;
        setMauSo(mauSo);
    }

    public int getTuSo() {
        return tuSo;
    }

    public void setTuSo(int tuSo) {
        this.tuSo = tuSo;
    }

    public int getMauSo() {
        return mauSo;
    }

    public void setMauSo(int mauSo) {
        if (mauSo == 0) {
            throw new IllegalArgumentException("Mau so phai khac 0");
        }
        this.mauSo = mauSo;
    }

    @Override
    public String toString() {
        return tuSo + "/" + mauSo;
    }

    // uoc chung lon nhat, dung de rut gon
    private static int ucln(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    // rut gon phan so, dua dau am len tu so
    void rutGon() {
        int u = ucln(tuSo, mauSo);
        tuSo /= u;
        mauSo /= u;
        if (mauSo < 0) {
            tuSo = -tuSo;
            mauSo = -mauSo;
        }
    }

    PhanSo cong(PhanSo other) {
        PhanSo kq = new PhanSo(tuSo * other.mauSo + other.tuSo * mauSo, mauSo * other.mauSo);
        kq.rutGon();
        return kq;
    }

    PhanSo tru(PhanSo other) {
        PhanSo kq = new PhanSo(tuSo * other.mauSo - other.tuSo * mauSo, mauSo * other.mauSo);
        kq.rutGon();
        return kq;
    }

    PhanSo nhan(PhanSo other) {
        PhanSo kq = new PhanSo(tuSo * other.tuSo, mauSo * other.mauSo);
        kq.rutGon();
        return kq;
    }

    PhanSo chia(PhanSo other) {
        if (other.tuSo == 0) {
            throw new ArithmeticException("Khong the chia cho phan so bang 0");
        }
        PhanSo kq = new PhanSo(tuSo * other.mauSo, mauSo * other.tuSo);
        kq.rutGon();
        return kq;
    }

    // tra ve so am neu this < other, 0 neu bang nhau, so duong neu this > other
    int soSanh(PhanSo other) {
        // nhan cheo; doi dau neu tich hai mau so am
        long trai = (long) tuSo * other.mauSo;
        long phai = (long) other.tuSo * mauSo;
        int kq = Long.compare(trai, phai);
        return (mauSo < 0) != (other.mauSo < 0) ? -kq : kq;
    }
}
