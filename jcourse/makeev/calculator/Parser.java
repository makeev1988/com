package com.jcourse.makeev.calculator;

import com.jcourse.makeev.calculator.comand.*;
import com.sun.xml.internal.bind.v2.runtime.output.IndentingUTF8XmlOutput;

import java.io.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Alexey
 * Date: 02.02.13
 * Time: 15:59
 * To change this template use File | Settings | File Templates.
 */
public class Parser {



    public static void main (String arg[]) {
        Stack <Double> stack = new Stack<>();
        HashMap m = new HashMap();              //карта определений

        HashMap<String, Command> listCommmand = new HashMap<>();   //Карта команд


        /*
        Properties p = new Properties();
        try (InputStream in = Parser.class.getResourceAsStream("comands.properties")) {
             p.load(in);
        }catch (IOException e){
            e.printStackTrace();
        }


          for(Enumeration e =p.propertyNames(); e.hasMoreElements();) {
              String cmdName = (String)e.nextElement();
              String className = p.getProperty(cmdName);
              try {
                  listCommmand.put(cmdName, (Command)Class.forName(className).newInstance());
              } catch (Exception e1) {
                  e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.

              }
          }
        */


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

//        System.out.println("Введите имя файла, файл должен находится в папке c:\\Text\\");
//        byte[] bName = new byte[128];
//        String encoding = System.getProperty("file.encoding");
//        int countName = System.in.read(bName);

        InputStream in = System.in;

        if (arg.length > 0) {
            try {
                in = new FileInputStream(arg[0]);
            } catch (FileNotFoundException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                System.out.println("Файл не найден");
            }
        }

        //String file = nameFile.replaceAll("\\n", "");

        ReedFile rf = new ReedFile(in);

        String s;

        try {
            while ( (s = rf.getNextSting()) != null) {

                s = s.trim();
                String[] st = s.split(" ");

                Command c =  listCommmand.get(st[0].toUpperCase());

                if (c == null){
                    System.out.println("Неизвестная команда");
                    continue;
                }
                String arg1 = null, arg2 = null;
                if (st.length > 1){
                    arg1 = st[1];
                }

                if (st.length > 2){
                    arg2 = st[2];
                }

                c.execute(arg1, arg2, stack, m);
            }
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
