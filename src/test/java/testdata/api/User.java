package testdata.api;

import net.datafaker.Faker;

import java.util.Locale;

public class User {

    private static final Faker faker = new Faker(new Locale("en"));

    public static models.api.User getDataToCreateUser() {
        int suffix = faker.number().numberBetween(1000, 10000);
        return models.api.User.builder()
                .username("bin_tester_" + suffix)
                .firstName("Bin")
                .lastName("Tester " + suffix)
                .email("bin.tester" + suffix + "@mail.com")
                .password(faker.regexify("[A-Z][a-z]{3,6}[0-9]{2,4}[!@#$]"))
                .phone("09" + faker.number().digits(8))
                .userStatus(1)
                .build();
    }

    public static models.api.User createUpdatedUser(models.api.User oldUser) {
        int suffix = faker.number().numberBetween(1000, 10000);
        return models.api.User.builder()
                .id(oldUser.getId())
                .username("bin_tester_updated_" + suffix)
                .firstName("Bin Updated")
                .lastName("Tester " + suffix)
                .email("bin.updated" + suffix + "@mail.com")
                .password(faker.regexify("[A-Z][a-z]{3,6}[0-9]{2,4}[!@#$]"))
                .phone("09" + faker.number().digits(8))
                .userStatus(1)
                .build();
    }

}