import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class CreateFile{
    public static void creationoffile(){
        try{
            File input=new File("GeometricalShapesInput.txt");
            if(input.createNewFile()){
                System.out.println("Input file GeometricalShapesInput.txt created");
                FileWriter writer=new FileWriter("GeometricalShapesInput.txt");
                writer.write("1, Circle, Nil, Nil, 3"+"\n");
                writer.write("2, Rectangle, 2, 4, Nil"+"\n");
                writer.write("3, Square, 2, 2, Nil"+"\n");
                writer.write("4, Circle, Nil, Nil, 2"+"\n");
                writer.write("5, Circle, Nil, Nil, 4"+"\n");
                writer.write("6, Rectangle, 2, 3, Nil"+"\n");
                writer.write("7, Square, 3, 3, Nil"+"\n");
                writer.write("8, Rectangle, 3, 4, Nil"+"\n");
                writer.write("9, Rectangle, -5, 2, Nil"+"\n");
                writer.write("10, Circle, Nil, Nil, 5"+"\n");
                writer.close();
            }
            else{
                System.out.println("File already exists,Please check");
            }
            File output=new File("GeometricalShapesOutput.txt");
            if(output.createNewFile()){
                System.out.println("Output file GeometricalShapesOutput.txt created");
            }
            else{
                System.out.println("File already exists,Please check");
            }
        }
        catch(IOException e){
            System.out.println("An error occurred please check");
            e.printStackTrace();
        }
    }
}

class ReadFile{
    String filename;
    ArrayList<GeometricalShapes> gs;
    ReadFile(String s,ArrayList<GeometricalShapes> g){
        this.filename=s;
        this.gs=g;
    }
    public void Filereading(){
        Scanner reader=null;
        try{
            File fp=new File(filename);
            reader=new Scanner(fp);
            String s;
            while(reader.hasNextLine()){
                s=reader.nextLine();
                String[] st=s.split(", ",-1);
                if(st[1].equals("Circle")){
                    GeometricalShapes g=new GeometricalShapes(Integer.parseInt(st[0]),st[1],Integer.parseInt(st[4]));
                    gs.add(g);
                }
                else{
                    GeometricalShapes g=new GeometricalShapes(Integer.parseInt(st[0]),st[1],Integer.parseInt(st[2]),Integer.parseInt(st[3]));
                    gs.add(g);
                }
            }
            reader.close();
            reader=null;
        }
        catch(IOException e){
            System.out.println("Error occured");
            e.printStackTrace();
        }
        finally{
            if(reader!=null){
                System.out.println("Closing reader");
                reader.close();
                reader=null;
            }
        }
    }
    public static void main(String s,ArrayList<GeometricalShapes> gs){
        ReadFile r=new ReadFile(s, gs);
        r.Filereading();   
    }
}

class GeometricalShapes{
    int number;
    String shape;
    int length,breadth,radius;
    float Area;
    GeometricalShapes(int number,String shape){
        this.number=number;
        this.shape=shape;
    }
    GeometricalShapes(int number,String shape,int length,int breadth){
        this(number,shape);
        this.length=length;
        this.breadth=breadth;
        this.radius=-1;
        if(shape.equals("Square")){
            if(length!=breadth){
                throw new ArithmeticException("Square's constraint not satisfied");
            }
        }
        if(length<0){
            System.out.println("Found length<0 which is incorrect, changing it into positive number"+"changing "+this.length+" to "+this.length*-1);
            this.length=this.length*-1;
        }
        if(breadth<0){
            System.out.println("Found breadth<0 which is incorrect,changing it into positive number"+"changing "+this.breadth+" to "+this.breadth*-1);
            this.breadth=this.breadth*-1;
        }
    }
    GeometricalShapes(int number,String shape,int radius){
        this(number,shape);
        this.radius=radius;
        if(radius<0){
            System.out.println("Found radius<0,which is incorrect,changing it into positive number"+"changing "+this.radius+" to "+this.radius*-1);
            this.radius=this.radius*-1;
        }
        this.length=this.breadth=-1;
    }    
    public void Areaofrectangle(){
        if(shape.equals("Rectangle"))
            this.Area=this.length*this.breadth;
        else{
            System.out.println("Cannot calculate area as given shape is not rectangle");
        }
    }
    public void Areaofcircle(){
        if(shape.equals("Circle"))
            this.Area=this.radius*this.radius*3.14f;
        else
            System.out.println("Cannot calculate area as given shape is not circle");
    }
    public void AreaofSquare(){
        if(shape.equals("Square"))
            this.Area=this.length*this.length;
        else
            System.out.println("Cannot calculate area as given shape is not square");
    }

    public static Comparator<GeometricalShapes> Areacompare=new Comparator<GeometricalShapes>(){
        public int compare(GeometricalShapes g1,GeometricalShapes g2){
            if(g1.Area>g2.Area){
                return -1;
            }
            else if(g1.Area==g2.Area){
                return 0;
            }
            else{
                return 1;
            }
        }
    };
}

public class S20190010034_AssignMG4{
    public static void main(String[] args) {
        CreateFile.creationoffile();
        ArrayList<GeometricalShapes> gs=new ArrayList<GeometricalShapes>();
        ReadFile.main("GeometricalShapesInput.txt",gs);
        for(GeometricalShapes g:gs){
            if(g.shape.equals("Circle")){
                g.Areaofcircle();
            }
            else if(g.shape.equals("Rectangle")){
                g.Areaofrectangle();
            }
            else{
                g.AreaofSquare();
            }
        }
        //Collections.sort(gs,GeometricalShapes.Areacompare);
        gs.sort(GeometricalShapes.Areacompare);
        FileWriter writer=null;
        try{
        writer=new FileWriter("GeometricalShapesOutput.txt");
            for(GeometricalShapes g:gs){
                if(g.length==-1){
                    //System.out.println(g.number+" "+g.shape+" "+"Nil"+" "+"Nil"+" "+g.radius+" "+g.Area);
                    writer.write(g.number+" "+g.shape+" "+"Nil"+" "+"Nil"+" "+g.radius+" "+g.Area+"\n");
                }
                else{
                    //System.out.println(g.number+" "+g.shape+" "+g.length+" "+g.breadth+" "+"Nil"+" "+g.Area);
                    writer.write(g.number+" "+g.shape+" "+g.length+" "+g.breadth+" "+"Nil"+" "+g.Area+"\n");
                }
            }
            writer.close();
        }
        catch(IOException e){
            System.err.println("Error occured");
            e.printStackTrace();
        }
        finally{
                System.out.println("Result written in the output file");
                //writer.close();
        }
    }
}