import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Starfield extends PApplet {

public static final int NUM_PARTICLES = 64;
//NormalParticle party;
Particle [] parties;
//your code here
public void setup()
{
    //your code here
    size(255,255);
    init_parties();

    frameRate(10);
    //party = new NormalParticle();
}
public void draw()
{
    background(128);
    //your code here
    for(int i = parties.length-1;i>=0;i--){
        parties[i].move();
        parties[i].show();
    }
}
class NormalParticle implements Particle
{
    //your code here
    protected double X_pos,Y_pos,Angle_val,Speed_val;
    protected int P_color;
    NormalParticle(){
        X_pos=(double)(width>>1);
        Y_pos=(double)(height>>1);
        Angle_val = Math.random()*(Math.PI*2);
        Speed_val = 10;
    }
    public void move(){
        X_pos += Math.cos(Angle_val)*Speed_val;
        Y_pos += Math.sin(Angle_val)*Speed_val;
    }
    public void show(){
        fill(P_color);
        ellipse((int)X_pos,(int)Y_pos,8,8);
    }
}
interface Particle
{
    //your code here
    public void move();
    public void show();
}
class OddballParticle implements Particle
{
    //your code here
    //your code here
    private double X_pos,Y_pos,Angle_val,Speed_val;
    private int P_color;
    int offset_val;
    OddballParticle(){
        X_pos=(double)(width>>1);
        Y_pos=(double)(height>>1);
        Angle_val = Math.random()*(Math.PI*2);
        Speed_val = 10;
        P_color = 0xff429839;
        offset_val = 16;
    }
    public void move(){
        X_pos += (Math.cos(Angle_val)*Speed_val)+(Math.random()*offset_val);
        Y_pos += (Math.sin(Angle_val)*Speed_val)+(Math.random()*offset_val);
    }
    public void show(){
        fill(P_color);
        ellipse((int)X_pos,(int)Y_pos,10,10);
    }
}
class Jumbo extends NormalParticle {
    public void show(){
        fill(255);
        ellipse((int)X_pos,(int)Y_pos,32,32);
    }

}
public void mousePressed(){
    background(128);
    init_parties();
    redraw();
}
public void init_parties(){
    parties = new Particle[NUM_PARTICLES];
    parties[0] = new OddballParticle();
    parties[1] = new Jumbo();
    for(int i = 2;i<parties.length;i++){
        parties[i] = new NormalParticle();
    }
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Starfield" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
