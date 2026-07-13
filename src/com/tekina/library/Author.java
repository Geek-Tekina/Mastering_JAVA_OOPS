package com.tekina.library;

public class Author {
//    Generated Fields : id
//
//    Mandatory Fields : name
//
//    Optional Fields :
//
//    Mutable Fields :
//
//    Immutable Fields : id, name

    private static int ID = 1;
    private int id;
    private String name;

    public Author(String name){
        if(name == null || name.isBlank()){
            throw  new IllegalArgumentException("Name can not be empty or null.");
        }
        this.id = ID++;
        this.name = name;
    }

    public int getAuthorId(){
       return this.id;
    }

    public String getName(){
        return this.name;
    }
    @Override
    public String toString() {
        return "Author Name : " + this.name + "| Author Id : " + this.id;
    }
}
