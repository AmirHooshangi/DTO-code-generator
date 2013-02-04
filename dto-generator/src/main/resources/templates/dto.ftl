package ${packageName};

public class ${className} {
<#list fields as field>
    private ${field.getType()} ${field.getName()};

    public ${field.getType()} get${field.getName()?cap_first}(){
        return this.${field.getName()};
    }

    public ${field.getType()} set${field.getName()?cap_first}(${field.getType()}  ${field.getName()}){
        this.${field.getName()}=${field.getName()};
    }
</#list>
}