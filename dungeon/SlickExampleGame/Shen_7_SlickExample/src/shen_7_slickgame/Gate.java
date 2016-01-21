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
public class Gate {
        public int x;
	public int y;
	public boolean isvisible = true;
	Image currentImage;
	Shape hitbox;
	Image door = new Image("res/MyDungeon/crawl-tiles Oct-5-2010/dc-dngn/gateways/dngn_enter_gehenna.png");

	Gate(int a, int b) throws SlickException {
		this.x = a;
		this.y = b;
		this.hitbox = new Rectangle(a, b, 32, 32);// 32 is the width of the item
		this.currentImage = door;

	}
}
