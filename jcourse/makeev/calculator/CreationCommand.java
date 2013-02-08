package com.jcourse.makeev.calculator;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Alexey
 * Date: 06.02.13
 * Time: 19:06
 * To change this template use File | Settings | File Templates.
 */
public class CreationCommand {
        Command getCom (String className){
            Properties p = new Properties();
            try (InputStream in = CreationCommand.class.getResourceAsStream("commands.properties")) {
                p.load(in);
            }catch (IOException e){
                e.printStackTrace();
            }

            Command cmd = null;
            try {
                cmd  = (Command)Class.forName(className).newInstance();
            }catch (Exception e1){
                e1.printStackTrace();
            }
         return cmd;
        }

    public static void main(String[] arg) {
        CreationCommand com1 = new  CreationCommand();
        Command c = com1.getCom("PUSH");
    }

//         //for(Enumeration e =p.propertyNames(); e.hasMoreElements();) {
//             String cmdName = (String)e.nextElement();
//             String className = p.getProperty(cmdName);
//             try {
//                 listCommmand.put(cmdName, (Command)Class.forName(className).newInstance());
//             } catch (Exception e1) {
//                 e1.printStackTrace();
//             }
//         //}

}
