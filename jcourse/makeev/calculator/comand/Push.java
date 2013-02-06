package com.jcourse.makeev.calculator.comand;

import com.jcourse.makeev.calculator.Command;
import sun.org.mozilla.javascript.internal.ast.IfStatement;

import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Alexey
 * Date: 02.02.13
 * Time: 15:34
 * To change this template use File | Settings | File Templates.
 */
public class Push implements Command{

    @Override
    public void execute(String arg, String getName, Stack stack, Map m) {
        //To change body of implemented methods use File | Settings | File Templates.

        String value = (String) m.get(arg);



        if (value == null) {
            try {
                Double.parseDouble(arg);
                stack.push(Double.parseDouble(arg));
            }
            catch (Exception e) {
                System.out.println("Не число");
            }







        }
        else {
            stack.push(Double.parseDouble(value));
        }
    }
}
