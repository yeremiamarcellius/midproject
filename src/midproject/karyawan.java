package midproject;

public class karyawan {
	private String kode;
	private String nama;
	private String gender;
	private String jabatan;
	private Integer gaji;
	
	public karyawan(String kode, String nama, String gender, String jabatan, Integer gaji) {
		super();
		this.kode = kode;
		this.nama = nama;
		this.gender = gender;
		this.jabatan = jabatan;
		this.gaji = gaji;
	}
	
	public String getKode() {
		return kode;
	}
	public void setKode(String kode) {
		this.kode = kode;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getJabatan() {
		return jabatan;
	}
	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}
	public Integer getGaji() {
		return gaji;
	}
	public void setGaji(Integer gaji) {
		this.gaji = gaji;
	}
}
