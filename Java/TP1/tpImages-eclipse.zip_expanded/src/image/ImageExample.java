package image;

import image.Image;
import image.color.GrayColor;
import image.ImageDisplayer;
import image.ImageInterface;

public class ImageExample {

	public static void main(String[] args) {
		Image I = new Image(100, 200);
		
		int i, j;
		for(i=10; i<30; i=i+1) {
			for(j=30; j<60; j=j+1) {
				I.changeColorPixel(i,  j,  GrayColor.BLACK);
				System.out.println("okok");
		    }
	    }
		GrayColor gray64 = new GrayColor(64);
		for(i=20; i<70; i=i+1) {
			for(j=50; j<100; j=j+1) {
				I.changeColorPixel(i,  j,  gray64);
		    }
	    }
		GrayColor gray230 = new GrayColor(230);
		for(i=20; i<40; i=i+1) {
			for(j=110; j<160; j=j+1) {
				I.changeColorPixel(i,  j,  gray230);
		    }
	    }
		
		image.ImageDisplayer imdis = new ImageDisplayer();
		// imdis.display(imint, title);
		imdis.display(I, "test",100,100);
		
		image.ImageDisplayer imdis2 = new ImageDisplayer();
		Image imedges = I.edges(100);
		imdis2.display(imedges, "edges",500,100);
	}

}
