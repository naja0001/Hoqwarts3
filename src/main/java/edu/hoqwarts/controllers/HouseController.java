package edu.hoqwarts.controllers;

import edu.hoqwarts.models.House;
import edu.hoqwarts.services.HouseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/houses")
public class HouseController {

    private final HouseServices houseServices;

    @Autowired
    public HouseController(HouseServices houseServices) {
        this.houseServices = houseServices;
    }

    // Get all houses
    @GetMapping
    public ResponseEntity<List<House>> getAllHouses() {
        List<House> houses = houseServices.getHouses();
        return ResponseEntity.ok(houses);
    }

    // Get house by name
    @GetMapping("/{name}")
    public ResponseEntity<House> getHouseByName(@PathVariable String name) {
        Optional<House> house = houseServices.getHouseByName(name);
        return house.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new house
    @PostMapping
    public ResponseEntity<House> createHouse(@RequestBody House house) {
        House createdHouse = houseServices.createHouse(house);
        return ResponseEntity.ok(createdHouse);
    }

    // Update an existing house
    @PutMapping("/{name}")
    public ResponseEntity<House> updateHouse(@PathVariable String name, @RequestBody House house) {
        House updatedHouse = houseServices.updateHouse(name, house);
        return ResponseEntity.ok(updatedHouse);
    }

    // Delete a house
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteHouse(@PathVariable String name) {
        houseServices.deleteHouse(name);
        return ResponseEntity.noContent().build();
    }
}
