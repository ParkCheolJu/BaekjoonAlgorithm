package com.example.demo;

import java.util.*;
import java.util.stream.Collectors;

class Person {
    private String name;
    private int age;
    private String city;
    private String occupation;
    private String hobby;

    public Person(String name, int age, String city, String occupation, String hobby) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.occupation = occupation;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getHobby() {
        return hobby;
    }
}

public class MultiFieldGroupingSimplifiedExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 25, "New York", "Engineer", "Gardening"),
                new Person("Bob", 30, "Los Angeles", "Designer", "Gardening"),
                new Person("Charlie", 25, "Chicago", "Teacher", "Cooking"),
                new Person("David", 30, "Houston", "Engineer", "Traveling"),
                new Person("Alice", 25, "New York", "Engineer", "Reading"),
                new Person("Bob", 30, "Los Angeles", "Designer", "Gardening"),
                new Person("Charlie", 25, "Chicago", "Teacher", "Cooking"),
                new Person("David", 30, "Houston", "Engineer", "Cooking"),
                new Person("Charlie", 25, "Chicago", "Teacher", "Traveling"),
                new Person("David", 30, "Houston", "Engineer", "Traveling"),
                new Person("Eve", 25, "New York", "Doctor", "Hiking")
        );

        Map<List<Object>, List<Person>> groupedPeople = people.stream()
                .collect(Collectors.groupingBy(person ->
                        Arrays.asList(person.getName(), person.getAge(), person.getCity(), person.getOccupation())));

        groupedPeople.forEach((key, group) -> {
            String name = (String) key.get(0);
            int age = (int) key.get(1);
            String city = (String) key.get(2);
            String occupation = (String) key.get(3);

            System.out.println("KEY : + " + key + ", GROUP: " + test(group));
        });
    }

    private static String test(List<Person> group){
        StringBuilder sb = new StringBuilder();
        group.forEach(item -> sb.append(item.getHobby()).append(" "));

        return sb.toString();
    }
}