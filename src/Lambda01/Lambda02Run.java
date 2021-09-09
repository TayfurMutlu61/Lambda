package Lambda01;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda02Run {

    public static void main(String[] args) {
        // Method Reference'da bizim oluşturduğumuz metodları  veya Java metodlarını kullanırız.
        //Method Reference Syntax ı ==> ClassName::MethodName  System.out.println();  ==  System.out::println;

        List<Integer> l = new ArrayList<>(Arrays.asList(14,9,13,4,9,2,4,14,15,6));

        elemanYazdir(l);
        System.out.println();
        ciftSayiYazdir(l);
        System.out.println();
        tekSayiKare(l);
        System.out.println();
        tekrarliSilTekKup(l);
        System.out.println();
        farkliCiftSayiKareTolami(l);
        System.out.println();
        farkliCiftKupCarpim(l);
        System.out.println();
        System.out.println(farkliTersSiralama(l));
        System.out.println();
        maxDeger(l);
    }




    //list in elemanlarini aralarinda bosluk birakarak yanyana yazdir
    public static void elemanYazdir(List<Integer> l) {
        l.stream().forEach(MetodLambda2::bosluklaYazdir);//kendi metodumuz
        l.stream().forEach(System.out::print);//javanin metodu
    }
    //2)list in elemanlarindan cift olanlari aralarinda bosluk birakarak yanyana yazdir
    public static void ciftSayiYazdir(List<Integer> l) {
        l.stream().filter(MetodLambda2::ciftMi).forEach(MetodLambda2::bosluklaYazdir);
    }

    //3)listeki tek sayilarin karelerini alip xaralarinda bosluk birakarak yanyana yazdir
    public static void tekSayiKare(List<Integer> l) {
        l.stream().filter(MetodLambda2::tekMi).map(MetodLambda2::kareAl).forEach(MetodLambda2::bosluklaYazdir);
    }
    //4)listeki tekrarli olanlari silip öisteki tek sayilarin kuplerini alip yazdir
    public static void tekrarliSilTekKup(List<Integer> l) {
        l.stream().distinct().filter(MetodLambda2::tekMi).map(MetodLambda2::kupAl).forEach(MetodLambda2::bosluklaYazdir);
    }
    //5)farkli ciftb sayilarin kareleri toplami
    public static void farkliCiftSayiKareTolami(List<Integer> l) {
      int num=  l.stream().distinct().filter(MetodLambda2::ciftMi).map(MetodLambda2::kareAl).reduce(0,Math::addExact);
        System.out.println(num);
    }
    //6)farkli cift sayilarin kuplerinin carpimini yazdir
    public static void farkliCiftKupCarpim(List<Integer> l) {
      int num1=  l.stream().distinct().filter(MetodLambda2::ciftMi).map(MetodLambda2::kupAl).reduce(1,Math::multiplyExact);
        System.out.println(num1);
    }
    //7)List teki farklı ve 5 ten büyük elemanlarının yarısını alıp ters sıralayarak list olarak yazdır.(Use Me)
    public static List farkliTersSiralama(List<Integer> l) {
     return   l.stream().distinct().filter(t->t>5 && t%2==0).map(t->t/2 ).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

//8)List teki en büyük elemanı bul.(Use Method Reference)
public static void maxDeger(List<Integer> l) {

    System.out.println(l.stream().reduce(Integer.MIN_VALUE, Math::max));
  int num3=  l.stream().reduce(Integer.MAX_VALUE,Math::min);
    System.out.println(num3);


    l.stream().sorted(Comparator.reverseOrder()).limit(1).forEach(MetodLambda2::bosluklaYazdir);//max
    System.out.println();
    l.stream().sorted().limit(1).forEach(MetodLambda2::bosluklaYazdir);//min
}


}
