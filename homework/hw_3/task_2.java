package hw_3;

import java.util.ArrayList;
import java.util.Random;

// 2) Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее ариф. из этого списка

public class task_2 {
    public static void main(String[] args) {
        Random rnd = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        int sum = 0, number = 0, size = 10, 
            min = Integer.MAX_VALUE, 
            max = Integer.MIN_VALUE;
        double avg = 0.0;

        for (int i = 0; i < size; i++) {
            number = rnd.nextInt(21);
            list.add(number);
            
            sum += number;
            if(number < min) min = number;
            if(number > max) max = number;
        }

        avg = sum /(double) size;

        System.out.println(list);
        System.out.printf("минимальное значение: %d\nмаксимальное значение: %d\nсреднее значение: %.2f", min, max, avg);

    }
}
