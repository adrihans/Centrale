package image;

import image.Image;
import image.ImageDisplayer;
import java.lang.Integer;

public class ImageMain {

	public static void main(String[] args) {
		String filepath = args[0];
		int nbGrayLevels = Integer.parseInt(args[1]);
        int nbEdges = Integer.parseInt(args[2]);
		Image I = Image.initImagePGM("/images/fruit.pgm");
		
		image.ImageDisplayer imdis = new ImageDisplayer();
		// imdis.display(imint, title);
		imdis.display(I, "test",100,100);
		
		image.ImageDisplayer imdis2 = new ImageDisplayer();
		Image imedges = I.edges(nbEdges);
		imdis2.display(imedges, "edges",500,100);
		
		image.ImageDisplayer imdis3 = new ImageDisplayer();
		Image imdecrease = I.decreaseNbGrayLevels(nbGrayLevels);
		imdis3.display(imdecrease, "decreased level of gray",1000,100);

	}

}
