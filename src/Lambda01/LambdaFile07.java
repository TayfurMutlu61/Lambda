package Lambda01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class LambdaFile07 {
    public static void main(String[] args) {




        //1)functional programming kullanarak bir dosya nasıl okunur

        try {
            Files.lines(Paths.get("C:\\Users\\tayfu\\eclipse-workspace\\TechPro\\C01\\Lambda\\src\\Lambda01\\LambadaFile")).forEach(t->System.out.println(t));
        } catch (IOException e) {
            System.out.println(e);;
        }

        //2)Tüm karakterleri büyük harfe dönüştürün ve okuyun

        try {
            Files.lines(Paths.get("C:\\Users\\tayfu\\eclipse-workspace\\TechPro\\C01\\Lambda\\src\\Lambda01\\LambadaFile")).map(String::toUpperCase).forEach(t->System.out.println(t));
        } catch (IOException e) {
            System.out.println(e);
        }

        //3)metindeki farklı kelimeleri yazdır
        try {
            Files.lines(Paths.get("C:\\Users\\tayfu\\eclipse-workspace\\TechPro\\C01\\Lambda\\src\\Lambda01\\LambadaFile")).map(t->t.split(" ")).
                    flatMap(Arrays::stream).map(t->t.replaceAll("\\W","")).distinct().forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e);
        }

        // 4)metinde "e" içeren tüm kelimeleri yazdırın. (sayısınıda yazdırabilirsin)

        try {
            Files.lines(Paths.get("C:\\Users\\tayfu\\eclipse-workspace\\TechPro\\C01\\Lambda\\src\\Lambda01\\LambadaFile")).
                    map(t->t.split(" ")).flatMap(Arrays::stream).filter(t->t.contains("e")).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e);
        }



    }
}
