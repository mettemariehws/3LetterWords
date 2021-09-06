import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        FileOutputStream out;

        //læser en fil ind i en stream
        try (Stream<String> stream = Files.lines(Paths.get("src/3LetterWord.csv"), StandardCharsets.ISO_8859_1)){

            //Leger med streamen og derefter sætter det ind i en liste vi har lavet
            list = stream
                    .map(String::toLowerCase)
                    .distinct()
                    .map(s -> s.replaceAll("[{0-9}]", ""))
                    .filter(s -> s.length() > 2)
                    .collect(Collectors.toList());

            //Opretter en ny tom fil
            File newList = new File("src/newFile.txt");
            if(newList.createNewFile()) {
                System.out.println("File create" + newList.getName());
            }else{
                System.out.println("This file is already created");
            }

            /*Læser info ind i den nye tomme fil, du kan også bare lave en ny fil via FileWriter
            /hvis du bare kalder den noget andet end en fil der allerede er der*/
            FileWriter writer = new FileWriter("src/newFile.txt");
            //Her kører vi igennem listen med et for loop og bruger metoden lineseparator til at dele op i forhold til linjeskift
            for(String str: list) {
                writer.write(str + System.lineSeparator());
            }
            writer.close(); //Højst sandsynligt for at stoppe loopet når der ikke er mere tekst


        } catch (IOException e){
            e.printStackTrace();
        }

        list.forEach(System.out::println);
    }
}
