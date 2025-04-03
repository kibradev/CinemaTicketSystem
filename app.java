import java.util.Scanner;

public class SinemaKayitSistemi {
    static String[] filmler = new String[10];
    static int[] filmSureleri = new int[10];
    static String[] filmTurleri = new String[10];
    static int filmSayisi = 0;

    static String[] musteriler = new String[20];
    static String[] mailler = new String[20];
    static int musteriSayisi = 0;

    static String[][] biletler = new String[20][2];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int secim;

        do {
            System.out.println("\nSinema Kayit Sistemi");
            System.out.println("1 - Film Ekle");
            System.out.println("2 - Musteri Ekle");
            System.out.println("3 - Bilet Olustur");
            System.out.println("4 - Filmleri Listele");
            System.out.println("5 - Musterileri Listele");
            System.out.println("6 - Biletleri Listele");
            System.out.println("0 - Cikis");
            System.out.print("Secim: ");
            secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    filmEkle(scanner);
                    break;
                case 2:
                    musteriEkle(scanner);
                    break;
                case 3:
                    biletOlustur(scanner);
                    break;
                case 4:
                    filmleriListele();
                    break;
                case 5:
                    musterileriListele();
                    break;
                case 6:
                    biletleriListele();
                    break;
                case 0:
                    System.out.println("Cikis yapildi.");
                    break;
                default:
                    System.out.println("Hatali secim yaptin.");
            }
        } while (secim != 0);
    }

    public static void filmEkle(Scanner scanner) {
        if (filmSayisi >= 10) {
            System.out.println("daha fazla film ekleyemezsin.");
            return;
        }
        System.out.print("Film adi: ");
        filmler[filmSayisi] = scanner.nextLine();
        System.out.print("Suresi: ");
        filmSureleri[filmSayisi] = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Turu: ");
        filmTurleri[filmSayisi] = scanner.nextLine();
        filmSayisi++;
        System.out.println("film eklendi");
    }

    public static void musteriEkle(Scanner scanner) {
        if (musteriSayisi >= 20) {
            System.out.println("zaten 20 kisi eklenmis.");
            return;
        }
        System.out.print("Isim: ");
        musteriler[musteriSayisi] = scanner.nextLine();
        System.out.print("Mail: ");
        mailler[musteriSayisi] = scanner.nextLine();
        musteriSayisi++;
        System.out.println("musteri eklendi.");
    }

    public static void biletOlustur(Scanner scanner) {
        if (musteriSayisi == 0 || filmSayisi == 0) {
            System.out.println("once film ve musteri eklemen lazim.");
            return;
        }

        musterileriListele();
        System.out.print("Musteri no: ");
        int mIndex = scanner.nextInt();
        scanner.nextLine();

        filmleriListele();
        System.out.print("Film no: ");
        int fIndex = scanner.nextInt();
        scanner.nextLine();

        if (mIndex >= 0 && mIndex < musteriSayisi && fIndex >= 0 && fIndex < filmSayisi) {
            biletler[mIndex][0] = musteriler[mIndex];
            biletler[mIndex][1] = filmler[fIndex];
            System.out.println("bilet olusturuldu.");
        } else {
            System.out.println("olmadi, tekrar dene.");
        }
    }

    public static void filmleriListele() {
        System.out.println("\nFilmler:");
        for (int i = 0; i < filmSayisi; i++) {
            System.out.println(i + " - " + filmler[i] + " (" + filmSureleri[i] + " dk, " + filmTurleri[i] + ")");
        }
    }

    public static void musterileriListele() {
        System.out.println("\nMusteriler:");
        for (int i = 0; i < musteriSayisi; i++) {
            System.out.println(i + " - " + musteriler[i] + " | " + mailler[i]);
        }
    }

    public static void biletleriListele() {
        System.out.println("\nBiletler:");
        for (int i = 0; i < musteriSayisi; i++) {
            if (biletler[i][0] != null) {
                System.out.println(biletler[i][0] + " => " + biletler[i][1]);
            }
        }
    }
}
