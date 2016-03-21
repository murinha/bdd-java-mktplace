package util;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.imageio.ImageIO;

public class EvidenceSteps {
	
	private String basePath;
	private Component comp;
	private File file; 
	
	public EvidenceSteps(String _basePath){
		this.basePath = _basePath;
		this.file = new File(this.basePath);
		this.file.mkdir();
	}
	
	public void takeAPrint(String stepPath, String stepScreen) throws Exception{
		
		Robot robot = new Robot();
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage capture = robot.createScreenCapture(screenRect);
		this.file = new File(this.basePath+stepPath+"/");
		this.file.mkdir();
		
		ImageIO.write(capture,"png",new File(this.basePath+stepPath+"/"+stepScreen+".png"));

	}
}
