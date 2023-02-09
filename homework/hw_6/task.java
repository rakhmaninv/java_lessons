package hw_6;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map.

Например: “Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет

Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.

Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

Класс сделать в отдельном файле*/
public class task {
    public static void main(String[] args) {
        Set<Laptop> laptops = fillLaptopSet();
        
        
    }



    public static Integer chooseCategory() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - Производитель ЦП");
        System.out.println("2 - Оперативная память");
        System.out.println("3 - Емкость хранилища данных");
        System.out.println("4 - Операционная система");
        System.out.println("5 - Наличие видеокарты");
        while (true){
            System.out.print("Введите номер категории для фильтра: ");
            Integer choise = sc.nextInt();
            if (choise > 0 && choise < 6){
                sc.close();
                return choise;
            }
            System.out.println("неправильный номер");
        }
    }

    public static void name(int num, Set<Laptop> laptops) {
        Scanner sc = new Scanner(System.in);
        Set<Object> categorySet = new HashSet<>();
        for (Laptop item : laptops) {
            switch (num) {
                case 1:
                    categorySet.add(item.getCpu());
                    break;
                case 2:
                    categorySet.add(item.getRam());
                    break;
                case 3:
                    categorySet.add(item.getStorage());
                    break;
                case 4:
                    categorySet.add(item.getOs());
                    break;
                case 5:
                    categorySet.add(item.haveGpu());
                    break;
            }
        }        
    }

    public static Set<Laptop> fillLaptopSet() {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("AMD", 16, 512, "Linux", true));
        laptops.add(new Laptop("Intel", 32, 1024, "Windows", true));
        laptops.add(new Laptop("Intel", 4, 256, "Windows", false));
        laptops.add(new Laptop("AMD", 8, 400, "Linux", false));
        laptops.add(new Laptop("Intel", 16, 512, "Windows", false));
        laptops.add(new Laptop("Intel", 8, 400, "Windows", false));
        return laptops;        
    }
}
