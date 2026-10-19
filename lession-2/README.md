# Lesson 2 - Bài tập Java

Project là ứng dụng dòng lệnh Java tổng hợp các bài tập về mảng và hình học. Chương trình hiển thị menu để người dùng chọn bài tập, nhập dữ liệu và xem kết quả.

## Chức năng

1. **Tính tổng mảng**: nhập số lượng và các phần tử của mảng số nguyên, sau đó tính tổng.
2. **Cộng hai mảng**: nhập hai mảng và cộng các phần tử cùng vị trí. Nếu hai mảng khác độ dài, các vị trí còn thiếu được xem là `0`.
3. **Đếm phần tử và tính tổng từ chuỗi**: nhập các số nguyên trên một dòng, cách nhau bằng khoảng trắng; chương trình in số lượng và tổng.
4. **Nhập N hình**: nhập nhiều hình tam giác, hình chữ nhật hoặc hình tròn, rồi in chu vi và diện tích của từng hình.
5. **Chọn loại hình để nhập**: nhập một hình thuộc một trong ba loại trên và xem chu vi, diện tích.

Chọn `0` trong menu để thoát. Chương trình kiểm tra dữ liệu số, yêu cầu số lượng và kích thước phải dương, đồng thời kiểm tra điều kiện hợp lệ của tam giác.

## Cấu trúc chính

- `BaiTap`: giao diện chung cho các bài tập, gồm tên bài và thao tác chạy.
- `TienIchNhap`: các hàm nhập và kiểm tra dữ liệu từ bàn phím.
- Các lớp `BaiTongMang`, `BaiCongHaiMang`, `BaiTongTuChuoi`, `BaiNhapNhieuHinh`, `BaiChonHinh`: cài đặt từng mục trong menu.
- `HinhHoc`: giao diện hình học cung cấp tên hình, chu vi và diện tích; được cài đặt bởi `TamGiac`, `HinhChuNhat` và `HinhTron`.
- `NhapHinh`: hỗ trợ chọn, nhập và in thông tin hình.
- `Main`: đăng ký các bài tập, hiển thị menu và điều phối chương trình.

## Chạy chương trình

Cần có JDK để biên dịch và chạy. Từ thư mục `lession-2`, thực hiện:

```bash
javac -d out src/Main.java
java -cp out Main
```
