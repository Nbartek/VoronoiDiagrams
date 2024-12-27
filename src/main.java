import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import fortune.*;
import simple.*;
public class main {
    /*
    * App for making voronoi diagrams with a given list of points and finding the best new place for voronoi core based on area size/population.
    * I've built implementations of 2 algorithms. First called SimpleVoronoi is a bruteforce approach with making each voronoi cell one bay one.
    *
    * Second is Fortune's Algorithm.
    * File that contains voronoi cores:
    *   numbers separated by ','
    *   first row name of the columns
    *   first number is id
    * */
    public static void main(String[] args) {
        ArrayList<Punkt> p = readFile();
        SimpleVoronoi varanoi = new SimpleVoronoi(p);
        Punkt wynik = varanoi.findBestPlace(p);
        System.out.println("Best place for new core when taking in account area size is X: "+wynik.getX()+" Y: "+wynik.getY());

    }
    //Function to fill ArrayList with points from file
    private static ArrayList<Punkt> readFile() {
        ArrayList<Punkt> p = new ArrayList<>();
        try {
            File objekt = new File("points.csv");
            Scanner czytnik = new Scanner(objekt);
            //Pominąć linijkę tytułową
            czytnik.nextLine();
            while (czytnik.hasNextLine()) {
                String line = czytnik.nextLine();
                String[] str = line.split(",");
                double x = Double.parseDouble(str[1]);
                double y = Double.parseDouble(str[2]);
                p.add(new Punkt(x,y));
            }
            czytnik.close();
            return p;
        }catch (FileNotFoundException e){
            System.out.println("File not found");
            System.out.println(e);
            return null;
        }
    }
}
