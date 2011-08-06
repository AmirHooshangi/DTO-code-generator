/*
 * Copyright (C) 2011 Amir Hooshangi.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 as published by
 * the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, see http://www.gnu.org/licenses or write to the
 * Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301 USA.
 *
 * You can contact Amir Hooshangi via Email
 * AmirHoshangi at Gmail
 *
 */
package com.velorin.utils;

import com.sun.codemodel.JBlock;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JMethod;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 *
 * @author Amir Hooshangi
 * Email: amirhoshangi at Gmail
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
    
    
 public static String uppercaseFirstCharacter(String name){
     
     char[] characters = name.toString().toCharArray();
     if(Character.isUpperCase(characters[0])){
         return name;
     }else{
         characters[0] = Character.toUpperCase(characters[0]);
         return new String(characters);
     }
 } 
}
