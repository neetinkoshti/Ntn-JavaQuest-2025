package org.ntn.com.javaconcepts.immutable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomImmutableClass {

    public static void main(String[] args) {

        Immutable obj1 = new Immutable(1, "Nitin", new Date(), List.of("Java", "Spring", "Hibernate"));
        System.out.println("Immutable Before :"+obj1);

        obj1.getName().concat(" Kumar");
        obj1.getSkills().addAll(List.of("Java", "Spring", "Hibernate", "JPA"));
        obj1.getStartDate().setTime(25);

        System.out.println("Immutable After: "+obj1);

        NonImmutableExample nonImmutableObj = new NonImmutableExample(1, "Nitin", new Date(), List.of("Java", "Spring", "Hibernate"));
        System.out.println("NonImmutableExample Before :"+nonImmutableObj);

        nonImmutableObj.getStartDate().setTime(12);
        nonImmutableObj.setSkills(List.of("Java", "Spring", "Hibernate", "JPA"));
        System.out.println("NonImmutableExample After: "+nonImmutableObj);


    }
}

final class Immutable{

    private int id;
    private String name;
    private Date startDate;
    private List<String> skills;

    public Immutable(int id, String name, Date startDate, List<String> skills) {
        this.id = id;
        this.name = name;
        this.startDate = new Date(startDate.getTime());
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return new Date(startDate.getTime());
    }

    public List<String> getSkills() {
        return new ArrayList<>(skills);
    }

    @Override
    public String toString() {
        return "Immutable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", skills=" + skills +
                '}';
    }
}

class NonImmutableExample{


    private int id;
    private String name;
    private Date startDate;
    private List<String> skills;

    public NonImmutableExample(int id, String name, Date startDate, List<String> skills) {
        this.id = id;
        this.name = name;
        this.startDate = new Date(startDate.getTime());
        this.skills = skills;
    }

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "NonImmutableExample{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", skills=" + skills +
                '}';
    }
}



