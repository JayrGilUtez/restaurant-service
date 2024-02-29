package mx.edu.utez.restaurantservice.service;

import mx.edu.utez.restaurantservice.controller.RestaurantDto;
import mx.edu.utez.restaurantservice.model.Restaurant;
import mx.edu.utez.restaurantservice.model.RestaurantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RestaurantService {
    private final RestaurantRepository repository;
    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Restaurant save(RestaurantDto restaurantDto){
        Restaurant restaurant = Restaurant.builder()
                .id(restaurantDto.getId())
                .title(restaurantDto.getTitle())
                .description(restaurantDto.getDescription())
                .image(restaurantDto.getImage())
                .rating(restaurantDto.getRating())
                .build();
        return repository.save(restaurant);
    }

    @Transactional(readOnly = true)
    public List<Restaurant> findAll(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Restaurant> findById(Long id){
        return repository.findById(id);
    }


}
