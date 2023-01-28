package homework.hw_2;

import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task_4 {
    public static void main(String[] args) throws Exception {
        boolean flag = true;
        double result = 0;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("введите число A: ");
        double numA = scan.nextDouble();
        System.out.println("введите оператор");
        char operator = scan.next().charAt(0);
        System.out.println("введите число B: ");
        double numB = scan.nextDouble();
        
        switch (operator) {
            case '+':
                result = numA + numB;
                break;
            case '-':
                result = numA - numB;
                break;
            case '*':
                result = numA * numB;
                break;
            case '/':
                if (numB != 0){
                    result = numA / numB;
                    break;
                }
                else {
                    System.out.println("нельзя делить на ноль");
                    flag = false;
                }
        }
        scan.close();
        if(flag) System.out.printf("%f %s %f = %f", numA, operator, numB, result);

        Logger logger = Logger.getLogger(task_4.class.getName());
        FileHandler fh = new FileHandler("homework\\hw_2\\task_4_log.txt", true);
        logger.addHandler(fh);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);

        String messege = String.format("number A: %f; number B: %f; operator %c; result %f;", numA, numB, operator, result);
        logger.info(messege);
    }

    
}
