/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.velorin.parser;

import com.velorin.annotation.DTO;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 *
 * @author Amir Hooshangi
 * email: Amirhoshangi at Gmail
 */
public class JavaBeanParser implements BeanParser {

    public ArrayList<Field> getFields(Class<?> toBeParsedClass) {

        final Field[] unParsedFileds = toBeParsedClass.getDeclaredFields();
        final ArrayList<Field> parsedFields = new ArrayList<Field>();
        for (int i = 0; i < unParsedFileds.length; i++) {
            if (unParsedFileds[i].getAnnotation(DTO.class) == null) {

            } else {
                parsedFields.add(unParsedFileds[i]);
            }
        }
        return parsedFields;
    }
}
