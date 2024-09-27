package Test_module2.model;

public  abstract class Dienthoai {
        public int id;
        protected String ten;
        protected double gia;
        protected int soLuong;
        protected String nhaSanXuat;

    public Dienthoai(String id, String tenDienThoai, double giaBan, int soLuong, String nhaSanXuat) {
    }


    public void DienThoai(int id, String ten, double gia, int soLuong, String nhaSanXuat) {
            this.id = id;
            this.ten = ten;
            this.gia = gia;
            this.soLuong = soLuong;
            this.nhaSanXuat = nhaSanXuat;
        }

        public int getId() {
            return id;
        }

        public abstract String getDetails();

        @Override
        public String toString() {
            return "ID: " + id + ", Tên: " + ten + ", Giá: " + gia + ", Số lượng: " + soLuong + ", Nhà sản xuất: " + nhaSanXuat;
        }
    }

