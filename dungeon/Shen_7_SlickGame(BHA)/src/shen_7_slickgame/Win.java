/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shen_7_slickgame;


import org.newdawn.slick.Color;


import org.newdawn.slick.Game;


import org.newdawn.slick.GameContainer;


import org.newdawn.slick.Graphics;


import org.newdawn.slick.Input;


import org.newdawn.slick.SlickException;


import org.newdawn.slick.state.BasicGameState;


import org.newdawn.slick.state.StateBasedGame;


import org.newdawn.slick.state.transition.FadeInTransition;


import org.newdawn.slick.state.transition.FadeOutTransition;



public class Win extends BasicGameState {


    


    private StateBasedGame game;


    


     public Win(int xSize, int ySize) {



    }



    


    public void init(GameContainer container, StateBasedGame game)


            throws SlickException {


        this.game = game;



// TODO AutoÃ¢â‚¬Âgenerated method stub


    }



   


    public void render(GameContainer container, StateBasedGame game, Graphics g)


            throws SlickException {


// TODO AutoÃ¢â‚¬Âgenerated method stub


        g.setColor(Color.white);


        g.drawString("You found the ring in time!", 380, 200);
        g.drawString("Press 1 to play again", 400, 320);


       


    }



    


    public void update(GameContainer container, StateBasedGame game, int delta)


            throws SlickException {


// TODO AutoÃ¢â‚¬Âgenerated method stub


    }



  


    public int getID() {


// TODO AutoÃ¢â‚¬Âgenerated method stub


        return 3;


    }



    @Override


    public void keyReleased(int key, char c) {


        switch (key) {


            case Input.KEY_1:

                Player.time  = 350000;
                Player.speed = .4f;
                Player.health = 100;
                BarbarianHorde.counter = 0;
                Itemwin.isvisible = true;
                Player.x = 49f;
                Player.y = 86f;
                BarbarianHorde.SandBoss.isVisible = true;
                BarbarianHorde.Boss.isVisible = true;
                BarbarianHorde.Boss2.isVisible = true;
                BarbarianHorde.MetalBoss.isVisible = true;
                BarbarianHorde.key1.isvisible = true;
                BarbarianHorde.gate1.isvisible = true;
                BarbarianHorde.gate2.isvisible = true;
                BarbarianHorde.hasKey = false;
                
                //item.isvisible = true;
                //item1.isvisible = true;
                Itemwin.isvisible = true;
                game.enterState(1, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));


                break;


            case Input.KEY_2:


// TODO: Implement later


                break;


            case Input.KEY_3:


// TODO: Implement later


                break;


            default:


                break;


        }


    }


}
