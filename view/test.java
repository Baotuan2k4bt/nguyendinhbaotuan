package Test_module2.view;
import Test_module2.controler.Managment;
import Test_module2.model.Dienthoai;
import Test_module2.model.Dienthoaichinhhang;
import Test_module2.model.Dienthoaixachtay;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class test {
    public static void main(String[] args) {
        Managment management = new Managment();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("----Menu---\n" +
                    "1. Thêm mới:\n" +
                    "2. xóa :\n" +
                    "3.Xem danh sách  :  \n" +
                    "4.Tìm kiếm  :  \n" +
                    "5.LƯU FILE  :  \n" +
                    "6.THOÁT");
            int n = new Scanner(System.in).nextInt();
            switch (n) {
                case 1:
                    System.out.print("Nhập tên điện thoại: ");
                    String name = scanner.nextLine();
                    double price= 0;
                    boolean validPrice = false;
                    while (!validPrice) {
                        try {
                            System.out.print("Nhập giá: ");
                            price= scanner.nextDouble();
                            if (n< 0) {
                                System.out.println("Giá không thể âm. Vui lòng nhập lại.");
                            } else {
                                validPrice = true;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Giá không hợp lệ. Vui lòng nhập một số.");
                            scanner.nextLine();
                        }
                    }
                    int quantity = 0;
                    boolean validQuantity = false;
                    while (!validQuantity) {
                        try {
                            System.out.print("Nhập số lượng: ");
                            quantity = scanner.nextInt();
                            if (quantity < 0) {
                                System.out.println("Số lượng không thể âm. Vui lòng nhập lại.");
                            } else {
                                validQuantity = true;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Số lượng không hợp lệ. Vui lòng nhập một số nguyên.");
                            scanner.nextLine();
                        }
                    }

                    scanner.nextLine();
                    System.out.print("Nhập nhà sản xuất: ");
                    String manufacturer = scanner.nextLine();

                    int type = 0;
                    boolean validType = false;
                    while (!validType) {
                        System.out.print("Nhập loại (1: Chính hãng, 2: Nhập khẩu): ");
                        type = scanner.nextInt();
                        if (type == 1 || type == 2) {
                            validType = true;
                        } else {
                            System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập 1 hoặc 2.");
                        }
                    }

                    if (type == 1) {
                        LocalDate warrantyDate = null;
                        boolean validDate = false;

                        while (!validDate) {
                            System.out.print("Nhập thời gian bảo hành (ngày, định dạng dd-MM-yyyy): ");
                            String warrantyInput = scanner.nextLine().trim();
                            if (warrantyInput.isEmpty()) {
                                System.out.println("Ngày không được để trống. Vui lòng nhập lại.");
                                continue;
                            }

                            try {
                                warrantyDate = LocalDate.parse(warrantyInput, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                                validDate = true;
                            } catch (DateTimeParseException e) {
                                System.out.println("Định dạng ngày không hợp lệ. Vui lòng nhập lại.");
                            }
                        }

                        System.out.print("Nhập phạm vi bảo hành (Toàn Quốc/Quốc Tế): ");
                        String warrantyScope = scanner.nextLine();
                        Managment.addMobile(new Dienthoaichinhhang(0, name, price, quantity, manufacturer, warrantyDate, warrantyScope));
                    } else if (type == 2) {
                        scanner.nextLine();
                        System.out.print("Nhập quốc gia nhập khẩu: ");
                        String importCountry = scanner.nextLine();
                        System.out.print("Nhập trạng thái: ");
                        String status = scanner.nextLine();
                        Managment.addMobile(new Dienthoaixachtay(0, name, price, quantity, manufacturer, importCountry, status));
                    } else {
                        System.out.println("Lựa chọn không hợp lệ.");
                    }
                    break;
                case 2:
                    System.out.print("Nhập mã ID điện thoại cần xóa: ");
                    int idremove= scanner.nextInt();
                    try {
                        Managment.remove(idremove);
                        System.out.println("Đã xóa điện thoại với ID: " + idremove);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    Managment.display();
                    break;
                case 4:
                    System.out.print("Nhập ID điện thoại cần tìm: ");
                    int idFind = scanner.nextInt();
                    Dienthoai foundMobile = Managment.find(idFind);
                    if (foundMobile != null) {
                        System.out.println("Tìm thấy: " + foundMobile.getId());
                    } else {
                        System.out.println("Không tìm thấy điện thoại với ID " + idFind);
                    }
                    break;
                case 5:
                    String filePath="src/Test_module2/data/data/mobiles.csv ";
                    Managment.save(filePath);
                    System.out.println("Đã lưu file thành công.");
                    break;
                case 6:
                    Managment.Exit();
                    break;
                default:
                    System.out.println("Nhập Sai Số!");
            }
        }

    }
}

