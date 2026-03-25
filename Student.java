public class Student {
    private String nama;
    private int skor;
    public Student(String nama) {
        this.nama = nama;
    }
    private void setNama(String nama) {
        this.nama = nama;
    }
    public void ubahNama(String namaBaru) {
        setNama(namaBaru);
    }
    public int getSkor() {
        return this.skor;
    }
    public String getNama() {
        return this.nama;
    }
    public static void setNama(Student std, String nama) {
        std.nama = nama;
    }
}