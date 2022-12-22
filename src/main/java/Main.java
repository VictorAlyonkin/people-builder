public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();

        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У мамы " + mom + " есть сын " + son + ".");

        try {
            new PersonBuilder()
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            new PersonBuilder()
                    .setAge(-100)
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        //Пример для показа исправлений

        Person person = new PersonBuilder()
                .setName("SomeName")
                .setSurname("SomeName")
                .setAddress("City")
                .build();

        System.out.println("Person has age? " + person.hasAge());
        System.out.println(person);

        person.happyBirthday();
        person.happyBirthday();
        person.happyBirthday();
        person.happyBirthday();
        System.out.println("Person has age? " + person.hasAge());
        System.out.println(person);
    }
}