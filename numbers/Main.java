package numbers;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    static boolean isEven, isBuzz, isDuck, isPalindromic;

    public static void main(String[] args) {
        numbers();
    }

    public static void numbers(){
        System.out.println(menuMessage());

        while (true) {
            long input = getNaturalNumber();
            if (input == 0) break;
            System.out.println();
            if (!isNaturalNumber(input)) {System.out.println(errorMessage());}
            else {
                processNumber(input);
                printProperties(input);
            }
            System.out.println();
        }
        byeMessage();
    }

    private static void byeMessage() {
        System.out.println();
        System.out.println("Goodbye!");
    }

    private static void printProperties(long input) {
        System.out.printf("Properties of %d%n", input);
        System.out.printf("%12s: %b%n", "even", isEven);
        System.out.printf("%12s: %b%n", "odd", !isEven);
        System.out.printf("%12s: %b%n", "buzz", isBuzz);
        System.out.printf("%12s: %b%n", "duck", isDuck);
        System.out.printf("%12s: %b%n", "palindromic", isPalindromic);
    }

    private static String menuMessage(){
        String str = "Welcome to Amazing Numbers!\n";
        str += "\n";
        str += "Supported requests:\n";
        str += "- enter a natural number to know its properties;\n";
        str += "- enter 0 to exit.\n";

        return str;
    }

    private static String errorMessage(){
        return "The first parameter should be a natural number or zero.";
    }

    private static void processNumber(long number){
        setIsDuck(number);
        setBuzzNumber(number);
        setEven(number);
        setIsPalindromic(number);
    }

    public static void setIsPalindromic(long number) {
        String value = String.valueOf(number);

        int start = 0;
        int end = value.length() - 1;

        while (start < end) {
            if (Objects.equals(value.charAt(start),value.charAt(end)) == false) {isPalindromic = false; return;}
            start++;
            end--;
        }
        isPalindromic = true;
    }

    private static void setIsDuck(long number){
        while (number > 0){
            long tempValue = number%10;
            number /= 10;
            if (tempValue == 0) {isDuck = true; break;}
            else isDuck = false;

        }
    }

    private static void setEven(long number){
        if ( (number & 1) == 0) isEven = true;
        else isEven = false;
    }

    private static void setBuzzNumber(long number){
        if (number%10 == 7 || number%7 == 0) isBuzz = true;
        else isBuzz = false;
    }

    private static boolean isNaturalNumber(long number){
        return (number > 0 && number == Math.floor(number));
    }

    private static long getNaturalNumber(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a request: ");
        return sc.nextLong();
    }
}
