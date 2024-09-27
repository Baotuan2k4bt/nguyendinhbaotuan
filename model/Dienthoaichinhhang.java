package Test_module2.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Dienthoaichinhhang extends Dienthoai {
    private LocalDate thoiGianBaoHanh;
    private String phamViBaoHanh;

    public Dienthoaichinhhang(int id, String ten, double gia, int soLuong, String nhaSanXuat, LocalDate thoiGianBaoHanh, String phamViBaoHanh) {
        super(String.valueOf(id), ten, gia, soLuong, nhaSanXuat);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.phamViBaoHanh = phamViBaoHanh;
    }

    @Override
    public String getDetails() {
        return super.toString() + ", Thời gian bảo hành: " + thoiGianBaoHanh.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + ", Phạm vi bảo hành: " + phamViBaoHanh;
    }
}

