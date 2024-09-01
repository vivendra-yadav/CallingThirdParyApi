package Modle;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    Long id;
    String title;
    double price;
    Category category;
    String description;
    String image;
}
