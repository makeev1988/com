package com.jcourse.makeev.calculator.comand;

import com.jcourse.makeev.calculator.Command;

import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Alexey
 * Date: 04.02.13
 * Time: 14:01
 * To change this template use File | Settings | File Templates.
 */
public class Sqrt implements Command {
    @Override
    public void execute(String arg, String getName, Stack stack, Map m) {
        //To change body of implemented methods use File | Settings | File Templates.
        double num;

        if (stack.empty()) {
            System.out.println("Не заданы значения для операции");
        }
        else {
            num = (Double) stack.pop();
            if (num < 0){
                System.out.println("Число меньше 0");
                stack.push(num);
            }
            else {
                stack.push(Math.sqrt(num));
            }
        }

    }
}
