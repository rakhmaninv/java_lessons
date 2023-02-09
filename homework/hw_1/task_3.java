package hw_1;

import java.util.Scanner;

//Реализовать простой калькулятор

public class task_3 {
    public static void main(String[] args) {
        boolean flag = true;
        double result = 0;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("введите число A: ");
        double numA = scan.nextDouble();
        System.out.println("введите оператор");
        char operator = scan.next().charAt(0);
        System.out.println("введите число B: ");
        double numB = scan.nextDouble();
        
        switch (operator) {
            case '+':
                result = numA + numB;
                break;
            case '-':
                result = numA - numB;
                break;
            case '*':
                result = numA * numB;
                break;
            case '/':
                if (numB != 0){
                    result = numA / numB;
                    break;
                }
                else {
                    System.out.println("нельзя делить на ноль");
                    flag = false;
                }
        }
        scan.close();
        if(flag) System.out.printf("%f %s %f = %f", numA, operator, numB, result);
    }
}
