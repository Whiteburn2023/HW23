import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    private static TreeSet<String> strings = new TreeSet<>();
    private static String regex = "(7|8)?[0-9]{10}";

    public static void main(String[] args) {

        while(true){
            System.out.println("Введите номер: ");
            String input = new Scanner(System.in).nextLine();
            if (input.contains("печать")){
                for (String num: strings){
                    System.out.println(num);
                }
            } else {
            String str = input.replaceAll("\\D", "");
            if (str.startsWith("7")||str.startsWith("8")){
                str = str.substring(1);
            }
            if (strings.contains(str)) {
                System.out.println("Такой номер уже есть в базе");
            } else if (str.matches(regex)) {
                    strings.add(str);
                    System.out.println("Номер успешно добавлен " + str);

            } else {
                    System.out.println("Неверный формат!");
            }
            }
        }
        }
}