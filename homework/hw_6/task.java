package hw_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class task {
    /*без этого не работает фильтр. ругается на map(стр. 81, 83) и paramChoice(стр. 81, 83, 91, 93)
    ошибка Local variable map defined in an enclosing scope must be final or effectively final Java(536871575) */
    static Map<Integer, String> map = new HashMap<>();
    static volatile Integer paramChoise = 0;
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {

        ArrayList<Laptop> laptops = fillLaptopArray();
        Boolean runFlag = true;
        Integer choise;
        
        while (runFlag) {
            System.out.println("\n1 - Вывод ноутбуков на экран");
            System.out.println("2 - Отфильтровать ноутбуки");
            System.out.println("3 - Сбросить фильтр");
            System.out.println("4 - Выход");
            System.out.print("\nВыберете действие: ");
            switch (sc.nextInt()) {
                case 1:
                    if (!laptops.isEmpty()) { 
                        for (Laptop laptop : laptops) {
                            System.out.println(laptop);
                        }
                    }
                    else System.out.println("Нет подходящих ноутбуков");
                    break;
                case 2:
                    choise = chooseCategory();
                    laptops = filterLaptops(laptops, choise);
                    break;
                case 3:
                    laptops = fillLaptopArray();
                    break;
                case 4:
                    runFlag = false;
                    sc.close();
                    break;
                default:
                    System.out.println("неправильный номер\n");
                    break;
            }
        }
    }

    public static Integer chooseCategory() {
        
        System.out.println("1 - Процессор");
        System.out.println("2 - Оперативная память");
        System.out.println("3 - Емкость хранилища данных");
        System.out.println("4 - Операционная система");
        System.out.println("5 - Наличие видеокарты");
        
        while (true){
            System.out.print("Введите номер категории для фильтра: ");
            Integer choise = sc.nextInt();
            if (choise > 0 && choise < 6) return choise;
            System.out.println("неправильный номер\n");
        }
    }

    public static ArrayList<Laptop> filterLaptops(ArrayList<Laptop> laptops, Integer choise) {
        
        Boolean filterBool;
        switch (choise) {
            case 1: case 4: // процессор, ос
                getCategorySet(map, laptops, choise);
                map.forEach((key, value) -> System.out.println(key + " - " + value));
                System.out.print("Введите номер  для фильтра: ");
                paramChoise = sc.nextInt();

                if (choise.equals(1)) laptops = laptops.stream().filter(l -> l.getCpu().equals(map.get(paramChoise)))
                                                            .collect(Collectors.toCollection(ArrayList::new));
                else laptops = laptops.stream().filter(l -> l.getOs().equals(map.get(paramChoise)))
                                        .collect(Collectors.toCollection(ArrayList::new));
                break;
                
            case 2: case 3: // озу и диск
                System.out.print("Введите минимальное значение: ");
                paramChoise = sc.nextInt();

                if(choise.equals(2)) laptops = laptops.stream().filter(l -> l.getRam() >= paramChoise)
                                                            .collect(Collectors.toCollection(ArrayList::new));
                else laptops = laptops.stream().filter(l -> l.getStorage() >= paramChoise)
                                        .collect(Collectors.toCollection(ArrayList::new));
                
                break;
            case 5: // видеокарта
                System.out.print("1 - есть, 0 - нет: ");
                paramChoise = sc.nextInt();
                if (paramChoise == 1) filterBool = true;
                else filterBool = false;

                if (choise.equals(5)) laptops = laptops.stream().filter(l -> l.haveGpu().equals(filterBool))
                                                            .collect(Collectors.toCollection(ArrayList::new));
                break;
        } 
        return laptops;     
    }

    // наполняет словарь map всеми уникальными значениями для выбранной характеристики
    public static void getCategorySet(Map<Integer, String> map, ArrayList<Laptop> laptops, Integer choise) {
        map.clear();
        int keyCounter = 1;
        String value = "";
        
        for (int i = 0; i < laptops.size(); i++) {
            if (choise.equals(1)) value = laptops.get(i).getCpu();
            else value = laptops.get(i).getOs();
            
            if (!map.containsValue(value)){
                map.put(keyCounter, value);
                keyCounter++;
            }
        }
    }

    public static ArrayList<Laptop> fillLaptopArray() {

        ArrayList<Laptop> laptops = new ArrayList<>();
        laptops.add(new Laptop("AMD Athlon", 16, 512, "Linux", true));
        laptops.add(new Laptop("Intel Core i7", 32, 1024, "Windows", true));
        laptops.add(new Laptop("Intel Celeron", 4, 256, "Windows", false));
        laptops.add(new Laptop("AMD Ryzen 3", 8, 400, "Linux", false));
        laptops.add(new Laptop("Intel Core i7", 16, 512, "Windows", false));
        laptops.add(new Laptop("Intel Core i3", 8, 400, "Windows", false));
        laptops.add(new Laptop("AMD Ryzen 3", 32, 1024, "Linux", true));
        laptops.add(new Laptop("Intel Core i7", 16, 1024, "Windows", true));
        laptops.add(new Laptop("Intel Core i3", 8, 512, "macOS", true));
        return laptops;
    }
}
