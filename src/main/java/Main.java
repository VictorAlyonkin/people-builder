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
            e.printStackTrace();
        }

        try {
            new PersonBuilder()
                    .setAge(-100)
                    .build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
