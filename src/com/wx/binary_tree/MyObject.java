package com.wx.binary_tree;

import java.util.Objects;

public class MyObject implements Comparable<MyObject>{
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(MyObject o) {

        int compare = Integer.compare(this.id, o.id);

        return compare == 0 ? this.name.compareTo(o.name) : compare;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyObject myObject = (MyObject) o;
        return id == myObject.id && Objects.equals(name, myObject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
