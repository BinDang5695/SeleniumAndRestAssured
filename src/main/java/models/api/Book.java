package models.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Book {

    private int id;
    private String name;
    private int category_id;
    private int price;
    private String release_date;
    private boolean status;

    private List<Integer> image_ids;


}
