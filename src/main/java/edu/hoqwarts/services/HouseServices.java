package edu.hoqwarts.services;

import edu.hoqwarts.models.House;
import edu.hoqwarts.repositories.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseServices {

    private final HouseRepository houseRepository;

    @Autowired
    public HouseServices(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    // Create
    public House createHouse(House house) {
        return houseRepository.save(house);
    }

    // Read
    public List<House> getHouses() {
        return houseRepository.findAll();
    }

    public Optional<House> getHouseByName(String name) {
        return houseRepository.findByName(name);
    }

    // Update
    public House updateHouse(String name, House updatedHouse) {
        House house = houseRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("House not found"));

        house.setFounder(updatedHouse.getFounder());
        house.setColor1(updatedHouse.getColor1());
        house.setColor2(updatedHouse.getColor2());

        return houseRepository.save(house);
    }

    // Delete
    public void deleteHouse(String name) {
        houseRepository.deleteById(name);
    }
}
