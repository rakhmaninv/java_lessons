package homework.hw_2;

import java.util.Scanner;

// Напишите метод, который принимает на вход строку (String) и определяет является ли строка палиндромом (возвращает boolean значение).
public class task_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("введите слово: ");
        String str = sc.nextLine();
        sc.close();
        if(palindromCheck(str)) System.out.printf("%s - палиндром", str);
        else System.out.printf("%s - не палиндром", str);

    }

    public static Boolean palindromCheck(String str) {
        String rev = new StringBuilder(str).reverse().toString();
        return str.equalsIgnoreCase(rev);
    }
    
}
