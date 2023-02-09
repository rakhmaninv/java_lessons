package hw_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

//В калькулятор добавьте возможность отменить последнюю операцию.

public class task_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Float numA = 0f, numB = 0f;
        Character action = 0;
        Stack<Float> result = new Stack<>();
        boolean runFlag = true;
        ArrayList<Character> operation = new ArrayList<>(Arrays.asList('+', '-', '*', '/'));
        
        numA = sc.nextFloat();

        while (runFlag) {
            action = sc.next().charAt(0);
            if (operation.contains(action)){
                numB = sc.nextFloat();
            }
            switch (action){
                case '+':
                    result.push(numA + numB);
                    break;
                case '-':
                    result.push(numA - numB);
                    break;
                case '*':
                    result.push(numA * numB);
                    break;
                case '/':
                    if (numB == 0){
                        result.push(numA / numB);
                        break;
                    }
                    else {
                        System.out.println("Can't divide by 0");
                        break;
                    }
                case '=':   //exit
                    runFlag = false;
                    break;
                case 'u':   // undo last calculation
                    result.pop();
                    break;
            }

            numA = result.peek();
            System.out.println(numA);
        }
        sc.close();
    }
}
