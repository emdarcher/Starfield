public static final NUM_PARTICLES = 64;

//your code here
void setup()
{
	//your code here
}
void draw()
{
	//your code here
}
class NormalParticle
{
	//your code here
	double X_pos,Y_pos,Angle_val,Speed_val;
	color P_color;
	Particle(){
		X_pos=(double)(width>>1);
		Y_pos=(double)(height>>1);
	}
	void move(){
		X_pos += Math.cos(Angle_val)*Speed_val;
		Y_pos += Math.sin(Angle_val)*Speed_val;
	}
	void show(){
		fill(P_color);
		ellipse(X_pos,Y_pos,8,8);
	}
}
interface Particle
{
	//your code here
}
class OddballParticle
{
	//your code here
}


