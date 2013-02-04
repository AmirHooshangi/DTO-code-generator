package com.velorin.codegenerator;

import annoations.DTO;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * User: Pooya
 * Date: 2/4/13
 * Time: 4:36 PM
 */
public class DtoGenerator implements BeanConverter {
    @Override
    public void generateDtoFromBean(Class<?> beanClass, String destPackageName, String filePath) throws IOException, TemplateException {

        DtoBuilder builder = new DtoBuilder();

        for (Field field : beanClass.getDeclaredFields()) {
            if (field.getAnnotation(DTO.class) != null)
                builder.addField(new com.velorin.codegenerator.Field(field.getType().getName(), field.getName()));
        }

        builder.setClassName(beanClass.getSimpleName());
        builder.setPackageName(destPackageName);
        builder.generateTemplate(filePath);
    }

    @Override
    public void generateDtoFromBean(String srcPackage, String destPackageName, String filePath) throws IOException,
            TemplateException {
        ArrayList<Class<?>> classesForPackage = ClassExtractor.getClassesForPackage(srcPackage);
        for (Class<?> aClass : classesForPackage) {
            generateDtoFromBean(aClass, destPackageName, filePath);
        }
    }
}
