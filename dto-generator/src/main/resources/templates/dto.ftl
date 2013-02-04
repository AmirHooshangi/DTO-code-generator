package ${packageName};

class ${className} {
<#list fields as field>
    private ${field}.type ${field}.name;

    public ${field}.type get${field}.name(){
        return this.${field}.name;
    }

    public ${field}.type get${field}.name(){
        return this.${field}.name;
    }
</#list>
}