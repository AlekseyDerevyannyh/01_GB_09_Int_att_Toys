package model;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private Mapper mapper = new Mapper();
    private FileOperation fileOperation;

    public Repository(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }

    public List<Toy> getAllToys() {
        List<String> lines = fileOperation.readAllLines();
        List<Toy> toys = new ArrayList<>();
        for (String line : lines) {
            toys.add(mapper.map(line));
        }
        return toys;
    }

    private Integer getMaxId(List<Toy> toys) {
        int Id = 0;
        for (Toy toy : toys) {
            if (Integer.parseInt(toy.getId()) > Id) {
                Id = Integer.parseInt(toy.getId());
            }
        }
        return Id;
    }

    private void saveToys(List<Toy> toys) {
        List<String> lines = new ArrayList<>();
        for (Toy toy : toys) {
            lines.add(mapper.map(toy));
        }
        fileOperation.saveAllLines(lines);
    }

    private void saveToy(Toy toy, List<Toy> toys) {
        toys.add(toy);
        saveToys(toys);
    }

    public String CreateToy(Toy toy) {
        List<Toy> toys = getAllToys();
        int newId = getMaxId(toys);
        newId ++;
        String Id = String.format("%d", newId);
        toy.setId(Id);
        saveToy(toy, toys);
        return Id;
    }

    private Toy findToy(String toyId, List<Toy> toys) {
        for (Toy toy : toys) {
            if (toy.getId().equals(toyId)) {
                return toy;
            }
        }
        throw new IllegalStateException("Toy not found!");
    }

    public void deleteToy(String toyId) {
        List<Toy> toys = getAllToys();
        toys.remove(findToy(toyId, toys));
        saveToys(toys);
    }

    public void updateToy(Toy toy) {
        deleteToy(toy.getId());
        List<Toy> toys = getAllToys();
        saveToy(toy, toys);
    }
}
