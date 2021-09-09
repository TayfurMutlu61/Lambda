package Lambda01;

import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {

        //1)1 den 20 ye kadar olan sayilari yazdir
        IntStream.rangeClosed(1,20).forEach(MetodLambda2::bosluklaYazdir);
        System.out.println();

        //2) functional programlamayı kullanarak 3 den ile 98 e kadar olan çift tam sayıların toplamını bulun

        System.out.println(IntStream.rangeClosed(3, 98).filter(MetodLambda2::ciftMi).sum());
        System.out.println();
        //3) functional programming kullanarak 9! i bul (9!=1*2*3...*9)
        System.out.println(IntStream.rangeClosed(1, 9).reduce(1, Math::multiplyExact));
        System.out.println();
        //4ilk 7 cift sayisinin carpimini bul(2,4,6,8,10,12,14)

        System.out.println(IntStream.rangeClosed(2,14).filter(MetodLambda2::ciftMi).reduce(1, Math::multiplyExact));
        System.out.println();
        ////6)  6'dan büyük ilk 15 tek sayma sayısının toplamını bulun ==> 7, 9, 11, 13, 15, 17, 19

        System.out.println(IntStream.iterate(7, t -> t + 2).limit(150).sum());
        System.out.println();
        //7) İlk 23 cift sayma sayısının toplamını bulun
        System.out.println(IntStream.iterate(2, t -> t + 2).limit(23).sum());
        System.out.println();
        //5)  (11,33) arasındaki her tam sayının rakamlarının toplamını hesaplamak için bir metod oluşturun
        IntStream.rangeClosed(11,33).map(MetodLambda2::rakamlarToplulugu).forEach(MetodLambda2::bosluklaYazdir);

    }
}
