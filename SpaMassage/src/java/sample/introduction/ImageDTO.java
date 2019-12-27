/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.introduction;

import java.io.Serializable;

/**
 *
 * @author leehe
 */
public class ImageDTO implements Serializable{
    private int id;
    private String img;

    public ImageDTO(int id, String img) {
        this.id = id;
        this.img = img;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the img
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(String img) {
        this.img = img;
    }
    
    
}
