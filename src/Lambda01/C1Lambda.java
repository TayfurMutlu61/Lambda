package Lambda01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class C1Lambda {
    public static void main(String[] args) {

        List<Integer> l = new ArrayList<>(Arrays.asList(14,9,13,4,9,2,4,14,15));


        yazdirJava(l);
        System.out.println();
        yazdirLambda(l);
        System.out.println();
        ciftSayiJava(l);
        System.out.println();
        ciftSayiLambda(l);
        System.out.println();
        tekSayiKareAlmaLambda(l);
        System.out.println();
        tekrarliSilKupAl(l);
        System.out.println();
        tekrarliSilCiftSayiKareToplami(l);
        System.out.println();
        tekrarsizCiftKupCarpim(l);
        System.out.println();
        listSiralama(l);
    }




    //1)list in elamanlarini yanyana yazdir (java structured ile)
    public static void yazdirJava(List<Integer> l) {
        for (Integer w:l) {
            System.out.print(w+" ");
        }
    }
    //lambda ile (functional)
    public static void yazdirLambda(List<Integer>l){

        l.stream().forEach(t-> System.out.print(t+" "));
    }


    //2)List in elemanlarından ÇİFT olanları aralarında boşluk bırakarak yazdıran metod oluştur(Structured)

    public static void ciftSayiJava(List<Integer> l) {
        for (Integer w :l) {
            if (w%2==0){
                System.out.print(w+" ");
            }
        }
    }

    //lambda(functional) yoluyla

    public static void ciftSayiLambda(List<Integer> l) {
        l.stream().filter(t->t%2==0).forEach(t-> System.out.print(t+" "));
    }

    //3) list deki tek sayilarin karelerini yazdiran metod olusturun
    public static void tekSayiKareAlmaLambda(List<Integer> l) {
        l.stream().filter(t->t%2==1).map(t->t*t).forEach(t-> System.out.print(t+" "));
    }

//4)tekrarli olanlari silip tek sayi olanlarin kuplerini yazdir

     public static void tekrarliSilKupAl(List<Integer> l) {
        l.stream().distinct().filter(t->t%2==1).map(t->t*t*t).forEach(t-> System.out.print(t+" "));
}

//listedeki tekrarli elamanlari silip cift sayi olanlarin karelerinin toplamini

  /*  List<Integer> yeni = new ArrayList<>();
for (Integer w:l) {if (!yeni.contains(w)&&w%2==0)
        yeni.add(w);  //*************
    } int toplam = 0;
for (Integer w:yeni) {
        toplam=toplam+w*w;
    }
System.out.println("uzun yol"+toplam);*/ //javacasi

public static void tekrarliSilCiftSayiKareToplami(List<Integer> l) {
  //  System.out.println(l.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t).reduce(0, (x, y) -> x + y));
 int sayi=   l.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t).reduce(0, (x, y) -> x + y);
    System.out.println(sayi);
}
//6 listedeki tekrarli elemanlari silip cift sayi olanlarin kupunu carpimlarini yazdiran metod
    public static void tekrarsizCiftKupCarpim(List<Integer> l) {
        System.out.println(l.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t * t).reduce(1, (x, y) -> x * y));
    }
    //7 listedeki elemanlari siralayarak ve ters siralayarak yazin
    public static void listSiralama(List<Integer> l) {
    l.stream().sorted().forEach(t-> System.out.print(t+" "));
        System.out.println();
    //tersten (buyukten kucuge dogru)
        l.stream().sorted(Comparator.reverseOrder()).forEach(t-> System.out.print(t+" "));

    }

}
