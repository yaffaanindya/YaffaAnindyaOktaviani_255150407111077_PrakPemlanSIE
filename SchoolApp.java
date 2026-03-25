public class SchoolApp {
    public static void main(String[] args) {
        Student miki = new Student("Miki");
        Student mini = new Student("Mini");
        Student.setNama(miki, "Kiki");
        System.out.println("Grade " + miki.getNama() + " " + miki.getSkor());
        System.out.println("Grade " + mini.getNama() + " " + miki.getSkor());
        mini.ubahNama("Mono");
        System.out.println("Grade " + miki.getNama() + " " + miki.getSkor());
        System.out.println("Grade " + mini.getNama() + " " + miki.getSkor());
    }
}