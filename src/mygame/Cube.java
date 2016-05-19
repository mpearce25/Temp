package mygame;


import java.util.ArrayList;
import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Quad;
import com.sun.prism.paint.Color;
import java.awt.color.*;
public class Cube{

	private Material white;
	private Material green;
	private Material red;
	private Material orange;
	private Material blue;
	private Material yellow;
	
	private ArrayList<Geometry> topFace = new ArrayList<Geometry>();
	private ArrayList<Geometry> frontFace = new ArrayList<Geometry>();
	private ArrayList<Geometry> leftFace = new ArrayList<Geometry>();
	private ArrayList<Geometry> backFace = new ArrayList<Geometry>();
	private ArrayList<Geometry> rightFace = new ArrayList<Geometry>();
	private ArrayList<Geometry> bottomFace = new ArrayList<Geometry>();
	
	public Cube(Vector3f cubeCenter, AssetManager assetManager){
		
		initMaterials(assetManager);
		initFaces();
		
		Geometry mouseRect = new Geometry("MouseRect", new Quad(10, 10));
	    mouseRect.setMaterial(green);
	    new Geometry();
	}

	private void initMaterials(AssetManager assetManager){
		white = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		white.setColor("Color", ColorRGBA.White);
		
		green = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		green.setColor("Color", ColorRGBA.Green);
		
		red = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		red.setColor("Color", ColorRGBA.Red);
		
		orange = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		orange.setColor("Color", ColorRGBA.Orange);
		
		blue = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		blue.setColor("Color", convertToColorRGBA(20,100,227,0));
		
		yellow = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		yellow.setColor("Color", ColorRGBA.Yellow);
	}
	
