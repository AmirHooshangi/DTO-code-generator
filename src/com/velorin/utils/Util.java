package com.velorin.utils;

import com.sun.codemodel.JBlock;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JMethod;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 *
 * @author amir
 */
public  class Util {

    public static JDefinedClass generateSetter(ArrayList<Field> fields, JDefinedClass definedClass) {

        JBlock jBlock = null;
        for (int i = 0; i < fields.size(); i++) {
            JMethod jMethod = definedClass.method(1, void.class, "set" + uppercaseFirstCharacter(fields.get(i).getName()));
            jMethod.param(0, fields.get(i).getType(), fields.get(i).getName());
            jBlock = jMethod.body();
            jBlock.directStatement("this." + fields.get(i).getName() + " = " + fields.get(i).getName()+";");
        }
        return definedClass;
    }

    public static JDefinedClass generateGetter(ArrayList<Field> fields, JDefinedClass definedClass) {

        JBlock jBlock = null;
        for (int i = 0; i < fields.size(); i++) {
            JMethod jMethod = definedClass.method(1, fields.get(i).getType(), "get" + uppercaseFirstCharacter(fields.get(i).getName()));
            jBlock = jMethod.body();
            jBlock.directStatement("return " + fields.get(i).getName()+";");
        }
        return definedClass;
    }
    
    
//TODO: optimising this function    
 public static String uppercaseFirstCharacter(String name){
     
     char[] characters = name.toString().toCharArray();
     characters[0] -= 32;
     return new String(characters);
 } 
}
