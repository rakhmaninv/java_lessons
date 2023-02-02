package hw_4;

import java.util.LinkedList;
import java.util.Random;

//Пусть дан LinkedList с несколькими элементами. Реализуйте метод(не void), который вернет “перевернутый” список.

public class task_1 {
    public static void main(String[] args) {
        Random rnd = new Random();
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(rnd.nextInt(21));
        }
        System.out.println(list);
        System.out.println(reversedList(list));
    }

    public static LinkedList<Integer> reversedList(LinkedList<Integer> original) {
        LinkedList<Integer> reversed = new LinkedList<Integer>();
        for (Integer Item : original) {
            reversed.add(0, Item);
        }
        return reversed;
    }
}
