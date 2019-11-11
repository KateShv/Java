package ru.geekbrains.lesson4;


public class Main {

    public static void main(String[] args) {

        Staff[] staffers = new Staff[5];

        staffers[0] = new Staff("Рукосуев Андрей Николаевич", "директор", "+79263542587", 150000, 41);
        staffers[1] = new Staff("Ананидзе Зураб Ильевич", "начальник отдела", "+79361648974", 65000, 46);
        staffers[2] = new Staff("Сухозад Алексей Викторович", "программист", "+79809524873", 95000, 35);
        staffers[3] = new Staff("Недоступенко Алиса Ивановна", "программист", "+79853247512", 75000, 28);
        staffers[4] = new Staff("Бородатая Елена Петровна", "бухгалтер", "+79958394521", 65000, 52);

        for (Staff a: staffers) {
            System.out.println(a.getUniqueNumber() + ") " + a.getFullName() + " - " + a.getPosition());
        }
        System.out.println();

        for (Staff age: staffers) {
            if (age.getAge() > 40) {
                age.fullInfo();
            }
        }
        System.out.println();

        for (Staff age: staffers) {
            if (age.getAge() > 45) {
                age.increaseSalary(5000);
                age.fullInfo();
            }
        }
        System.out.println();

    }
}
