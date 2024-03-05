import utils.LinkedList;
import utils.Node;

import java.util.regex.Pattern;

import static problems.ReverseLinkedList.reverseFirstKGrpNodes;

public class Main {
    public static void main(String[] args) {
        boolean validFileName = isValidFileName("test.txt");
        System.out.printf("validFileName --> "+validFileName);

    }
    public static boolean isValidFileName(String fileName) {
        String regex = "[\\\\/:*?\"<>|]";
        String reserveNames = "^(con|prn|aux|nul|com[1-9]|lpt[1-9])$";

        return !(fileName == null || fileName.trim().isEmpty()) && !Pattern.compile(regex).matcher(fileName).find()
                && !fileName.matches(reserveNames) && fileName.chars().filter(ch -> ch == 46).count() <= 1L;
    }

}

