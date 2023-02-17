package controller;

import model.Repository;
import model.Toy;

import java.util.List;

public class Controller {
    private final Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    public void validateToyData(Toy toy) {
        if (toy.getName().isEmpty()) {
            throw new IllegalStateException("Fields are empty!");
        }
    }

    public void saveToy(Toy toy) {
        validateToyData(toy);
        repository.createToy(toy);
    }

    public Toy readToy(String toyId) throws Exception {
        List<Toy> toys = repository.getAllToys();
        for (Toy toy : toys) {
            if (toy.getId().equals(toyId)) {
                return toy;
            }
        }
        throw new Exception("Toy not found!");
    }

    public void editToy(Toy toy) {
        validateToyData(toy);
        repository.updateToy(toy);
    }
}
