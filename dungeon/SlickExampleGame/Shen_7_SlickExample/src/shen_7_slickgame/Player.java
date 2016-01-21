package shen_7_slickgame;

import org.newdawn.slick.Animation;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ShadowX
 */
public class Player {

	public static float x = 49f;

	public static float y = 86f;

	public static int time = 350000;
	
	public static float speed = .4f;
        
        public static int health = 100;

	static float hitboxX = x + 4f;

	static float hitboxY = y + 4f;

	private static int startX, startY, width = 30, height = 42;

	public static Shape rect = new Rectangle(getplayershitboxX(),
			getplayershitboxY(), width, height);

	public static float pdelta;

	public static Animation playeranime;

	public static void setpdelta(float somenum) {

		pdelta = somenum;

	}

	public static float getpdelta() {

		return pdelta;

	}

	public static float getplayersX() {

		return x;

	}

	public static float getplayersY() {

		return y;

	}

	public static float getplayershitboxX() {

		return x + 18f;

	}

	public static float getplayershitboxY() {

		return y + 18f;

	}

	public static void setplayershitboxX() {

		hitboxX = getplayershitboxX();

	}

	public static void setplayershitboxY() {

		hitboxY = getplayershitboxY();

	}

}
