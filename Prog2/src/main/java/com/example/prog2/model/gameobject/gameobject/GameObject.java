package com.example.prog2.model.gameobject.gameobject;

public abstract class GameObject {
    // Basic properties that every game object might have
    private String name;

    // Abstract methods that every game object must implement
    public abstract void update();
    public abstract void render();

    // Constructors
    public GameObject(String name) {
        this.name = name;
    }

    // Getter and Setter for name property
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
