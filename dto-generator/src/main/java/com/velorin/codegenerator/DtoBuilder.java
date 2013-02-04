package com.velorin.codegenerator;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Pooya
 * Date: 2/4/13
 * Time: 4:27 PM
 */
class DtoBuilder {

    private List<Field> fields = new ArrayList<Field>();
    private String packageName;
    private String className;

    public void addField(Field field) {
        fields.add(field);
    }

    public void setPackageName(String name) {
        packageName = name;
    }

    public void setClassName(String name) {
        className = name;
    }

    public void generateTemplate(String filePath) throws IOException, TemplateException {
        if (fields.size() <= 0)
            return;

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("fields", fields);
        map.put("className", className);
        map.put("packageName", packageName);

        Configuration cfg = new Configuration();
        cfg.setDirectoryForTemplateLoading(
                new File("/home/pooya/Desktop/temp/DTO-code-generation/dto-generator/src/main/resources/templates/"));
        cfg.setObjectWrapper(new DefaultObjectWrapper());

        freemarker.template.Template temp = cfg.getTemplate("dto.ftl");

        Writer out = new FileWriter(new File(filePath));
        temp.process(map, out);
        out.flush();
        out.close();
    }
}