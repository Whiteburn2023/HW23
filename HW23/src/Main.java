import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static final String FORMAT_NUM_REGEX = "(\\d{3})(\\d{3})(\\d{2})(\\d{2})";
    private static TreeSet<String> strings = new TreeSet<>();

    public static void main(String[] args) {

        while(true){
            System.out.println("Введите номер: ");
            String input = new Scanner(System.in).nextLine();
            if (input.equals("печать")){
                print();
            } else {
                checkFormatNumber(input);
            }
        }
        }
    private static void checkFormatNumber(String input) {
        String str = input.replaceAll("\\D", "");
        if (str.length() > 11 || str.length() < 9) {
            System.out.println("Неверный формат!");
            return;
        } else if (str.startsWith("7")||str.startsWith("8")){
            str = str.substring(1);
        }
        //String regex = "(7|8)?[0-9]{10}";
        add(str);

    }
    private static void add(String str){
        if (strings.contains(str)) {
            System.out.println("Такой номер уже есть в базе");
            return;
        }
        strings.add(str);
        System.out.println("Номер успешно добавлен " + str);
    }
    private static void print(){
        if (strings.isEmpty()) {
            System.out.println("Список пуст!");
            return;
        }
        for (String num: strings){
            String formatedNum = num.replaceAll(FORMAT_NUM_REGEX, "+7($1) $2 $3-$4");
            System.out.println(formatedNum);
        }
    }
}