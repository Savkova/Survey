package com.savkova.app.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Person
{
    private int id;
    private String name;
    private String surname;
    private int yearOfBirth;

    private static int count;

    public Person(final String name, final String surname, final int year)
    {
        this.id = ++count;
        this.name = name;
        this.surname = surname;

        int currentYear = LocalDate.now().getYear();
        if (year > currentYear)
            this.yearOfBirth = currentYear;
        else
            this.yearOfBirth = year;
    }

    public String getName()
    {
        return name;
    }

    public String getSurname()
    {
        return surname;
    }

    public int getYearOfBirth()
    {
        return yearOfBirth;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return id == person.id &&
                getYearOfBirth() == person.getYearOfBirth() &&
                Objects.equals(getName(), person.getName()) &&
                Objects.equals(getSurname(), person.getSurname());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getName(), getSurname(), getYearOfBirth());
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", yearOfBirth=").append(yearOfBirth);
        sb.append('}');
        return sb.toString();
    }
}
