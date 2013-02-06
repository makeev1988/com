package com.jcourse.makeev.calculator;

import com.jcourse.makeev.calculator.comand.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Alexey
 * Date: 02.02.13
 * Time: 15:59
 * To change this template use File | Settings | File Templates.
 */
public class Parser {



    public static void main (String arg[]) throws IOException {
        Stack stack = new Stack();
        HashMap m = new HashMap();              //карта определений

        HashMap listCommmand = new HashMap();   //Карта команд
        listCommmand.put("#", new Comment());
        listCommmand.put("PUSH", new Push());
        listCommmand.put("POP", new Pop());
        listCommmand.put("PRINT", new Print());
        listCommmand.put("+", new Plus());
        listCommmand.put("-", new Minus());
        listCommmand.put("*", new Multiply());
        listCommmand.put("/", new Divide());
        listCommmand.put("SQRT", new Sqrt());
        listCommmand.put("DEFINE", new Define());

        byte[] b = new byte[128];
        String encoding = System.getProperty("file.encoding");


        while (true) {
            int count = System.in.read(b);
            String s = new String(b, 0, count, encoding);
            s = s.trim();
            String[] st = s.split(" ");

            Command c = (Command) listCommmand.get(st[0].toUpperCase());

            if (c == null){
                System.out.println("Неизвестная команда");
                continue;
            }
            String arg1=null, arg2=null;
            if (st.length > 1){
                arg1 = st[1];
            }

            if (st.length > 2){
                arg2 = st[2];
            }

            c.execute(arg1, arg2, stack, m);
        }
    }
}
