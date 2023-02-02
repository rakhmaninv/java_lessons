package hw_4;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

/*Реализуйте очередь с помощью LinkedList со следующими методами:
enqueue() - помещает элемент в конец очереди,
dequeue() - возвращает первый элемент из очереди и удаляет его,
first() - возвращает первый элемент из очереди, не удаляя. */

public class task_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(rnd.nextInt(21));
        }
        Boolean flag = true;
        
        while(flag){
            System.out.println("==================");
            System.out.println(list);
            System.out.println("Choose action:\n1 - add element at the end of the queue\n2 - get and delete first element\n3 - get first element\n4 - exit");
            switch (sc.nextLine()){
                case ("1"):
                    System.out.print("Enter number: ");
                    Integer el = Integer.parseInt(sc.nextLine());
                    list = enqueue(list, el);
                    break;
                case ("2"):
                    if(!list.isEmpty()){
                        System.out.println(dequeue(list));
                        break;
                    }
                    else {
                        System.out.println("Queue is empty");
                        break;
                    }
                case ("3"):
                    System.out.println(first(list));
                    break;
                case ("4"):
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid command");


            }
            
        }
        sc.close();
    }

    public static LinkedList<Integer> enqueue(LinkedList<Integer> list, Integer element) {
        list.add(element);
        return list;
    }

    public static Integer dequeue(LinkedList<Integer> list) {
        return list.removeFirst();
    }

    public static Integer first(LinkedList<Integer> list) {
        return list.getFirst();        
    }
}
