package com.velorin.codegenerator;

import com.sun.codemodel.JClassAlreadyExistsException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 *
 * @author Amir Hooshangi
 * email: Amirhoshangi at Gmail
 */
public interface ClassGenerator {

    void generateDTOClass(Class<?> toBeParsedClass, ArrayList<Field> fields, String packageName) throws JClassAlreadyExistsException, IOException;

    void generateDTOUtilClass(Class<?> toBeParsedClass, ArrayList<Field> fields, String packageName) throws JClassAlreadyExistsException, IOException;

}
