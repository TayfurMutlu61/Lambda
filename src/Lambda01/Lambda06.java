package Lambda01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda06 {

    public static void main(String[] args) {
        UniversiteLambda6 edebiyatBolum= new UniversiteLambda6("FenEdebiyat","Edebiyat",97,128);
        UniversiteLambda6 iktisatBolum= new UniversiteLambda6("IIBF","iktisat",98,134);
        UniversiteLambda6 matematikBolum= new UniversiteLambda6("FenEdebiyat","Matematik",95,142);
        UniversiteLambda6 ingilizceBolum= new UniversiteLambda6("IngilizDili","ingilizce",93,154);

        List<UniversiteLambda6> uniList= new ArrayList<>(Arrays.asList(edebiyatBolum,iktisatBolum,matematikBolum,ingilizceBolum));

        //1)Tüm ortalama puanların (91)'den büyük olup olmadığını kontrol etmek için bir yöntem oluşturun
        System.out.println(uniList.stream().allMatch(t -> t.getNotOrtalama() > 91));
        System.out.println();
        //2)ders adlarindan en az birinin icinde "matem" kelimesinin icerip icermedigini kontrol etmek icin bir yontem olustuurn
        System.out.println(uniList.stream().anyMatch(t -> t.getBolum().contains("Matem")));
        //3)ortalama puani en yuksek olan kursu yazdirmak icinbir yontem olusturun

        System.out.println(uniList.stream().sorted(Comparator.comparing(UniversiteLambda6::getNotOrtalama).reversed()).findFirst());

        //4not ortalamasina gore artan siralama yapip ilk elemani atla ve list olarak yazdir
        System.out.println(uniList.stream().sorted(Comparator.comparing(UniversiteLambda6::getNotOrtalama)).skip(1).collect(Collectors.toList()));

    }
}
