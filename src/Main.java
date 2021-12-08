import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main {

    static Integer answer;

    public static void main(String[] args) {
        startCalc();
    }

    private static void getMenu(Integer answer) {
        String menu;
        if(answer == null) {
            menu    = "1. Ввести пример. \n"
                    + "2. Недоступно. \n"
                    + "3. Выход.";
        } else {
            menu    = "1. Ввести пример. \n"
                    + "2. Продолжить работать с предыдущем ответом. \n"
                    + "3. Выход.";
        }
        System.out.println(menu);
    }

    private static void getMenu2() {
        String menu = "1. Сложение. \n"
                    + "2. Вычитание. \n"
                    + "3. Умножение. \n"
                    + "4. Деление. \n"
                    + "5. Факториал. \n"
                    + "6. Возведение в степень. \n"
                    + "7. Сравнение. \n"
                    + "0. Назад.";
        System.out.println(menu);
    }

    private static void startCalc() {
        getMenu(answer);

        Scanner scrNumber = new Scanner(System.in);
        int numberMenu = scrNumber.nextInt();

        if (numberMenu == 1) {
            System.out.println(process(solvesExample()));
        } else if(numberMenu == 2){
            if(answer == null){
                startCalc();
            }
            getMenu2();
            numberMenu = scrNumber.nextInt();
            System.out.println(process2(numberMenu));
        } else if(numberMenu == 3) {
            System.exit(0);
        }

        startCalc();
    }

    private static String[] solvesExample() {
        System.out.println("Введите пример.");
        Scanner scr = new Scanner(System.in);
        String str = scr.nextLine();

        return str.split(" ");
    }

    private static String[] solvesExample(String  x, String action) {
        if(action.equalsIgnoreCase("!")) {
            String[] arr1 = {x, action};
            return arr1;
        }

        System.out.println("Введите второе число.");
        Scanner scr = new Scanner(System.in);
        String str = scr.nextLine();
        String[] arr = {x, action, str};

        return arr;
    }

    private static String addition(int x, int y){
        answer = x + y;

        return "\"+\" - " + x + "+" + y + "=" + answer;
    }

    private static String subtraction(int x, int y){
        answer = x - y;
        return "\"-\" - " + x + "-" + y + "=" + answer;
    }

    private static String multiplication(int x, int y){
        answer = x * y;
        return "\"*\" - " + x + "*" + y + "=" + answer;
    }

    private static String division(int x, int y){
        answer = Math.toIntExact(Math.round((double) x / y));
        return "\"/\" - " + x + "/" + y + "=" + ((double) x / y);
    }

    private static String exponentiation(int x, int y){
        answer = (int) Math.pow(x, y);
        return "\"^\" - " + x + "^" + y + "=" + answer;
    }

    private static String comparison(int x, int y){
        answer = Math.max(x, y);
        return x > y ? "\"?\" - " + x + " > " + y : "\"?\" - " + x + " < " + y;
    }

    private static String getFactorial(int x){
        String number = "";
        answer = 1;
        for (int i = x; i >= 1; i--) {
            answer *= i;
            number += i;
            if(i == 1 ){
                continue;
            }
            number += " * ";
        }
        return "\"!\" - " + x +  "! = " + number + " = "+ answer;
    }

    private static String process(String[] text) {
        switch (text[1]){
            case "+":
                return addition(Integer.parseInt(text[0].trim()), Integer.parseInt(text[2].trim()));
            case "-":
                return subtraction(Integer.parseInt(text[0].trim()), Integer.parseInt(text[2].trim()));
            case "*":
                return multiplication(Integer.parseInt(text[0].trim()), Integer.parseInt(text[2].trim()));
            case "/":
                return division(Integer.parseInt(text[0].trim()), Integer.parseInt(text[2].trim()));
            case "!":
                return getFactorial(Integer.parseInt(text[0].trim()));
            case "^":
                return exponentiation(Integer.parseInt(text[0].trim()), Integer.parseInt(text[2].trim()));
            case "?":
                return comparison(Integer.parseInt(text[0].trim()), Integer.parseInt(text[2].trim()));
        }
        return null;
    }

    private static String process2(int numberMenu) {

        switch (numberMenu) {
            case 1:
                return process(solvesExample(answer.toString(), "+"));
            case 2:
                return process(solvesExample(answer.toString(), "-"));
            case 3:
                return process(solvesExample(answer.toString(), "*"));
            case 4:
                return process(solvesExample(answer.toString(), "/"));
            case 5:
                return process(solvesExample(answer.toString(), "!"));
            case 6:
                return process(solvesExample(answer.toString(), "^"));
            case 7:
                return process(solvesExample(answer.toString(), "?"));
            case 0:
                startCalc();
        }
        return null;
    }
}
