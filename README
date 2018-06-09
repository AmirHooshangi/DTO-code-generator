# Summary
[DTO](https://en.wikipedia.org/wiki/Data_transfer_object) (Data Transfer Object code generator API helps developers to use DTO design pattern fast and effectively. DTO design pattern is being used in wide area of JavaEE projects, especially in those which uses EJB, SOAP, REST etc, technologies. this API is for developers who hate writing DTO classes and convert those values to their Beans and vise versa. There are some easy steps to use this API, and some important notes that will be mentioned. all you need is methods in ClassGenerator interface. DTOUtilGenerator is one of implementations of ClassGenerator. so you need instances of this class.
example :
```sh
ClassGenerator dTOUtilGenerator = new DTOUtilGenerator();
```
one of the advantages of this API is that it generates DTO class from your main Java Beans.
you can generate your DTO class using generateDTOClass method in ClassGenerator interface.
There are some notes that you must notice:

first add jar of this project to your own project.
suppose you have Hibernate Java Bean (it can be any POJO) and want to generate it's DTO class for using it in EJB or SOAP services.
you must use @DTO annotation on top the fields on your Hibernate Bean that you want see in DTO class.
e.g
```sh
public class Student {

    @DTO
    private int id;

    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
```
As you see "id" has @DTO annotation but "name" doesn't, it means you wont to see a field called "name" in your DTO class.

Note: you must generate setters and getters for annotated field and you must do it with standard java
naming setXxx(..) getXxx().

now you are ready to generate your DTO class with this methode.
```sh
DTOUtilGenerator.generateDTOClass(Student.class, "yourPackageName", "pathToSave");
```
Student is your (for example Hibernate) Bean class, "yourPackageName" is package of your java class. and "pathToSave" is where you want to save your java file on the hard disk.

Now add this class to your project class path. the name of generated class should be StudentDTO.

so you are able to generate utility class for this DTO class cause you have StudentDTO.class in your
classpath
```sh
DTOUtilGenerator.generateDTOUtilClass(Student.class, StudentDTO.class,"yourPackageName", "pathToSave");
```
# License
GPL and free software :)
