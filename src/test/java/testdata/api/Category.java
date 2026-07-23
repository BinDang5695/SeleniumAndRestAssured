package testdata.api;

import net.datafaker.Faker;

import java.util.Locale;

public class Category {

    private static final Faker faker = new Faker(new Locale("en"));

    public static models.api.Category getDataToCreateCategory() {
        return models.api.Category.builder()
                .name("Bin Tester dz create Category " + faker.number().numberBetween(1, 10000))
                .build();
    }

    public static models.api.Category createUpdatedCategory(models.api.Category categoryrequest) {
        return models.api.Category.builder()
                .id(categoryrequest.getId())
                .name("Bin Tester dz updated Category " + faker.number().numberBetween(1, 10000))
                .build();
    }

}