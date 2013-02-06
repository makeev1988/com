package com.jcourse.makeev.calculator.comand;

import com.jcourse.makeev.calculator.Command;

import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Alexey
 * Date: 02.02.13
 * Time: 16:22
 * To change this template use File | Settings | File Templates.
 */
public class Print implements Command {

    @Override
    public void execute(String arg, String getName, Stack stack, Map m) {
        //To change body of implemented methods use File | Settings | File Templates.
        if (stack.empty()) {
            System.out.println("Стек пуст");
        }
        else {
            System.out.println(stack.peek());
        }
    }
}
