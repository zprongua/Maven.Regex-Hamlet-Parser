import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;
    Pattern p1 = Pattern.compile("Hamlet");
    Pattern p2 = Pattern.compile("HAMLET");
    Pattern p3 = Pattern.compile("Horatio");
    Pattern p4 = Pattern.compile("HORATIO");

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder();

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                line = changeHamletToLeon(line);
                line = changeHoratioToTariq(line);
                result.append(line).append("\n");
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public int findHoratio(String horatio) {
        Matcher m1 = p3.matcher(horatio);
        Matcher m2 = p4.matcher(horatio);

        if (m1.find()) return 1;
        else if (m2.find()) return 2;
        return -1;
    }

    public int findHamlet(String hamlet) {
        Matcher m1 = p1.matcher(hamlet);
        Matcher m2 = p2.matcher(hamlet);

        if (m1.find()) return 1;
        else if (m2.find()) return 2;
        return -1;
    }

    public String changeHamletToLeon(String input) {
        Matcher m1 = p1.matcher(input);
        Matcher m2 = p2.matcher(input);
        String r1 = "Leon";
        String r2 = "LEON";
        int index = findHamlet(input);
        if (index == 1) return m1.replaceAll(r1);
        else if (index == 2) return m2.replaceAll(r2);
        return input;
    }

    public String changeHoratioToTariq(String input) {
        Matcher m1 = p3.matcher(input);
        Matcher m2 = p4.matcher(input);
        String r1 = "Tariq";
        String r2 = "TARIQ";
        int index = findHoratio(input);
        if (index == 1) return m1.replaceAll(r1);
        else if (index == 2) return m2.replaceAll(r2);
        return input;
    }
}
