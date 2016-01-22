package shen_7_slickgame;

import org.newdawn.slick.state.*;

import java.io.IOException;

import java.util.ArrayList;

import java.util.Iterator;

import java.util.logging.Level;

import java.util.logging.Logger;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;

import org.newdawn.slick.AppGameContainer;

import org.newdawn.slick.BasicGame;

import org.newdawn.slick.Font;

import org.newdawn.slick.GameContainer;

import org.newdawn.slick.Graphics;

import org.newdawn.slick.Image;

import org.newdawn.slick.Input;

import org.newdawn.slick.SlickException;

import org.newdawn.slick.SpriteSheet;

import org.newdawn.slick.TrueTypeFont;

import org.newdawn.slick.geom.Rectangle;

import org.newdawn.slick.geom.Shape;

import org.newdawn.slick.state.BasicGameState;

import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import org.newdawn.slick.tiled.TiledMap;
import org.w3c.dom.css.Rect;

public class BarbarianHorde extends BasicGameState {

	
//	public Item healthpotion, healthpotion1;
//	public Item1 speedpotion, speedpotion1;
	public FinalRing ring;
        
//        public Ninja stormy, daniel;
        
        static public Keys key1;
        
        static public Enemy MetalBoss, SandBoss, Boss, Boss2;

        static public Gate gate1, gate2;
        
//	public ArrayList<Item> stuff = new ArrayList();

//	public ArrayList<Item1> stuff1 = new ArrayList();
	
	public ArrayList<FinalRing> stuffwin = new ArrayList();

//        public ArrayList<Ninja> dojo = new ArrayList();
        
        public ArrayList<Gate> gates = new ArrayList();
        
        public ArrayList<Keys> keyz = new ArrayList();
        
        public ArrayList<Enemy> bosses = new ArrayList();
        
	private boolean[][] hostiles;

	private static TiledMap grassMap;

	private static AppGameContainer app;

	private static Camera camera;
	
	public static int counter = 0;

        static boolean hasKey;
	// Player stuff

	private Animation sprite, up, down, left, right, wait;

	/**
	 * 
	 * The collision map indicating which tiles block movement - generated based
	 * 
	 * on tile properties
	 */

	// changed to match size of sprites & map

	private static final int SIZE = 32;

	// screen width and height won't change

	private static final int SCREEN_WIDTH = 1000;

	private static final int SCREEN_HEIGHT = 750;

	public BarbarianHorde(int xSize, int ySize) {

	}

	public void init(GameContainer gc, StateBasedGame sbg)

