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

    void generateDTOClass(Class<?> toBeParsedClass, String packageName, String filePath) throws JClassAlreadyExistsException, IOException;

    void generateDTOUtilClass(Class<?> bean, Class<?> beanDTO, String packageName, String filePath) throws JClassAlreadyExistsException, IOException;

}
