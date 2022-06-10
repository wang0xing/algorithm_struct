package com.wx.binary_tree.example;

public class Hero implements Comparable<Hero>{

    private Integer id;
    private String name;

    public Hero(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Hero() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Hero o) {
        int compare = Integer.compare(this.id, o.id);
        return compare == 0 ? this.name.compareTo(o.name) : compare;
    }

    @Override
    public String toString() {
       return "[" + id +"]";
    }
}