	throws SlickException {
		
		 gc.setTargetFrameRate(60);

		gc.setShowFPS(false);

		// *******************

		// Scenerey Stuff

		// ****************

		grassMap = new TiledMap("res/MyDungeon/mydungeon.tmx");

		// Ongoing checks are useful

		System.out.println("Tile map is this wide: " + grassMap.getWidth());

		camera = new Camera(gc, grassMap);

		// *********************************************************************************

		// Player stuff --- these things should probably be chunked into methods
		// and classes

		// *********************************************************************************

		SpriteSheet runningSS = new SpriteSheet("res/MyDungeon/travelersmall.png",32, 32, 0);

		// System.out.println("Horizontal count: "
		// +runningSS.getHorizontalCount());

		// System.out.println("Vertical count: " +runningSS.getVerticalCount());

		up = new Animation();

		up.setAutoUpdate(true);

		up.addFrame(runningSS.getSprite(0, 8), 330);

		up.addFrame(runningSS.getSprite(1, 8), 330);

		up.addFrame(runningSS.getSprite(2, 8), 330);

		up.addFrame(runningSS.getSprite(3, 8), 330);

		up.addFrame(runningSS.getSprite(4, 8), 330);

		up.addFrame(runningSS.getSprite(5, 8), 330);

		up.addFrame(runningSS.getSprite(6, 8), 330);

		up.addFrame(runningSS.getSprite(7, 8), 330);

		up.addFrame(runningSS.getSprite(8, 8), 330);

		down = new Animation();

		down.setAutoUpdate(false);

		down.addFrame(runningSS.getSprite(0, 10), 330);

		down.addFrame(runningSS.getSprite(1, 10), 330);

		down.addFrame(runningSS.getSprite(2, 10), 330);

		down.addFrame(runningSS.getSprite(3, 10), 330);

		down.addFrame(runningSS.getSprite(4, 10), 330);

		down.addFrame(runningSS.getSprite(5, 10), 330);

		down.addFrame(runningSS.getSprite(6, 10), 330);

		down.addFrame(runningSS.getSprite(7, 10), 330);

		down.addFrame(runningSS.getSprite(8, 10), 330);

		left = new Animation();

		left.setAutoUpdate(false);

		left.addFrame(runningSS.getSprite(0, 9), 330);

		left.addFrame(runningSS.getSprite(1, 9), 330);

		left.addFrame(runningSS.getSprite(2, 9), 330);

		left.addFrame(runningSS.getSprite(3, 9), 330);

		left.addFrame(runningSS.getSprite(4, 9), 330);

		left.addFrame(runningSS.getSprite(5, 9), 330);

		left.addFrame(runningSS.getSprite(6, 9), 330);

		left.addFrame(runningSS.getSprite(7, 9), 330);

		left.addFrame(runningSS.getSprite(8, 9), 330);

		right = new Animation();

		right.setAutoUpdate(false);

		right.addFrame(runningSS.getSprite(0, 11), 330);

		right.addFrame(runningSS.getSprite(1, 11), 330);

		right.addFrame(runningSS.getSprite(2, 11), 330);

		right.addFrame(runningSS.getSprite(3, 11), 330);

		right.addFrame(runningSS.getSprite(4, 11), 330);

		right.addFrame(runningSS.getSprite(5, 11), 330);

		right.addFrame(runningSS.getSprite(6, 11), 330);

		right.addFrame(runningSS.getSprite(7, 11), 330);

		right.addFrame(runningSS.getSprite(8, 11), 330);

		wait = new Animation();

		wait.setAutoUpdate(true);

		wait.addFrame(runningSS.getSprite(0, 14), 733);

		wait.addFrame(runningSS.getSprite(1, 14), 733);

		wait.addFrame(runningSS.getSprite(2, 14), 733);

		wait.addFrame(runningSS.getSprite(3, 14), 733);

		// wait.addFrame(runningSS.getSprite(2, 14), 733);

		// wait.addFrame(runningSS.getSprite(5, 14), 333);

		sprite = wait;

		// *****************************************************************

		// Obstacles etc.

		// build a collision map based on tile properties in the TileD map

		Blocked.blocked = new boolean[grassMap.getWidth()][grassMap.getHeight()];

		// System.out.println("Map height:" + grassMap.getHeight());

		// System.out.println("Map width:" + grassMap.getWidth());

		// There can be more than 1 layer. You'll check whatever layer has the
		// obstacles.

		// You could also use this for planning traps, etc.

		// System.out.println("Number of tile layers: "
		// +grassMap.getLayerCount());

		System.out.println("The grassmap is " + grassMap.getWidth() + "by "
				+ grassMap.getHeight());

		for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {

			for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {

				// int tileID = grassMap.getTileId(xAxis, yAxis, 0);

				// Why was this changed?

				// It's a Different Layer.

				// You should read the TMX file. It's xml, i.e.,human-readable
				// for a reason

				int tileID = grassMap.getTileId(xAxis, yAxis, 1);

				String value = grassMap.getTileProperty(tileID,"blocked", "false");

				if ("true".equals(value)) {

					System.out.println("The tile at x " + xAxis + " and y axis " + yAxis + " is blocked.");

					Blocked.blocked[xAxis][yAxis] = true;

				}

			}

		}

		System.out.println("Array length" + Blocked.blocked[0].length);

		// A remarkably similar process for finding hostiles

		hostiles = new boolean[grassMap.getWidth()][grassMap.getHeight()];

//		for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
//			for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
//				int xBlock = (int) xAxis;
//				int yBlock = (int) yAxis;
//				if (!Blocked.blocked[xBlock][yBlock]) {
//					if (yBlock % 7 == 0 && xBlock % 15 == 0 ) {
//						Item i = new Item(xAxis * SIZE, yAxis * SIZE);
//						stuff.add(i);
//						//stuff1.add(h);
//						hostiles[xAxis][yAxis] = true;
//					}
//				}
//			}
//		}
		
//		for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
//			for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
//				int xBlock = (int) xAxis;
//				int yBlock = (int) yAxis;
//				if (!Blocked.blocked[xBlock][yBlock]) {
//					if (xBlock % 9 == 0	&& yBlock % 25 == 0) {
//						Item1 h = new Item1(xAxis * SIZE, yAxis * SIZE);
//					//	stuff.add(i);
//						stuff1.add(h);
//						hostiles[xAxis][yAxis] = true;
//					}
//				}
//			}
//		}

//		healthpotion = new Item(100, 100);
//		healthpotion1 = new Item(450, 400);
//		stuff.add(healthpotion);
//		stuff.add(healthpotion1);
		
//		speedpotion = new Item1(100,150);
//		speedpotion1 = new Item1(450,100);	
//		stuff1.add(speedpotion);
//		stuff1.add(speedpotion1);
		
//                stormy = new Ninja(0,0);
//                daniel = new Ninja(124,254);
//                dojo.add(stormy);
//                dojo.add(daniel);
                
                gate1 = new Gate(1600,1950);
                gate2 = new Gate(1632,1950);
                gates.add(gate1);
                gates.add(gate2);
                
                key1 = new Keys(3082,1489);
                keyz.add(key1);
                
                MetalBoss = new Enemy(2944,1400);
                SandBoss = new Enemy(1597,2199);
                Boss = new Enemy (2800,2135);
                Boss2 = new Enemy (2039, 1500);
                bosses.add(MetalBoss);
                bosses.add(SandBoss);
                bosses.add(Boss);
                bosses.add(Boss2);
                
		ring = new FinalRing(1615, 3133);
		stuffwin.add(ring);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)

