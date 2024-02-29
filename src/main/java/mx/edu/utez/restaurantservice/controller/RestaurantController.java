package mx.edu.utez.restaurantservice.controller;

import mx.edu.utez.restaurantservice.model.Restaurant;
import mx.edu.utez.restaurantservice.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/restaurant")
public class RestaurantController {
    private final RestaurantService service;

    public RestaurantController(RestaurantService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getById(@PathVariable Long id) {
        Optional<Restaurant> restaurantOptional = service.findById(id);
        if (restaurantOptional.isPresent()) {
            return new ResponseEntity<>(restaurantOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/")
    public List<Restaurant> getAll() {
        return service.findAll();
    }

    @PostMapping("/")
    public RestaurantDto addRestaurant(@RequestBody RestaurantDto restaurantDto) {
        Restaurant restaurant = service.save(restaurantDto);
        return RestaurantDto.builder()
                .id(restaurant.getId())
                .title(restaurant.getTitle())
                .description(restaurant.getDescription())
                .image(restaurant.getImage())
                .rating(restaurant.getRating())
                .build();
    }
}
