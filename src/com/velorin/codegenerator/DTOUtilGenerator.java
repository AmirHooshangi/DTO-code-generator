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
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 *
 * @author Amir Hooshangi
 * email: Amirhoshangi at Gmail
 */
public class DTOUtilGenerator implements ClassGenerator {

    public void generateDTOClass(Class<?> bean, String packageName, String filePath) throws JClassAlreadyExistsException, IOException {

        BeanParser beanParser = new JavaBeanParser();
        ArrayList<Field> fields = beanParser.getFields(bean);
        JCodeModel codeModel = new JCodeModel();
        JPackage jPackage = codeModel._package(packageName);
        JDefinedClass definedClass = jPackage._class(bean.getSimpleName() + "DTO");
        definedClass.constructor(JMod.PUBLIC);
        definedClass._implements(Serializable.class);
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
