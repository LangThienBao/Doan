package pxu.edu.vn.doan;

import java.util.Scanner;

public class DoAn {

	public static void main(String[] args) {
		int n = 0;
		String[] tensanpham = null;
		String[] donvi = null;
		double[] soluong = null;
		double[] giaban = null;
		double[] thanhtien = null;

		char key = ' ';
		do {
			inMenu();
			Scanner sc = new Scanner(System.in);
			System.out.print("Chọn Chức Năng: ");
			key = sc.next().charAt(0);

			switch (key) {
			case '1':
				n = nhapsoluongdonhang();
				tensanpham = new String[n];
				donvi = new String[n];
				giaban = new double[n];
				soluong = new double[n];
				thanhtien = new double[n];
				nhapthongtin(tensanpham, donvi, giaban, soluong);
				break;
			case '2':
				if (n > 0) {
					thanhtien = sotien(soluong, giaban);
					inDS(tensanpham, donvi, giaban, soluong, thanhtien);
				} else {
					System.out.println("Nhập Thông Tin Trước Khi Thành Tiền.");
				}
				break;
			case '3':
				if (n > 0) {
					inDS(tensanpham, donvi, giaban, soluong, thanhtien);
				} else {
					System.out.println("Nhập Thông Tin Trước Khi In Danh Sách.");
				}
				break;
			case '4':
				if (n > 0) {
					sapxepgiam(tensanpham, donvi, giaban, soluong, thanhtien);
					inDS(tensanpham, donvi, giaban, soluong, thanhtien);
				} else {
					System.out.println("Thành Tiền Trước Khi Sắp Xếp Giảm Dần Theo Thành Tiền.");
				}
				break;
			case '5':
				if (n > 0) {
					sapxeptang(tensanpham, donvi, giaban, soluong, thanhtien);
					inDS(tensanpham, donvi, giaban, soluong, thanhtien);
				} else {
					System.out.println("Nhập Thông Tin Trước Khi Sắp Xếp Tăng Dần Theo Giá Bán.");
				}
				break;
			case '6':
				if (n > 0) {
					timsanpham(tensanpham, donvi, giaban, soluong, thanhtien);
				} else {
					System.out.println("Nhập Thông Tin Trước Khi Tìm Sản Phẩm.");
				}
				break;
			case '7':
				if (n > 0) {
					xoasanpham(tensanpham, donvi, giaban, soluong, thanhtien);
				} else {
					System.out.println("Nhập Thông Tin Trước Khi Xóa Sản Phẩm.");
				}
				break;
			case 'Q':
			case 'q':
				break;
			default:
				System.out.println("Chọn Sai");
				break;
			}
		} while (key != 'Q' && key != 'q');
	}

	public static void inMenu() {
		System.out.println("*******************************");
		System.out.println("(1): Nhập Thông Tin Đơn Hàng");
		System.out.println("(2): Thành Tiền");
		System.out.println("(3): In Danh Sách");
		System.out.println("(4): Sắp Xếp Giảm Dần Theo Thành Tiền");
		System.out.println("(5): Sắp Xếp Tăng Dần Theo Giá Bán");
		System.out.println("(6): Tìm Sản Phẩm");
		System.out.println("(7): Xóa Sản Phẩm");
		System.out.println("(Q/q): Thoát");
		System.out.println("*******************************");
	}

	public static int nhapsoluongdonhang() {
		try {
			int n;
			Scanner sc = new Scanner(System.in);
			do {
				System.out.print("Nhập Số Lượng Đơn Hàng: ");
				n = sc.nextInt();
			} while (n <= 0);
			return n;
		} catch (Exception e) {
			System.out.println("Lỗi");
			return -1;
		}
	}

