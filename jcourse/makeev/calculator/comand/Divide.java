package com.jcourse.makeev.calculator.comand;

import com.jcourse.makeev.calculator.Command;

import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Alexey
 * Date: 04.02.13
 * Time: 13:52
 * To change this template use File | Settings | File Templates.
 */
public class Divide implements Command {

    @Override
    public void execute(String arg, String getName, Stack stack, Map m) {
        //To change body of implemented methods use File | Settings | File Templates.
        double num1, num2;

        if (stack.size() < 2){
            System.out.println("Не достаточно элементов для проведения операции");
        }
        else {
            num1 = (Double) stack.pop();
            num2 = (Double) stack.pop();
            if (num1 == 0){
                System.out.println("Деление на 0");
                stack.push(num2);
                stack.push(num1);
            }
            else {
                stack.push(num2 / num1);
            }
        }
    }
}