	throws SlickException {

		camera.centerOn((int) Player.x, (int) Player.y);

		camera.drawMap();

		camera.translateGraphics();

		// it helps to add status reports to see what's going on

		// but it gets old quickly

//		System.out.println("Current X: " + Player.x + " \n Current Y: "+ Player.y);

		sprite.draw((int) Player.x, (int) Player.y);
		
//		g.drawString("x: " + (int)Player.x + "y: " +(int)Player.y , Player.x, Player.y - 10);

		g.drawString("Time Left: " + Player.time/1000, camera.cameraX + 10,
				camera.cameraY + 10);
		
		g.drawString("Health: " + (int)(Player.health), camera.cameraX + 10,
				camera.cameraY + 25);

		//g.draw(player.rect);

//		g.drawString("time passed: " +counter/1000, camera.cameraX +600,camera.cameraY );
		// moveenemies();

//		for (Item i : stuff) {
//			if (i.isvisible) {
//				i.currentImage.draw(i.x, i.y);
//				// draw the hitbox
//				//g.draw(i.hitbox);
//
//			}
//		}
		
//		for (Ninja n : dojo) {
//			if (n.isvisible) {
//				n.currentImage.draw(n.x, n.y);
//				// draw the hitbox
//				g.draw(n.hitbox);
//
//			}
//		}
                for (Gate d : gates) {
			if (d.isvisible) {
				d.currentImage.draw(d.x, d.y);
				// draw the hitbox
//				d.draw(d.hitbox);

			}
		}
                
                for (Keys k : keyz) {
			if (k.isvisible) {
				k.currentImage.draw(k.x, k.y);
				// draw the hitbox
//				d.draw(d.hitbox);

			}
		}
                
                for (Enemy r : bosses) {
                    r.move();
                }
                
		for (Enemy e : bosses) {
			if (e.isVisible) {
				e.currentanime.draw(e.Bx, e.By);
				// draw the hitbox
				//g.draw(e.hitbox);

			}
		}
                
//                stormy.currentImage.draw(stormy.x, stormy.y);
//                daniel.currentImage.draw(daniel.x, daniel.y);
                
//		for (Item1 h : stuff1) {
//			if (h.isvisible) {
//				h.currentImage.draw(h.x, h.y);
//				// draw the hitbox
//				//g.draw(h.hitbox);
//
//			}
//		}
                
		for (FinalRing w: stuffwin) {
			if (w.isvisible) {
				w.currentImage.draw(w.x, w.y);
				// draw the hitbox
				//g.draw(w.hitbox);

			}
		}

	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)

