package mx.edu.utez.restaurantservice.controller;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantDto {
    private Long id;
    private String title;
    private String description;
    private Integer rating;
    private String image;
}
