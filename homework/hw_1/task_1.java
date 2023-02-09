package hw_1;

import java.util.Scanner;


//Вычислить n-ое треугольного число(сумма чисел от 1 до n)
public class task_1 {
    public static void main(String[] args) {
        int n = userIntInput("введите номер треугольного числа: ");
        int triangleNum = (n * (n + 1)) / 2;
        System.out.printf("%d-ое треугольное число: %d", n, triangleNum);
    }

    static int userIntInput(String msg) {
        int number;
        Scanner scan = new Scanner(System.in);
        System.out.print(msg);
        while(!scan.hasNextInt()){
            System.out.print("введите целое число: ");
            scan.next();
        }
        number = scan.nextInt();
        scan.close();
        return number;
    }
}