	private void initFaces(){
		//top face - white
		Quaternion topFaceRotation = new Quaternion().fromAngles(-90 * FastMath.DEG_TO_RAD, 0, 0);
		ArrayList<Vector3f> topFaceOffSets = new ArrayList<Vector3f>();
		topFaceOffSets.add(new Vector3f(2,2,2));
		topFaceOffSets.add(new Vector3f(0,2,2));
		topFaceOffSets.add(new Vector3f(-2,2,2));
		
		topFaceOffSets.add(new Vector3f(2,2,0));
		topFaceOffSets.add(new Vector3f(0,2,0));
		topFaceOffSets.add(new Vector3f(-2,2,0));
		
		topFaceOffSets.add(new Vector3f(2,2,-2));
		topFaceOffSets.add(new Vector3f(0,2,-2));
		topFaceOffSets.add(new Vector3f(-2,2,-2));
		for (int i = 0; i < 9; i++){
			Geometry tempGeo = new Geometry("Rect", new Quad(2,2));
			tempGeo.setMaterial(white);
			tempGeo.setLocalTranslation(topFaceOffSets.get(i));
			tempGeo.setLocalRotation(topFaceRotation);
			topFace.add(tempGeo);
		}
		//front face - red
		Quaternion frontFaceRotation = new Quaternion().fromAngles(0,0,-90 * FastMath.DEG_TO_RAD);
		ArrayList<Vector3f> frontFaceOffSets = new ArrayList<Vector3f>();
		frontFaceOffSets.add(new Vector3f(2,2,2));
		frontFaceOffSets.add(new Vector3f(0,2,2));
		frontFaceOffSets.add(new Vector3f(-2,2,2));
		
		frontFaceOffSets.add(new Vector3f(2,0,2));
		frontFaceOffSets.add(new Vector3f(0,0,2));
		frontFaceOffSets.add(new Vector3f(-2,0,2));
		
		frontFaceOffSets.add(new Vector3f(2,-2,2));
		frontFaceOffSets.add(new Vector3f(0,-2,2));
		frontFaceOffSets.add(new Vector3f(-2,-2,2));
		for (int i = 0; i < 9; i++){
			Geometry tempGeo = new Geometry("Rect", new Quad(2,2));
			tempGeo.setMaterial(red);
			tempGeo.setLocalTranslation(frontFaceOffSets.get(i));
			tempGeo.setLocalRotation(frontFaceRotation);
			frontFace.add(tempGeo);
		}
		//left face - green
				Quaternion leftFaceRotation = new Quaternion().fromAngles(0,-90 * FastMath.DEG_TO_RAD,0);
				ArrayList<Vector3f> leftFaceOffSets = new ArrayList<Vector3f>();
				leftFaceOffSets.add(new Vector3f(-2,0,0));
				leftFaceOffSets.add(new Vector3f(-2,0,-2));
				leftFaceOffSets.add(new Vector3f(-2,0,-4));
				
				leftFaceOffSets.add(new Vector3f(-2,-2,0));
				leftFaceOffSets.add(new Vector3f(-2,-2,-2));
				leftFaceOffSets.add(new Vector3f(-2,-2,-4));
				
				leftFaceOffSets.add(new Vector3f(-2,-4,0));
				leftFaceOffSets.add(new Vector3f(-2,-4,-2));
				leftFaceOffSets.add(new Vector3f(-2,-4,-4));
				
				for (int i = 0; i < 9; i++){
					Geometry tempGeo = new Geometry("Rect", new Quad(2,2));
					tempGeo.setMaterial(green);
					tempGeo.setLocalTranslation(leftFaceOffSets.get(i));
					tempGeo.setLocalRotation(leftFaceRotation);
					leftFace.add(tempGeo);
				}
				//back face - orange
				Quaternion backFaceRotation = new Quaternion().fromAngles(180 * FastMath.DEG_TO_RAD,0,-90 * FastMath.DEG_TO_RAD);
				ArrayList<Vector3f> backFaceOffSets = new ArrayList<Vector3f>();
				backFaceOffSets.add(new Vector3f(4,2,-4));
				backFaceOffSets.add(new Vector3f(2,2,-4));
				backFaceOffSets.add(new Vector3f(0,2,-4));
				
				backFaceOffSets.add(new Vector3f(4,0,-4));
				backFaceOffSets.add(new Vector3f(2,0,-4));
				backFaceOffSets.add(new Vector3f(0,0,-4));
				
				backFaceOffSets.add(new Vector3f(4,-2,-4));
				backFaceOffSets.add(new Vector3f(2,-2,-4));
				backFaceOffSets.add(new Vector3f(0,-2,-4));
				
				for (int i = 0; i < 9; i++){
					Geometry tempGeo = new Geometry("Rect", new Quad(2,2));
					tempGeo.setMaterial(orange);
					tempGeo.setLocalTranslation(backFaceOffSets.get(i));
					tempGeo.setLocalRotation(backFaceRotation);
					backFace.add(tempGeo);
				}
				//right face - blue
				Quaternion rightFaceRotation = new Quaternion().fromAngles(0,90 * FastMath.DEG_TO_RAD,0);
				ArrayList<Vector3f> rightFaceOffSets = new ArrayList<Vector3f>();
				rightFaceOffSets.add(new Vector3f(4,0,2));
				rightFaceOffSets.add(new Vector3f(4,0,0));
				rightFaceOffSets.add(new Vector3f(4,0,-2));
				
				rightFaceOffSets.add(new Vector3f(4,-2,2));
				rightFaceOffSets.add(new Vector3f(4,-2,0));
				rightFaceOffSets.add(new Vector3f(4,-2,-2));
				
				rightFaceOffSets.add(new Vector3f(4,-4,2));
				rightFaceOffSets.add(new Vector3f(4,-4,0));
				rightFaceOffSets.add(new Vector3f(4,-4,-2));
				
				for (int i = 0; i < 9; i++){
					Geometry tempGeo = new Geometry("Rect", new Quad(2,2));
					tempGeo.setMaterial(blue);
					tempGeo.setLocalTranslation(rightFaceOffSets.get(i));
					tempGeo.setLocalRotation(rightFaceRotation);
					rightFace.add(tempGeo);
				}
				
				//right face - blue
				Quaternion bottomFaceRotation = new Quaternion().fromAngles(90 * FastMath.DEG_TO_RAD,0,0);
				ArrayList<Vector3f> bottomFaceOffSets = new ArrayList<Vector3f>();
				bottomFaceOffSets.add(new Vector3f(2,-4,0));
				bottomFaceOffSets.add(new Vector3f(0,-4,0));
				bottomFaceOffSets.add(new Vector3f(-2,-4,0));
				
				bottomFaceOffSets.add(new Vector3f(2,-4,-2));
				bottomFaceOffSets.add(new Vector3f(0,-4,-2));
				bottomFaceOffSets.add(new Vector3f(-2,-4,-2));
				
				bottomFaceOffSets.add(new Vector3f(2,-4,-4));
				bottomFaceOffSets.add(new Vector3f(0,-4,-4));
				bottomFaceOffSets.add(new Vector3f(-2,-4,-4));
				
				
				for (int i = 0; i < 9; i++){
					Geometry tempGeo = new Geometry("Rect", new Quad(2,2));
					tempGeo.setMaterial(yellow);
					tempGeo.setLocalTranslation(bottomFaceOffSets.get(i));
					tempGeo.setLocalRotation(bottomFaceRotation);
					bottomFace.add(tempGeo);
				}	
	}
	
	public ArrayList<Geometry> getTopFace(){
		return topFace;
	}
	public ArrayList<Geometry> getFrontFace(){
		return frontFace;
	}
	public ArrayList<Geometry> getLeftFace(){
		return leftFace;
	}
	public ArrayList<Geometry> getBackFace(){
		return backFace;
	}
	public ArrayList<Geometry> getRightFace(){
		return rightFace;
	}
	public ArrayList<Geometry> getBottomFace(){
		return bottomFace;
	}
	
	public ArrayList<ArrayList<Geometry>> getAllFaces(){
		ArrayList<ArrayList<Geometry>> allFaces = new ArrayList<ArrayList<Geometry>>();
		allFaces.add(topFace);
		allFaces.add(frontFace);
		allFaces.add(leftFace);
		allFaces.add(backFace);
		allFaces.add(rightFace);
		allFaces.add(bottomFace);
		
		return allFaces;
	}
	
	private ColorRGBA convertToColorRGBA(int r, int g, int b, int a){
		return new ColorRGBA(r/255f, g/255f, b/255f, a*1f);
	}
}
