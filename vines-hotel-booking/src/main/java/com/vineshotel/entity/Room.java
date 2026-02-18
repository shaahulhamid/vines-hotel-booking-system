package com.vineshotel.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;        // Premium Room
    private String description;  // King size bed, Balcony view
    private double pricePerNight;

    private int adults;
    private int children;

    // Constructors
    public Room() {}

    public Room(String title, String description, double pricePerNight, int adults, int children) {
        this.title = title;
        this.description = description;
        this.pricePerNight = pricePerNight;
        this.adults = adults;
        this.children = children;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPricePerNight() { return pricePerNight; }
    public void setPricePerNight(double pricePerNight) { this.pricePerNight = pricePerNight; }

    public int getAdults() { return adults; }
    public void setAdults(int adults) { this.adults = adults; }

    public int getChildren() { return children; }
    public void setChildren(int children) { this.children = children; }
}
