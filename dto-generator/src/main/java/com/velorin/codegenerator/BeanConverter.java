package com.velorin.codegenerator;

import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * User: Pooya
 * Email: info@pooya-hfp.ir
 * Date: 2/4/13
 * Time: 4:34 PM
 */
interface BeanConverter {
    void generateDtoFromBean(Class<?> beanClass, String destPackageName, String filePath) throws IOException, TemplateException;
    void generateDtoFromBean(String srcPackage, String destPackageName, String filePath) throws IOException,
            TemplateException;
}
