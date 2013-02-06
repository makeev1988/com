package com.jcourse.makeev.calculator;

/**
 * Created with IntelliJ IDEA.
 * User: Alexey
 * Date: 06.02.13
 * Time: 19:06
 * To change this template use File | Settings | File Templates.
 */
public class CreationCommand {
    CreationCommand(String nameCommand) throws IllegalAccessException, InstantiationException {
           Class c = CreationCommand.class;
           c.newInstance();
    }
}
