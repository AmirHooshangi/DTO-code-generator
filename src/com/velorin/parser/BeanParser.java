package com.velorin.parser;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 *
 * @author Amir Hooshangi
 * email: Amirhoshangi at Gmail
 */
public interface BeanParser {

    ArrayList<Field> getFields(Class<?> clazz);

}
