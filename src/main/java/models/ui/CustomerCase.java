package models.ui;

import lombok.Data;

@Data
public class CustomerCase {

    private String title;
    private CustomerDataDriven data;
    private String expectedType;
    private String expectedMessage;

}