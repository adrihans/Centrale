package image;

import image.Image;
import image.Pixel;
import image.color.GrayColor;

import java.util.*;


public class Image implements ImageInterface {

    // Attributes
	private int Height;
	private int Width;
	public Pixel[][] tableau;
		
	// Constructor
	public Image(int n, int m) {
		int i,j;
		this.tableau = new Pixel[n][m];
		for (i=0;i<n;i=i+1) {
			for (j=0;j<m;j=j+1) {
				this.tableau[i][j]= new image.Pixel(255);
			}
		}
		this.Width=n;
		this.Height=m;
	}
	
	// Getters and Setters
	public int getWidth() {
		return this.Width;
	}
	public int getHeight() {
		return this.Height;
	}
	public Pixel getPixel(int x, int y) {
		return this.tableau[x][y];		
	}
	public void setPixel(int x, int y, Pixel p) {
		this.tableau[x][y]=p;
	}
	
	//Methods
	public void changeColorPixel(int x, int y, GrayColor color) {
		this.tableau[x][y].setColor(color);
	}
	
    public Image edges(int threshold) {
    	Image imageEdges = new Image(this.Width-1, this.Height-1);
    	int i, j;
    	for(i=0; i<this.Width-1; i = i+1) {
    		for(j=0; j<this.Height-1; j = j+1) {
    			int below = this.getPixel(i,j).colorDifference(this.getPixel(i,j+1));
    			int right = this.getPixel(i,j).colorDifference(this.getPixel(i+1,j));
    			if ((below > threshold) || (right > threshold)) {
    				imageEdges.changeColorPixel(i, j, image.color.GrayColor.BLACK);
    			} else {
    				imageEdges.changeColorPixel(i, j, image.color.GrayColor.WHITE);
    			}
    		}
    	}
    	return imageEdges;
    	
    	
    }

 
    public Image decreaseNbGrayLevels(int nbGrayLevels) {
    	Image imageDecreased = new Image(this.Width, this.Height);
    	int i, j;
    	int interval = java.lang.Math.floorDiv(255, nbGrayLevels);
    	for(i=0; i<this.Width; i = i+1) {
    		for(j=0; j<this.Height; j = j+1) {
    			int color = this.getPixel(i,j).getColor().getLevel();
    			color = color - (color % interval);
    			imageDecreased.setPixel(i, j, new Pixel(color));
    		}
    	}
    	return imageDecreased;
    	
    }
    
    
    
    
    
    
    
    
    // ======================================================================
    /** Reads a PGM image from file.
     * It is assumed that file respects the following PGM file syntax:
     *  <ul><li> first line with string "P2"</li>
     *  <li>second line : a comment</li> 
     *  <li>one int for width <code>w</code>, one int for height<code>h</code></li>
     *  <li>one int for max gray level (not used here, we consider this level to be 255 in our images)</li>
     *  <li><code>w</code> x <code>h</code> integers between 0 and max (for us max=255) for each pixel</li></ul>
     *  
     * @param fileName the name of the image file in PGM format
     * @return the image built from the file
     */
    public static Image initImagePGM(String fileName) {
        Scanner scan = new Scanner(Image.class.getResourceAsStream(fileName));

        scan.nextLine(); // line P2
        scan.nextLine(); // line comment
        // read width
        int width = scan.nextInt();
        // read height        
        int height = scan.nextInt();
        // read max gray level (not used)
        scan.nextInt(); 
        // create an initially white image
        Image result = new Image(width, height); 
        // rad pixels
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                result.changeColorPixel(y, x, new GrayColor(scan.nextInt()));
            }
        }
        return result;
    }

    
    

}
