package midproject;

import java.util.Scanner;
import java.util.Vector;

public class main {
	Scanner scan = new Scanner(System.in);
	Vector<karyawan> waktu = new Vector<>();
	Vector<karyawan> alphabet = new Vector<>();
	Integer manager = 0;
	Integer supervisor = 0;
	Integer admin = 0;
	Integer flagm = 0;
	Integer flags = 0;
	Integer flaga = 0;
public main() {
		while (true) {
			System.out.println("MENU");
			System.out.println("=========");
			System.out.println("1. insert data karyawan");
			System.out.println("2. view data karyawan");
			System.out.println("3. update data karyawan");
			System.out.println("4. delete data karyawan");
			System.out.print(">> ");
			Integer menu = scan.nextInt();
			scan.nextLine();
			if(menu == 1)
			{
				insert();
			}
			else if(menu == 2)
			{
				view();
				scan.nextLine();
			}
			else if(menu == 3)
			{
				edit();
			}
			else if(menu == 4)
			{
				delete();
			}
		}
	}
	 
	
	public void insert() {
		String kode;
		String nama;
		String gender;
		String jabatan;
		Integer gaji = 0;
		do {
			System.out.print("Input nama karyawan [>= 3]: ");
			nama = scan.nextLine();
		} while (nama.length() < 3);
		do {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			gender = scan.nextLine();
		}while(!(gender.equals("Laki-laki") || gender.equals("Perempuan")));
		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			jabatan = scan.nextLine();
		} while(!(jabatan.equals("Manager") || jabatan.equals("Supervisor") || jabatan.equals("Admin")));
		int alpha1 = (int)(Math.random()*(26-1+1));
		int alpha2 = (int)(Math.random()*(26-1+1));
		int num1 = (int)(Math.random()*(9-0+1));
		int num2 = (int)(Math.random()*(9-0+1));
		int num3 = (int)(Math.random()*(9-0+1));
		int num4 = (int)(Math.random()*(9-0+1));
		kode = String.valueOf((char)(alpha1+65))+String.valueOf((char)(alpha2+65))+"-"+num1+num2+num3+num4;
		if (jabatan.equals("Manager")) {
			gaji = 8000000;
			flagm = 0;
			manager++;
		}
		else if(jabatan.equals("Supervisor")) {
			gaji = 6000000;
			flags = 0;
			supervisor++;
		}
		else if(jabatan.equals("Admin")) {
			gaji = 4000000;
			flaga = 0;
			admin++;
		} 
		alphabet.add(new karyawan(kode, nama, gender, jabatan, gaji));
		waktu.add(new karyawan(kode, nama, gender, jabatan, gaji));
		System.out.println("Berhasil menambahkan karyawan dengan id "+kode);
		int test = 0;
		if((manager-1) % 3 == 0 && manager != 1 && flagm == 0){
			System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id");
			for(int i = 0; i < waktu.size(); i++){
				if(waktu.get(i).getJabatan().equals("Manager")) {
					System.out.print(" "+waktu.get(i).getKode());
					int bonus = (int) (waktu.get(i).getGaji()*1.1);
//					System.out.println(bonus);
					waktu.get(i).setGaji(bonus);
					for(int j = 0; j < alphabet.size(); j++){
						if(alphabet.get(j).getKode().equals(waktu.get(i).getKode()))
						{
							alphabet.get(j).setGaji(bonus);
						}
					}
					test++;
					if(test == manager - 1) {
						System.out.println();
						flagm++;
						break;
					}
//					System.out.println();
				}
			}
			
		}
		else if((supervisor-1) % 3 == 0 && supervisor != 1 && flags == 0){
			System.out.print("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id");
			for(int i = 0; i < waktu.size(); i++){
				if(waktu.get(i).getJabatan().equals("Supervisor")) {
					System.out.print(" "+waktu.get(i).getKode());
					int bonus = (int) (waktu.get(i).getGaji()*1.075);
//					System.out.println(bonus);
					waktu.get(i).setGaji(bonus);
					for(int j = 0; j < alphabet.size(); j++){
						if(alphabet.get(j).getKode().equals(waktu.get(i).getKode()))
						{
							alphabet.get(j).setGaji(bonus);
						}
					}
//					System.out.println();
					test++;
					if(test == supervisor - 1) {
						System.out.println();
						flags++;
						break;
					}
				}
			}
		}
		else if((admin-1) % 3 == 0 && admin != 1 && flaga == 0){
			System.out.print("Bonus sebesar 5% telah diberikan kepada karyawan dengan id");
			for(int i = 0; i < waktu.size(); i++){
				if(waktu.get(i).getJabatan().equals("Admin")) {
					System.out.print(" "+waktu.get(i).getKode());
					int bonus = (int) (waktu.get(i).getGaji()*1.05);
//					System.out.println(bonus);
					waktu.get(i).setGaji(bonus);
					for(int j = 0; j < alphabet.size(); j++){
						if(alphabet.get(j).getKode().equals(waktu.get(i).getKode()))
						{
							alphabet.get(j).setGaji(bonus);
						}
					}
//					System.out.println();
					test++;
					if(test == admin - 1) {
						System.out.println();
						flaga++;
						break;
					}
				}
				
			}
		}
		System.out.print("enter to return");
		scan.nextLine();
	}
	
	public void view(){
		System.out.println("|----|-----------------|--------------------------|------------------|----------|----------|");
		System.out.println("|no  |kode karyawan    |nama karyawan             |jenis kelamin     |jabatan   |gaji      |");
		System.out.println("|----|-----------------|--------------------------|------------------|----------|----------|");
		for (int i = 0; i < alphabet.size(); i++) {
			for (int j = i; j < alphabet.size(); j++) {
				if(alphabet.get(i).getNama().toLowerCase().compareTo(alphabet.get(j).getNama().toLowerCase()) > 0) {
					karyawan temp = alphabet.get(i);
					alphabet.set(i, alphabet.get(j));
					alphabet.set(j, temp);
				}
			}
		}
		for (int i = 0; i < alphabet.size(); i++) {
			System.out.printf("|%4d|%17s|%26s|%18s|%10s|%10d|\n",i+1,alphabet.get(i).getKode(),alphabet.get(i).getNama(),alphabet.get(i).getGender(),alphabet.get(i).getJabatan(),alphabet.get(i).getGaji());
			System.out.println("|----|-----------------|--------------------------|------------------|----------|----------|");
		}
	}
	
	public void delete() {
		view();
		System.out.print("input number want to delete: ");
		Integer x = scan.nextInt();
		waktu.remove(x-1);
		alphabet.remove(x-1);
	}
	
	public void edit() {
		view();
		int angka = 0;
		String kodelama = "";
		String kode;
		String nama;
		String gender;
		String jabatan;
		Integer gaji = 0;
		System.out.print("input angka: ");
		angka = scan.nextInt();
		kodelama = alphabet.get(angka-1).getKode();
		scan.nextLine();
		do {
			System.out.print("Input kode karyawan: ");
			kode = scan.nextLine();
		}while(!(kode.charAt(0) >= 'A' || kode.charAt(0) <= 'Z' && kode.charAt(1) >= 'A' || kode.charAt(1) <= 'Z' && kode.charAt(2) == '-' && kode.charAt(3) >= '0' || kode.charAt(3) <= '9' && kode.charAt(4) >= '0' || kode.charAt(4) <= '9' && kode.charAt(5) >= '0' || kode.charAt(5) <= '9' && kode.charAt(6) >= '0' || kode.charAt(6) <= '9'));
		do {
			System.out.print("Input nama karyawan [>= 3]: ");
			nama = scan.nextLine();
		} while (nama.length() < 3);
		do {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			gender = scan.nextLine();
		}while(!(gender.equals("Laki-laki") || gender.equals("Perempuan")));
		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			jabatan = scan.nextLine();
		} while(!(jabatan.equals("Manager") || jabatan.equals("Supervisor") || jabatan.equals("Admin")));
		do {
			System.out.print("Input gaji: ");
			gaji = scan.nextInt();
		}while(!(gaji > 0));
		alphabet.set(angka-1, new karyawan(kode, nama, gender, jabatan, gaji));
		for(int i = 0; i < waktu.size(); i++){
			if(waktu.get(i).getKode().equals(kodelama)){
				waktu.set(i, new karyawan(kode, nama, gender, jabatan, gaji));
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new main();
	}
}
