package pt.iscte.poo.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import objects.*;
import pt.iscte.poo.gui.ImageTile;
import pt.iscte.poo.utils.Point2D;

import javax.swing.*;

public class Room {

    private List<ImageTile> objects;
    private String roomName;
    private Baba player;

    public Room() {
        objects = new ArrayList<>();
    }

    private void setName(String name) {
        roomName = name;
    }

    public String getName() {
        return roomName;
    }

    public void addObject(ImageTile obj) {
        objects.add(obj);
    }

    public List<ImageTile> getObjects() {
        return objects;
    }

    public static Room readRoom(File f) {
        Room r = new Room();
        r.setName(f.getName());

        //Start 1: try-and-catch method to create basic ap generation based on text file
        try (Scanner sc = new Scanner(f)) {

            if (!sc.hasNextLine()) {
                return r;
            }

            //Start 2: reads first line to get map dimensions
            String mapDimension = sc.nextLine();
            String[] parts = mapDimension.split(",");
            int cols = Integer.parseInt(parts[0]);
            int rows = Integer.parseInt(parts[1]);
            //End 2: reads first line to get map dimensions

            //Start 3: Fills Floor with dirt for the whole map dimensions
            for(int i = 0; i < rows; i++){
                for(int j = 0 ; j < cols; j++){
                    r.addObject(new Dirt(new Point2D(i,j)));
                }
            }
            //End 3: Fills Floor with dirt for the whole map dimensions

            //Start 4: Row reader that determines what object goes where dependent on what is written in map file
            int j = 0;
            while(sc.hasNextLine()){

                String line = sc.nextLine().trim();

                if(line.contains(",") || line.isEmpty()){
                    break;
                }

                //Start 5: Char checker to see and determine what is what
                for(int i = 0 ; i < cols && i < line.length(); i++){
                    char c = line.charAt(i); //Checks char exactly at the point at which the for is in
                    Point2D position = new Point2D(i,j);

                    switch(c){
                        case 'X':
                            r.addObject(new Wall("Wall", position));
                            break;
                        case 'x':
                            r.addObject(new CrackedWall("Cracked Wall", position));
                            break;
                        case 'H':
                            r.addObject(new Hole("Hole", position));
                            break;
                        case 'g':
                            r.addObject(new Grass("Grass", position));
                            break;
                        case ' ':
                            //Since Dirt will alread be occupying this space this is left empty
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + c);
                    }
                }
                j++;
                //End 5: Char checker to see and determine what is what
            }
            //End 4: Row reader that determines what object goes where dependent on what is written in map file

            //Start 6: Line Reader that based on the "Objetos de Nível" will determine what exact location the object should be in on the map
            while(sc.hasNextLine()){

                String line = sc.nextLine().trim();
                if(line.isEmpty()){
                    continue; //The scanner continues as there is a space as shown in the example of a map file
                }

                String[] spacer = line.split(",");
                if(spacer.length>=3){ //Checks if format is correct <nomeDoObjeto>,<x>,<y>
                    String objName = spacer[0];
                    int xPosition = Integer.parseInt(spacer[1]);
                    int yPosition = Integer.parseInt(spacer[2]);
                    Point2D positon = new Point2D(xPosition,yPosition); //Tells the engine what exact location the object should be in on the map

                    ImageTile tile = null;

                   //Start 7: objName chacker to see what Java Class should be initialized and placed
                    switch (objName.toLowerCase()){
                        case "baba":
                            Baba baba = new Baba(positon);
                            r.player = baba;
                            tile=baba;

                        case "rock":
                            Rock rock = new Rock(objName,positon);
                            tile = rock;
                        case "bomb":
                            Bomb bomb = new Bomb(objName, positon);
                            tile = bomb;
                        case "box":
                            Box box = new Box(objName,positon);
                            tile = box;
                        case "flag":
                            Flag flag = new Flag(objName, positon);
                            tile = flag;
                        case "wordBox":
                        case "wordIs":
                        case "wordWin":
                        case "wordMove":
                        case "wordStop":

                        default:
                            break;  // If the object name doesn't match any known case it does nothing
                    }
                    //End 7: objName chacker to see what Java Class should be initialized and placed
                    if(tile != null){
                        r.addObject(tile);
                    }
                }

            }
        //End 6: Line Reader that based on the "Objetos de Nível" will determine what exact location the object should be in on the map
        }

        catch (FileNotFoundException e) {
           e.printStackTrace();
        }


        for (int i = 0; i <= 10; i++) {
            ImageTile dirt = new Dirt(new Point2D(i, i));
            r.addObject(dirt);
            ImageTile dirt2 = new Dirt(new Point2D(10 - i, i));
            r.addObject(dirt2);
        }

        Baba baba = new Baba(new Point2D(5, 5));
        r.addObject(baba);

        r.player = baba;
        return r;
    }

    public Baba getPlayer() {
        return player;
    }
}