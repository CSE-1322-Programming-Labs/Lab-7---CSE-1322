import java.util.InputMismatchException;
import java.util.Scanner;
public class Driver {
    static Calculator calc = new Calculator();

    public static void main(String[] args) {
        while(doOperation()) waitASecond();
    }

    public static void printMenu(){
        System.out.print("0 - Exit\n1 - Addition\n2 - Subtraction\n3 - Multiplication\n4 - Division\nPlease Choose an Option: ");
    }

    public static boolean doOperation() {
        printMenu();
        boolean testPassed = false;
        int whatOperation = -1;

        while (!testPassed) {
            whatOperation = returnUserInteger();
            switch (whatOperation) {
                case 0: return false;
                case 1:
                case 2:
                case 3:
                case 4:
                    testPassed = true;
                    break;
                default:
                    System.out.println("Invalid input.");
                    waitASecond();
                    printMenu();
            }
        }

        System.out.print("Please enter the first number ");
        int firstNum = returnUserInteger();
        System.out.print("Please enter the second number ");
        int secondNum = returnUserInteger();

        switch (whatOperation){
            case 1-> System.out.println(calc.add(firstNum,secondNum));
            case 2-> System.out.println(calc.subtract(firstNum,secondNum));
            case 3-> System.out.println(calc.multiply(firstNum,secondNum));
            case 4-> System.out.println(calc.divide(firstNum,secondNum));
            default-> System.out.println("Invalid input. Please try again.");
        }
        System.out.println();
        return true;
    }

    private static int returnUserInteger(){
        boolean testPassed = false;
        while (!testPassed) {
            Scanner sc = new Scanner(System.in); // This creates more garbage, but it is the easiest way to clear buffer.
            String userInput = sc.next();
            try {
                return Integer.parseInt(userInput);
            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer.");
            } catch (Exception e) {
                System.out.println("Invalid input, please try again.");
            }
        }
        return -1; // something went wrong, and somehow we broke out of the loop. -1 was returned.
    }

    private static void waitASecond(){
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            System.out.println("Thread Failed!");
        }
    }
}
