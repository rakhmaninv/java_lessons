package hw_1;

//Вывести все простые числа от 1 до 1000

public class task_2 {
    public static void main(String[] args) {
        for (int num = 2; num <= 1000; num++) {
            Boolean prime = true;
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0){
                    prime = false;
                    break;
                }
            }
            if (prime == true) System.out.printf("%d ", num);
        }
    }
}