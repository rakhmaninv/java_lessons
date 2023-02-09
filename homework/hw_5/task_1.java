package hw_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

public class task_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, ArrayList<Integer>> phonebook = new HashMap<>();
        Boolean runFlag = true;
        Integer phoneNumber;
        String name;

        addContact(phonebook, "John", 1111);
        addContact(phonebook, "John", 1112);
        addContact(phonebook, "Mike", 2222);
        addContact(phonebook, "Sarah", 3333);

        System.out.println("1 - add contact\n2 - get number\n3 - exit");
        while (runFlag) {
            System.out.println("Enter command: ");
            switch (sc.nextLine()) {
                case "1":
                    System.out.print("Enter name: ");
                    name = sc.nextLine();
                    System.out.print("Enter phone number: ");
                    phoneNumber = sc.nextInt();

                    addContact(phonebook, name, phoneNumber);
                    break;
                case "2":
                    System.out.print("Enter name: ");
                    name = sc.nextLine();
                    System.out.println(phonebook.get(name));
                    break;
                case "3":
                    runFlag = false;
                    break;
                default:
                System.out.println("Incorrect command");
                    break;
            }
        }
        sc.close();
    }
    
    public static void addContact(Map<String, ArrayList<Integer>> book,
                                String name,
                                Integer phoneNumber) {
        
        if (!book.containsKey(name)){
            book.put(name, new ArrayList<Integer>());
        }
        book.get(name).add(phoneNumber);
    }
}
