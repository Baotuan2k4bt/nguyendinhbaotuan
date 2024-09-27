package Test_module2.controler;

import Test_module2.model.Dienthoai;
import Test_module2.model.Dienthoaichinhhang;
import Test_module2.model.Dienthoaixachtay;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Managment {
    private static List<Dienthoai> mobiles = new ArrayList<>();
    private static int nextId = 1;
    public static void addMobile(Dienthoai mb) {
        mb.id = nextId++;
        mobiles.add(mb);
    }

    public static void remove(int id) throws Exception {
        for (Dienthoai mobile : mobiles) {
            if (mobile.getId() == id) {
                mobiles.remove(mobile);
                return;
            }
        }
        throw new Exception("Không tìm thấy điện thoại với ID " + id);
    }

    public static Dienthoai find(int id) {
        for (Dienthoai mobile : mobiles) {
            if (mobile.getId() == id) {
                return mobile;
            }
        }

        return null;
    }
    public static void save(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Dienthoai mobile : mobiles) {
                writer.write(mobile.getDetails().replace(", ", ","));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu vào file: " + e.getMessage());
        }
    }

    public void writeTofile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String ten = parts[1];
                double gia = Double.parseDouble(parts[2]);
                int soLuong = Integer.parseInt(parts[3]);
                String nhaSanXuat = parts[4];

                if (parts.length == 7) {
                    LocalDate thoiGianBaoHanh = LocalDate.parse(parts[5], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    String phamViBaoHanh = parts[6];
                    addMobile(new Dienthoaichinhhang(id, ten, gia, soLuong, nhaSanXuat, thoiGianBaoHanh, phamViBaoHanh));
                } else if (parts.length == 6) {
                    String quocGiaNhapKhau = parts[5];
                    String trangThai = parts[6];
                    addMobile(new Dienthoaixachtay ( id, ten, gia, soLuong, nhaSanXuat, quocGiaNhapKhau, trangThai));
                }
                nextId = Math.max(nextId, id + 1);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc từ file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Định dạng dữ liệu không hợp lệ trong file CSV: " + e.getMessage());
        }
    }
    public static void display() {
        if (mobiles.isEmpty()) {
            System.out.println("Danh sách điện thoại trống.");
            return;
        }
        for (Dienthoai mobile : mobiles) {
            System.out.println(mobile.getDetails());
        }
    }
    public static void Exit(){
        System.exit(0);
        System.out.println("Đã thoát chương trình");
    }

    }

