package homework.hw_3;

import java.util.ArrayList;
import java.util.Random;

// 1) Пусть дан произвольный список целых чисел, удалить из него четные числа

public class task_1 {
    public static void main(String[] args) {
        Random rnd = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add(rnd.nextInt(100));
        }
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) % 2 == 0){
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);
    } 
}
