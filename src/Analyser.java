import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Analyser {

    private File file;
    private Scanner sc;

    public Analyser(String path) throws FileNotFoundException {
        this.file = new File(path);
        this.sc = new Scanner(this.file);
    }

    public void printAllLines() throws FileNotFoundException {
        resetScanner();
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }

    public void resetScanner() throws FileNotFoundException {
        this.sc = new Scanner(file);
    }

    public Scanner getSc() {
        return sc;
    }
}
