/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shen_7_slickgame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author ShadowX
 */
public class Orb {
        private int locationX; 
	private int locationY;
        private int size;
        private boolean isVisible;
	Image orb;
        public Orb(int x, int y) {
            this.isVisible = false;
            this.locationX = x;
            this.locationY = y;
        }
        /**
         * Getters and setters are a common concept in Java.
         * A design guideline in Java, and object oriented programming in 
         * general, is to encapsulate/isolate values as much as possible.
         * Getters - are methods used to query the value of instance variables.
         * this.getLocationX();
         * Setters - methods that set values for instance variables
         * this.setLocationX(45)
         */
}