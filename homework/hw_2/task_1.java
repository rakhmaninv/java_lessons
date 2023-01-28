package homework.hw_2;

import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

public class task_1 {
    public static void main(String[] args) throws Exception{
        int[] array = {4,7,2,3,6,9,1,0,8,5};
        int len = array.length;

        Logger logger = Logger.getLogger(task_1.class.getName());
        FileHandler fHandler = new FileHandler("homework\\hw_2\\task_1_log.txt");
        logger.addHandler(fHandler);
        SimpleFormatter sFormatter = new SimpleFormatter();
        fHandler.setFormatter(sFormatter);
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
            logger.info(Arrays.toString(array));
        }
    }
}
