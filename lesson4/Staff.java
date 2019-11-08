package ru.geekbrains.lesson4;

public class Staff {

    private String fullName, position, phoneNumber;
    private int salary, age, uniqueNumber;
    private static int count = 1;

    private Staff(){
        uniqueNumber += count;
        count++;
    }

    Staff(String fullName, String position, String phoneNumber, int salary, int age) {
        this();
        this.fullName = fullName;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }


    public String getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public int getUniqueNumber() {
        return uniqueNumber;
    }

    public void fullInfo() {
        System.out.println(uniqueNumber + ") " + fullName + " - " + position + ", " + phoneNumber + ", ЗП - " + salary + " рублей, возраст - " + age);
    }

    public void increaseSalary(int a) {
        salary += a;
    }


}
