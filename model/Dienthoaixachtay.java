package Test_module2.model;

public class Dienthoaixachtay extends Dienthoai {
    private String quocGiaXachTay; // quốc gia xách tay
    private String trangThai; // trạng thái (mới, cũ, refurbished)

    // Constructor
    public Dienthoaixachtay(int id, String tenDienThoai, double giaBan, int soLuong, String nhaSanXuat, String quocGiaXachTay, String trangThai) {
        super(String.valueOf(id), tenDienThoai, giaBan, soLuong, nhaSanXuat);
        this.quocGiaXachTay = quocGiaXachTay;
        this.trangThai = trangThai;
    }

    // Getters và Setters
    public String getQuocGiaXachTay() { return quocGiaXachTay; }
    public String getTrangThai() { return trangThai; }

    public void setQuocGiaXachTay(String quocGiaXachTay) { this.quocGiaXachTay = quocGiaXachTay; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }


    @Override
    public String getDetails() {
        return "";
    }
}
