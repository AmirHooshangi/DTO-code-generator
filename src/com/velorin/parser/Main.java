package com.velorin.parser;

import com.velorin.annotation.test.MyJavaBean;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.velorin.annotation.DTO;
import com.velorin.codegenerator.DTOUtilGenerator;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 *
 * @author Amir Hooshangi
 * email: Amirhoshangi at Gmail
 */
public class Main {


    public static void main(String[] args) throws NoSuchFieldException, JClassAlreadyExistsException, IOException {

        BeanParser beanParser = new JavaBeanParser();
        ArrayList<Field> fields = beanParser.getFields(MyJavaBean.class);
//
//        for (int i = 0; i < fields.size(); i++) {
//            System.out.println(fields.get(i).getName());
//        }


        DTOUtilGenerator dTOUtilGenerator = new DTOUtilGenerator();
        dTOUtilGenerator.generateDTOClass(MyJavaBean.class, fields, new File("/home/nullpointer/"));
//        dTOUtilGenerator.test(MyJavaBean.class, fields, new File("/home/nullpointer"));

    }
}
