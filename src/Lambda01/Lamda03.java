package Lambda01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lamda03 {
    public static void main(String[] args) {
        List<Integer> l= new ArrayList<>(Arrays.asList(7,12,14,4,9,2,4,12,16));
        ilkDortElemaman(l);
        System.out.println();
        ilkDortElemamanGec(l);
        ucElemanYazdir(l);



    }




    //1)kucukten buyuge sirala sonra ilk dort elemani yazdir
    public static void ilkDortElemaman(List<Integer> l) {
        l.stream().sorted().limit(4).forEach(MetodLambda2::bosluklaYazdir);
    }
    //2)kucukten buyuge sirala ve ilk dort elemani alma dan digerlerini yazdir
    public static void ilkDortElemamanGec(List<Integer> l) {
        l.stream().sorted().skip(4).forEach(MetodLambda2::bosluklaYazdir);
        System.out.println();

    }
    private static void ucElemanYazdir(List<Integer> l) {
        //kucukten buyuge sirali 4.,5.,6. elemani yazdir
        l.stream().sorted().skip(3).limit(3).forEach(MetodLambda2::bosluklaYazdir);
        System.out.println();
        l.stream().sorted().limit(6).skip(3).forEach(MetodLambda2::bosluklaYazdir);
    }
}
