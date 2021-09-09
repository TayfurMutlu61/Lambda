package Lambda01;

import java.util.*;

public class Lambda04 {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>(Arrays.asList("Ali", "Ali", "Aysima", "Abdurrahman", "Mehmet", "Mustafa", "Bedirhan", "Yüksel", "Süleyman", "veli"));


        yazdirBuyuk1(l);
        System.out.println();
        uzunlukSirala(l);
        System.out.println();
        farkliSonHarfSirala(l);
        System.out.println();
        uzunlukVeIlkHarf(l);
        System.out.println();
        birHarfIleBaslayan(l);
        System.out.println();
        ABaslaVeyaIbiten(l);
        System.out.println();
        siralaBuyut(l);
        System.out.println();
        siralaYaninaHarfSayisiniYazdir(l);
        System.out.println();
        karesiniAlSiralaSil(l);
        System.out.println();
        ebikGabik(l);
        System.out.println();
        sondanIkinciSiralaIlk(l);
        System.out.println();
        terstenSiralaIlkYazdir(l);


    }


    //1)listin elemanlarini  buyuk harfle yazdir
    public static void yazdirBuyuk1(List<String> l) {
        l.stream().map(t -> t.toUpperCase()).forEach(MetodLambda2::bosluklaYazdir);
        System.out.println();
        l.stream().map(String::toUpperCase).forEach(MetodLambda2::bosluklaYazdir);
        //iki yontem de buyuk harfle yazdirir,ikiside kullanilabilir

    }

    //2)isimlerin lenght ine gore sirala
    public static void uzunlukSirala(List<String> l) {
        l.stream().sorted(Comparator.comparing(String::length)).forEach(MetodLambda2::bosluklaYazdir);//kisadan uzuna

        System.out.println();
        l.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(MetodLambda2::bosluklaYazdir);//uzundan kisaya
    }

    //3)farkli elemanlarini son harflerine gore sirala
    public static void farkliSonHarfSirala(List<String> l) {
        l.stream().distinct().sorted(Comparator.comparing(t -> t.substring(t.length() - 1))).forEach(MetodLambda2::bosluklaYazdir);

    }

    //4) Elemanları uzunluklarına ve ardından (aynı uzunlukta olanları) ilk karakterlerine göre sıralamak için bir yöntem oluşturun
    public static void uzunlukVeIlkHarf(List<String> l) {
        l.stream().sorted(Comparator.comparing(String::length).thenComparing(t -> t.substring(0, 1))).forEach(MetodLambda2::bosluklaYazdir);
        System.out.println();
        l.stream().sorted(Comparator.comparing(String::length).thenComparing(t -> t.charAt(0)).thenComparing(t -> t.charAt(1))).forEach(MetodLambda2::bosluklaYazdir);
        //bu sekilde hem charat ile hemde subsitring ile yapilabilir
    }

    //5)Büyük harflerle, "A" ile başlayan liste öğelerini yazdırmak için bir yöntem oluşturun
    public static void birHarfIleBaslayan(List<String> l) {
        l.stream().filter(t -> t.startsWith("A")).map(String::toUpperCase).forEach(MetodLambda2::bosluklaYazdir);//ALİ ALİ AYSİMA ABDURRAHMAN

    }
    //6)  Küçük harflerle, "a" ile başlayan veya "i" ile biten liste öğelerini yazdırmak için bir yöntem oluşturun

    public static void ABaslaVeyaIbiten(List<String> l) {
        l.stream().filter(t -> t.startsWith("A") || t.endsWith("i")).forEach(MetodLambda2::bosluklaYazdir);
    }

    //7) Öğeleri uzunluklarına göre sıraladıktan sonra büyük harflerle yazdırmak için bir yöntem oluşturun
    public static void siralaBuyut(List<String> l) {
        l.stream().sorted(Comparator.comparing(String::length)).map(String::toUpperCase).forEach(MetodLambda2::bosluklaYazdir);
        //ALİ ALİ VELİ AYSİMA MEHMET YÜKSEL MUSTAFA BEDİRHAN SÜLEYMAN ABDURRAHMAN
    }
//8) Elemanları uzunluklarına göre sıralayın önce elemanı sonra uzunluğunu yazdırın

    public static void siralaYaninaHarfSayisiniYazdir(List<String> l) {
        l.stream().sorted(Comparator.comparing(String::length)).map(t -> t + ":" + t.length()).forEach(MetodLambda2::bosluklaYazdir);
    }

    //9) Her elemanın uzunluğunun karesini alıp tekrarlıları sil, bunların 20'den büyük olanlarını ters sırada  yazdırın
    public static void karesiniAlSiralaSil(List<String> l) {
        l.stream().map(t -> t.length() * t.length()).distinct().filter(t -> t > 20).sorted(Comparator.reverseOrder()).forEach(MetodLambda2::bosluklaYazdir);
        //121 64 64 49 36 36 36
    }

    // /10) Tüm elemanların uzunluklarının 12'den az olup olmadığını kontrol etmek için bir metod oluşturun
//bütün elemanların "x" ile başlamadığını kontrol etmek için bir yöntem oluşturun
//en az 1 tane "R" ile biten eleman olup olmadığını kontrol etmek için bir metod oluşturun.
    public static void ebikGabik(List<String> l) {
        boolean result1 = l.stream().allMatch(t -> t.length() < 12);
        System.out.println("elemanlarin uzunluklari 12 den kucuk mu? : " + result1);
        System.out.println();
        boolean result2 = l.stream().noneMatch(t -> t.startsWith("X"));
        System.out.println("x ile baslayan eleman yok mu ? : " + result2);
        System.out.println();
        boolean result3 = l.stream().anyMatch(t -> t.endsWith("R"));
        System.out.println("elemanlardan herhangi biri R ile bitiyor mu+ : " + result3);
    }

    // elemanları sondan 2. elemanlarına göre sıralayıp ilk elemanı yazdır
    public static void sondanIkinciSiralaIlk(List<String> l) {
        System.out.println(l.stream().sorted(Comparator.comparing(t -> t.charAt(t.length() - 2))).findFirst());
    }

    //elemanlari uzunluklari gore tersten sirala ilk elemani yazdir
    public static void terstenSiralaIlkYazdir(List<String> l) {
        System.out.println(l.stream().sorted(Comparator.comparing(String::length).reversed()).findFirst());
        System.out.println();
        // Eleman 'A', 'a' ile başlıyor veya 'N', 'n' ile bitiyorsa o elemanı silin
        l.removeIf(t -> t.toUpperCase().startsWith("A") || t.toUpperCase().endsWith("N"));
        System.out.println(l);//[Mehmet, Mustafa, Yüksel, veli]
    }

}
