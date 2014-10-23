public static final int NUM_PARTICLES = 64;
NormalParticle party;
Particle [] parties;
//your code here
void setup()
{
	//your code here
	size(255,255);
	parties = new Particle[NUM_PARTICLES];
	parties[0] = new OddballParticle();
	for(int i = 1;i<parties.length;i++){
		parties[i] = new NormalParticle();
	}
	party = new NormalParticle();
}
void draw()
{
	//your code here
	for(int i = 0;i<parties.length;i++){
		parties[i].show();
		parties[i].move();
	}
}
class NormalParticle implements Particle
{
	//your code here
	private double X_pos,Y_pos,Angle_val,Speed_val;
	private color P_color;
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
	private color P_color;
	OddballParticle(){
		X_pos=(double)(width>>1);
		Y_pos=(double)(height>>1);
		Angle_val = Math.random()*(Math.PI*2);
		Speed_val = 10;
		P_color = #429839;
	}
	public void move(){
		X_pos += (Math.cos(Angle_val)*Speed_val)+(Math.random()*8);
		Y_pos += (Math.sin(Angle_val)*Speed_val)+(Math.random()*8);
	}
	public void show(){
		fill(P_color);
		ellipse((int)X_pos,(int)Y_pos,10,10);
	}
}
void mousePressed(){
	redraw();
}

