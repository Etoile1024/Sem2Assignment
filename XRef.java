import java.util.*;
import java.io.*;

public class XRef {
    private static final String
            DELIMITER = "\"(?:\\\\\"|[^\"])*?\"|[\\s.,;:+*/|!=><@?#%&(){}\\-\\^\\[\\]\\&&]+";

    private static LinkedList identifiers = new LinkedList(new StringComparator());

    public static String[] tokenizer(String javaStmt) {
        String[] tokens = javaStmt.split(DELIMITER);
        return tokens;
    }

    public static void InitIdentifiers() {
        identifiers.addToTail("abstract");
        identifiers.addToTail("continue");
        identifiers.addToTail("for");
        identifiers.addToTail("new");
        identifiers.addToTail("switch");
        identifiers.addToTail("assert");
        identifiers.addToTail("default");
        identifiers.addToTail("goto");
        identifiers.addToTail("package");
        identifiers.addToTail("synchronized");
        identifiers.addToTail("boolean");
        identifiers.addToTail("do");
        identifiers.addToTail("if");
        identifiers.addToTail("private");
        identifiers.addToTail("this");
        identifiers.addToTail("break");
        identifiers.addToTail("double");
        identifiers.addToTail("implements");
        identifiers.addToTail("protected");
        identifiers.addToTail("throw");
        identifiers.addToTail("byte");
        identifiers.addToTail("else");
        identifiers.addToTail("import");
        identifiers.addToTail("public");
        identifiers.addToTail("throws");
        identifiers.addToTail("case");
        identifiers.addToTail("enum");
        identifiers.addToTail("instanceof");
        identifiers.addToTail("return");
        identifiers.addToTail("transient");
        identifiers.addToTail("catch");
        identifiers.addToTail("extends");
        identifiers.addToTail("int");
        identifiers.addToTail("short");
        identifiers.addToTail("try");
        identifiers.addToTail("char");
        identifiers.addToTail("final");
        identifiers.addToTail("interface");
        identifiers.addToTail("static");
        identifiers.addToTail("void");
        identifiers.addToTail("class");
        identifiers.addToTail("finally");
        identifiers.addToTail("long");
        identifiers.addToTail("strictfp");
        identifiers.addToTail("volatile");
        identifiers.addToTail("const");
        identifiers.addToTail("float");
        identifiers.addToTail("native");
        identifiers.addToTail("super");
        identifiers.addToTail("while");
    }

    public static boolean checkWordCanUse(String word) {
        if(word.isEmpty() || word.isBlank())
            return false;
        if(identifiers.exist(word))
            return false;
        char firstChar = word.charAt(0);
        if( (firstChar < 'A' || firstChar > 'Z') && (firstChar < 'a' || firstChar > 'z') && firstChar != '$' && firstChar != '_' ) //Check the first character is violated the rule or not
            return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println("X R e f  v 1");
        System.out.println("============================================");
        System.out.println();
        String path = null;
        try {
            path = args[0];
            Scanner scanner = new Scanner(new File(path));
            LinkedList list = new LinkedList(new TokenDataComparator());
            InitIdentifiers();
            System.out.println("SOURCE FILE: " + path);
            int lineNum = 1;
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(String.format("%04d | %s", lineNum, line));
                for(String t : tokenizer(line)) {
                    if(checkWordCanUse(t))
                        list.insertToken(new TokenData(t, lineNum));
                }
                lineNum++;
            }
            System.out.println();
            System.out.println("CROSS REFERENCE:");
            list.println();
            System.out.println("XRef v1 normally terminated.");
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Error: No path provided!");
        }
        catch (FileNotFoundException ex) {
            System.out.println("Error: Can't find file " + path);
        }
        catch (Exception ex) {
            System.out.println("Error: Unexpected error");
            System.out.println(ex.toString());
        }
    }
}
