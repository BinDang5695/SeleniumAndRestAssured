package testdata.api;

import net.datafaker.Faker;

import java.util.Collections;
import java.util.Locale;

public class Book {

    private static final Faker faker = new Faker(new Locale("en"));

    public static models.api.Book getDataToCreateBook() {
        return models.api.Book.builder()
                .name("Bin Tester dz create Book " + faker.number().numberBetween(1, 10000))
                .category_id(594)
                .price(faker.number().numberBetween(1, 9999))
                .release_date(
                        faker.timeAndDate()
                                .birthday(18, 80)
                                .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                )
                .status(true)
                .image_ids(Collections.singletonList(76))
                .build();
    }

    public static models.api.Book createUpdatedBook(models.api.Book request) {
        return models.api.Book.builder()
                .id(request.getId())
                .name("Bin Tester dz updated Book " + faker.number().numberBetween(1, 10000))
                .category_id(request.getCategory_id())
                .price(request.getPrice())
                .release_date(request.getRelease_date())
                .status(false)
                .image_ids(Collections.singletonList(61))
                .build();
    }

}