	public static void nhapthongtin(String[] tensanpham, String[] donvi, double[] soluong, double[] giaban) {
		System.out.println("*************************************************************");
		try {
			for (int i = 0; i < tensanpham.length; i++) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Nhập Đơn Hàng Thứ " + (i + 1));
				System.out.print("Tên Sản Phẩm: ");
				tensanpham[i] = sc.nextLine();
				System.out.print("Đơn Vị: ");
				donvi[i] = sc.nextLine();
				System.out.print("Số Lượng: ");
				soluong[i] = sc.nextDouble();
				System.out.print("Giá Bán: ");
				giaban[i] = sc.nextDouble();
			}
		} catch (Exception e) {
			System.out.println("Lỗi");
		}
		System.out.println("*************************************************************");
	}

	public static double[] sotien(double[] soluong, double[] giaban) {
		double[] thanhtien = new double[soluong.length];
		for (int i = 0; i < thanhtien.length; i++) {
			thanhtien[i] = Math.round((soluong[i] + giaban[i]) * 10.0) / 10.0;
		}
		return thanhtien;
	}

	public static void sapxepgiam(String[] tensanpham, String[] donvi, double[] soluong, double[] giaban,
			double[] thanhtien) {
		for (int i = 0; i < thanhtien.length - 1; i++) {
			for (int j = i + 1; j < thanhtien.length; j++) {
				if (thanhtien[i] < thanhtien[j]) {
					double tam = thanhtien[i];
					thanhtien[i] = thanhtien[j];
					thanhtien[j] = tam;

					tam = soluong[i];
					soluong[i] = soluong[j];
					soluong[j] = tam;

					tam = giaban[i];
					giaban[i] = giaban[j];
					giaban[j] = tam;

					String tam1 = tensanpham[i];
					tensanpham[i] = tensanpham[j];
					tensanpham[j] = tam1;

					tam1 = donvi[i];
					donvi[i] = donvi[j];
					donvi[j] = tam1;
				}
			}
		}
	}

	public static void sapxeptang(String[] tensanpham, String[] donvi, double[] soluong, double[] giaban,
			double[] thanhtien) {
		for (int i = 0; i < giaban.length - 1; i++) {
			for (int j = i + 1; j < giaban.length; j++) {
				if (giaban[i] > giaban[j]) {
					double tam = giaban[j];
					giaban[j] = giaban[i];
					giaban[i] = tam;

					tam = thanhtien[j];
					thanhtien[j] = thanhtien[i];
					thanhtien[i] = tam;

					tam = soluong[j];
					soluong[j] = soluong[i];
					soluong[i] = tam;

					String tam1 = tensanpham[j];
					tensanpham[j] = tensanpham[i];
					tensanpham[i] = tam1;

					tam1 = donvi[j];
					donvi[j] = donvi[i];
					donvi[i] = tam1;
				}
			}
		}
	}

	public static void inDS(String[] tensanpham, String[] donvi, double[] soluong, double[] giaban,
			double[] thanhtien) {
		System.out.println("*************************************************************");
		System.out.println("\t\t\t\t DANH SACH SINH VIEN");
		System.out.printf("%-15s %-15s %-11s %-9s %-15s\n", "Tên sản phẩm |","Đơn vị |", "số lượng |", "Giá bán |", "Thành Tiền");
		for (int i = 0; i < tensanpham.length; i++) {
			System.out.printf("%-15s %-15s %-11s %-9s %-15s\n", tensanpham[i], "|" + donvi[i], "| " + soluong[i], "|" + giaban [i], " | " + thanhtien[i]);
		}
		System.out.println("*************************************************************");
	}
	
	public static void timsanpham(String[] tensanpham, String[] donvi, double[] soluong, double[] giaban,
			double[] thanhtien) {
		int count = 0;
		Scanner sc = new Scanner(System.in);
		String sanphamcantim;
		System.out.print("Sản Phẩm Cần Tìm: ");
		sanphamcantim = sc.nextLine();
		try {
			for (int i = 0; i < tensanpham.length; i++) {
				if (tensanpham[i].equals(sanphamcantim)) {
					System.out.println(tensanpham[i] + ". Đơn Vị: " + donvi[i] + "; Số Lượng: " + soluong[i]
							+ "; Giá Bán: " + giaban[i] + "; Thành Tiền: " + thanhtien[i]);
					count = count + 1;
				} else {
					System.out.println("Sản Phẩm Không Có");
				}
			}
		} catch (Exception e) {
			System.out.println("Lỗi");
		}
	}
	
	public static void xoasanpham(String[] tensanpham, String[] donvi, double[] soluong, double[] giaban,
	        double[] thanhtien) {
	    Scanner sc = new Scanner(System.in);
	    System.out.print("Sản Phẩm Cần Xóa: ");
	    String sanphamcantim = sc.nextLine();

	    int index = -1;
	    for (int i = 0; i < tensanpham.length; i++) {
	        if (tensanpham[i].equals(sanphamcantim)) {
	            index = i;
	            break;
	        }
	    }

	    if (index != -1) {
	        for (int i = index; i < tensanpham.length - 1; i++) {
	            tensanpham[i] = tensanpham[i + 1];
	            donvi[i] = donvi[i + 1];
	            soluong[i] = soluong[i + 1];
	            giaban[i] = giaban[i + 1];
	            thanhtien[i] = thanhtien[i + 1];
	        }
	    }

	    System.out.println("Sản Phẩm Đã Bị Xóa");
	}

}