	throws SlickException {
		
		counter += delta;

		Input input = gc.getInput();

		float fdelta = delta * Player.speed;

		Player.setpdelta(fdelta);

		double rightlimit = (grassMap.getWidth() * SIZE) - (SIZE * 0.75);

		// System.out.println("Right limit: " + rightlimit);

		float projectedright = Player.x + fdelta + SIZE;

		boolean cangoright = projectedright < rightlimit;

		// there are two types of fixes. A kludge and a hack. This is a kludge.

		if (input.isKeyDown(Input.KEY_UP)) {

			sprite = up;

			float fdsc = (float) (fdelta - (SIZE * .15));

			if (!(isBlocked(Player.x, Player.y - fdelta) || isBlocked((float) (Player.x + SIZE + 1.5), Player.y - fdelta))) {

				sprite.update(delta);

				// The lower the delta the slower the sprite will animate.

				Player.y -= fdelta;

			}

		} else if (input.isKeyDown(Input.KEY_DOWN)) {

			sprite = down;

			if (!isBlocked(Player.x, Player.y + SIZE + fdelta) && !isBlocked(Player.x + SIZE - 1, Player.y + SIZE + fdelta)) {

				sprite.update(delta);

				Player.y += fdelta;

			}

		} else if (input.isKeyDown(Input.KEY_LEFT)) {

			sprite = left;

			if (!(isBlocked(Player.x - fdelta, Player.y) || isBlocked(Player.x - fdelta, Player.y + SIZE - 1))) {

				sprite.update(delta);

				Player.x -= fdelta;

			}

		} else if (input.isKeyDown(Input.KEY_RIGHT)) {

			sprite = right;

			// the boolean-kludge-implementation

			if (cangoright
					&& (!(isBlocked(Player.x + SIZE + fdelta,

					Player.y) || isBlocked(Player.x + SIZE + fdelta, Player.y + SIZE - 1)))) {

				sprite.update(delta);

				Player.x += fdelta;

			} // else { System.out.println("Right limit reached: " +
				// rightlimit);}

		}

		Player.rect.setLocation(Player.getplayershitboxX(),
		Player.getplayershitboxY());

//		for (Item i : stuff) {
//
//			if (Player.rect.intersects(i.hitbox)) {
//				//System.out.println("yay");
//				if (i.isvisible) {
//
//					Player.time += 10000;
//					i.isvisible = false;
//				}
//
//			}
//		}
		
//		for (Ninja n : dojo) {
//
//			if (Player.rect.intersects(n.hitbox)) {
//				//System.out.println("yay");
//				if (n.isvisible) {
//
//					Player.time += 100;
//                                        Player.speed += .1f;
//					n.isvisible = false;
//				}
//
//			}
//		}
                
//		for (Item1 h : stuff1) {
//
//			if (Player.rect.intersects(h.hitbox)) {
//				//System.out.println("yay");
//				if (h.isvisible) {
//
//					Player.speed += .1f;
//					h.isvisible = false;
//				}
//
//			}
//		}
                
                for (Keys k : keyz) {

			if (Player.rect.intersects(k.hitbox)) {
				//System.out.println("yay");
				if (k.isvisible) {

					hasKey = true;
					k.isvisible = false;
				}

			}
		}
                
                for (Gate d : gates) {

			if (Player.rect.intersects(d.hitbox)) {
				//System.out.println("yay");
				if (d.isvisible && hasKey == true) {

					d.isvisible = false;
				}
                                if (d.isvisible && hasKey == false) {
                                    Player.y -= 10;
                                }

			}
		}
		
                for (Enemy e : bosses) {

			if (Player.rect.intersects(e.rect)) {
				//System.out.println("yay");
				if (e.isVisible) {

					Player.health -= 34;
					e.isVisible = false;
				}

			}
		}
                
		for (FinalRing w : stuffwin) {

			if (Player.rect.intersects(w.hitbox)) {
				//System.out.println("yay");
				if (w.isvisible) {
					w.isvisible = false;
					makevisible();
					sbg.enterState(3, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
					
				}

			}
		}
		 
		Player.time -= counter/1000;
		if(Player.time <= 0 || Player.health <= 0){
			makevisible();
			sbg.enterState(2, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
		}

	}

	public int getID() {

		return 1;

	}

	public void makevisible(){
//		for (Item1 h : stuff1) {
//			
//		h.isvisible = true;}
		
//		for (Item i : stuff) {
//			
//			i.isvisible = true;}
//                for (Ninja n : dojo) {
//                    n.isvisible = true;
//                }
        }
	
	private boolean isBlocked(float tx, float ty) {

		int xBlock = (int) tx / SIZE;

		int yBlock = (int) ty / SIZE;

		return Blocked.blocked[xBlock][yBlock];

		// this could make a better kludge

	}

}
