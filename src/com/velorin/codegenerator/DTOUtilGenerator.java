package com.velorin.codegenerator;

import com.sun.codemodel.JBlock;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JPackage;
import com.velorin.parser.BeanParser;
import com.velorin.parser.JavaBeanParser;
import com.velorin.utils.Util;
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

//TODO: DTO class must implement implement serializable.
    public void generateDTOClass(Class<?> bean, String packageName, String filePath) throws JClassAlreadyExistsException, IOException {

        BeanParser beanParser = new JavaBeanParser();
        ArrayList<Field> fields = beanParser.getFields(bean);
        JCodeModel codeModel = new JCodeModel();
        JPackage jPackage = codeModel._package(packageName);
        JDefinedClass definedClass = jPackage._class(bean.getSimpleName() + "DTO");
        for (int i = 0; i < fields.size(); i++) {
            definedClass.field(JMod.PRIVATE, fields.get(i).getType(), fields.get(i).getName());
        }
        Util.generateSetter(fields, definedClass);
        Util.generateGetter(fields, definedClass);
        codeModel.build(new File(filePath));
    }

    public void generateDTOUtilClass(Class<?> bean, Class<?> beanDTO, String packageName, String filePath) throws JClassAlreadyExistsException, IOException {

        BeanParser beanParser = new JavaBeanParser();
        ArrayList<Field> fields = beanParser.getFields(bean);
        JCodeModel codeModel = new JCodeModel();
        JPackage jPackage = codeModel._package(packageName);
        JDefinedClass definedClass = jPackage._class(bean.getSimpleName() + "DTOUtil");
        generateBeanToDTO(definedClass, beanDTO, bean, fields);
        generateDTOtoBean(definedClass, bean, beanDTO, fields);
        codeModel.build(new File(filePath));
    }

    private void generateDTOtoBean(JDefinedClass definedClass, Class<?> bean, Class<?> beanDTO, ArrayList<Field> fields) {
        JMethod jMethod = definedClass.method(JMod.PUBLIC | JMod.STATIC, bean, "convertDTOtoBean");
        jMethod.param(0, beanDTO, "beanDTO");
        JBlock jBlock = jMethod.body();
        jBlock.directStatement(bean.getSimpleName() + " bean = new " + bean.getSimpleName() + "();");
        for (int i = 0; i < fields.size(); i++) {
            jBlock.directStatement("bean.set" + Util.uppercaseFirstCharacter(fields.get(i).getName()) + "(" + "beanDTO." + "get" + Util.uppercaseFirstCharacter(fields.get(i).getName()) + "()" + ");");
        }
        jBlock.directStatement("return bean;");
    }

    private void generateBeanToDTO(JDefinedClass definedClass, Class<?> beanDTO, Class<?> bean, ArrayList<Field> fields) {
        JMethod jMethod = definedClass.method(JMod.PUBLIC | JMod.STATIC, beanDTO, "convertBeanToDTO");
        jMethod.param(0, bean, "bean");
        JBlock jBlock = jMethod.body();
        jBlock.directStatement(beanDTO.getSimpleName() + " beanDTO = new " + beanDTO.getSimpleName() + "();");
        for (int i = 0; i < fields.size(); i++) {
            jBlock.directStatement("beanDTO.set" + Util.uppercaseFirstCharacter(fields.get(i).getName()) + "(" + "bean." + "get" + Util.uppercaseFirstCharacter(fields.get(i).getName()) + "()" + ");");
        }
        jBlock.directStatement("return beanDTO;");
    }
}
