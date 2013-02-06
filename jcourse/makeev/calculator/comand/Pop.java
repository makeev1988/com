package com.jcourse.makeev.calculator.comand;

import com.jcourse.makeev.calculator.Command;

import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Alexey
 * Date: 04.02.13
 * Time: 17:14
 * To change this template use File | Settings | File Templates.
 */
public class Pop implements Command {
    @Override
    public void execute(String arg, String getName, Stack stack, Map m) {
        //To change body of implemented methods use File | Settings | File Templates.

        if (stack.empty()) {
            System.out.println("Стек пуст");
        }
        else  {
            stack.pop();
        }
    }
}
