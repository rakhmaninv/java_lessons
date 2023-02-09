package hw_3;

import java.util.ArrayList;
import java.util.Random;

// 3)(Дополнительное) Реализовать алгоритм сортировки слиянием (Дополнительное)

public class task_3 {
    public static void main(String[] args) {
        Random rnd = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        int size = rnd.nextInt(11) + 10; //random from 10 to 20

        for (int i = 0; i < size; i++) {
            list.add(rnd.nextInt(100));
        }
        System.out.println(list);

        System.out.println(mergeSort(list));

    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> list) {
        int length = list.size();
        if(length < 2) return list;

        int middle = length / 2;
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        for (int i = 0; i < middle; i++) {
            leftList.add(list.get(i));
        }
        for (int i = middle; i < length; i++) {
            rightList.add(list.get(i));
        }
        leftList = mergeSort(leftList);
        rightList = mergeSort(rightList);

        return merge(leftList, rightList);
    }
    
    public static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> result = new ArrayList<>();

        while (!left.isEmpty() && !right.isEmpty()){
            if (left.get(0) <= right.get(0)){
                result.add(left.get(0));
                left.remove(0);
            }
            else{
                result.add(right.get(0));
                right.remove(0);
            }
        }
    
        while (!left.isEmpty()){
            result.add(left.get(0));
            left.remove(0);
        }
        while (!right.isEmpty()){
            result.add(right.get(0));
            right.remove(0);
        }
        return result;
    }
}
