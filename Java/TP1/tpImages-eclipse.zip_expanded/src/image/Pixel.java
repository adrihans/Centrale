package image;

import image.color.GrayColor;
import java.lang.Math;

public class Pixel {
	
	private GrayColor graycolor;
	
	public GrayColor getColor(){
		return this.graycolor;
	}
	public void setColor(GrayColor g) {
		this.graycolor = g;
	}
	
	// Constructeur : 
	public Pixel(int level){
		GrayColor graycolor = new GrayColor(level);
		this.graycolor = graycolor;
	}
	
	public boolean equals(Object o) {
			
			if (o instanceof Pixel) {
				// conversion de type
				Pixel that = (Pixel)o;
				return this.graycolor.equals(that.getColor());
				} else {
				return false;
				}
		}
	
	public int colorDifference(Pixel that) {
		return Math.abs(that.getColor().getLevel()- this.graycolor.getLevel());
	}
	
	
	// Pour tester :
	public static void main(String[] args){
		System.out.println("ça fonctionne");
		Pixel pixel1 = new Pixel(3);
		Pixel pixel2 = new Pixel(40);
		int d = pixel1.colorDifference(pixel2);
		System.out.println(d);
	}


	
	
}
