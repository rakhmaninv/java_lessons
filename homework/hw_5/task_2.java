package hw_5;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*Пусть дан список сотрудников:
Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности Имени. */

public class task_2 {
    public static void main(String[] args) throws Exception {
        File filepath = new File("homework\\hw_5\\task_2_names.txt");
        Map<String, Integer> map = mapFromFile(filepath);
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        
        Set<Integer> setOfValues = new HashSet<>(map.values());
        ArrayList<Integer> list = new ArrayList<>(setOfValues);
        Collections.sort(list, Collections.reverseOrder());

        for (Integer num : list) {
            for (var item : map.entrySet()) {
                if (item.getValue().equals(num)) {
                    sortedMap.put(item.getKey(), num);
                }
            }
        }
        System.out.println(sortedMap);
    }

    public static Map<String, Integer> mapFromFile(File path) throws Exception {
        Map<String, Integer> map = new HashMap<>();
        Reader fr = new FileReader(path);
        Scanner sc = new Scanner(fr);
        String name;

        while (sc.hasNextLine()) {
            name = sc.nextLine().split(" ")[0];
            if (map.containsKey(name)) {
                map.put(name, map.get(name) + 1);
            } else {
                map.put(name, 1);
            }
        }
        sc.close();
        fr.close();
        return map;
    }
}
