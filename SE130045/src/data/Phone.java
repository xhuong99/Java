/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author leehe
 */
public class Phone {
    private String id;
    private String model;
    private String camera;
    private double price;

    public Phone(String id, String model, String camera, double price) {
        this.id = id;
        this.model = model;
        this.camera = camera;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Phone{" + "id=" + id + ", model=" + model + ", camera=" + camera + ", price=" + price + '}';
    }
    
    public void showDetailed() {
        System.out.printf("|%-10s|%-15s|%-5s|%12.1f|\n", id, model, camera, price);
    }
}
