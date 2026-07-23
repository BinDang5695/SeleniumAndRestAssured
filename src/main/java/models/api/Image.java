package models.api;

import lombok.*;

import java.io.File;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Image {
    private File image;
}