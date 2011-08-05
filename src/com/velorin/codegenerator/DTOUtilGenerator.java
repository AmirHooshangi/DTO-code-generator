package com.velorin.codegenerator;

import com.sun.codemodel.JBlock;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JMethod;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 *
 * @author Amir Hooshangi
 * email: Amirhoshangi at Gmail
 */
public class DTOUtilGenerator implements ClassGenerator {

    public void generateDTOClass(Class<?> clazz, ArrayList<Field> fields, File file) throws JClassAlreadyExistsException, IOException {

        JCodeModel codeModel = new JCodeModel();
        JDefinedClass definedClass = codeModel._class(clazz.getSimpleName()+"DTO");
        for (int i = 0; i < fields.size(); i++) {
            JFieldVar fieldVar = definedClass.field(4, fields.get(i).getType(), fields.get(i).getName());
        }

        for (int i = 0; i < fields.size(); i++) {
        JMethod jMethod  = definedClass.method(1, void.class, "set"+fields.get(i).getName());
        jMethod.param(0, fields.get(i).getType(), fields.get(i).getName());
        JBlock jBlock = jMethod.body();
        jBlock.directStatement("this."+ fields.get(i).getName() + " = " + fields.get(i).getName());
        }
        
        for (int i = 0; i < fields.size(); i++) {
        JMethod jMethod  = definedClass.method(1, fields.get(i).getType(), "get"+fields.get(i).getName());
        JBlock jBlock = jMethod.body();
        jBlock.directStatement("return "+ fields.get(i).getName());
        }

        file.mkdirs();
        codeModel.build(file);
    }

    public void generateDTOUtilClass(Class<?> toBeParsedClass, ArrayList<Field> fields, File file) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public void test(Class<?> clazz, ArrayList<Field> fields, File file) throws JClassAlreadyExistsException, IOException {
        JCodeModel codeModel = new JCodeModel();
        JDefinedClass definedClass = codeModel._class(clazz.getName()+"DTOConvertor");
        String methodeName = "convert"+clazz.getSimpleName()+"to"+clazz.getSimpleName()+"DTO";
        JMethod jMethod  = definedClass.method(1, int.class, methodeName);
        JBlock jBlock = jMethod.body();
        jBlock.directStatement("varName.setCode(100);");

        file.mkdirs();
        codeModel.build(file);
    }
}
