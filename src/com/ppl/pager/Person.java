package com.ppl.pager;

public class Person implements Comparable<Person> {
    public String Name = "";
    public int Age = 0;

    public Person(String name, int age) {
        Name = name;
        Age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person p = (Person) obj;
            if (p.Name.equalsIgnoreCase(Name)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Person p) {
        if (p == null) return -1;
        else {
            if (p.Name.equalsIgnoreCase(Name) && p.Age == this.Age) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Person, Name:%s Age:%d", Name, Age);
    }


}
