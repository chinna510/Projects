package com.DAO;

import java.util.HashMap;
import java.util.Map;

import com.pojo.Animal;

public enum AnimalDao {
	instance;

	private Map<String, Animal> animals = new HashMap<String, Animal>();

	private AnimalDao() {

		//pumping-in some default data
		Animal animal = new Animal("1", "Lion", "Wild");
		animals.put("1", animal);
		animal = new Animal("2", "Crocodile", "Wild");
		animals.put("2", animal);

	}

	public Map<String, Animal> getAnimals() {
		return animals;
	}

}