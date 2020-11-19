import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Module to read from TSP file
public class TSPInput {
    private int xCoordinates[];
    private int yCoordinates[];

    public TSPInput(int noOfCities){
        xCoordinates=new int[noOfCities];
        yCoordinates=new int[noOfCities];
    }

    public int[] getxCoordinates() {
        return xCoordinates;
    }

    public int[] getyCoordinates() {
        return yCoordinates;
    }

    //Function to read a TSP file
    public void readFile(String filename){
        int i=1,j=0;
        try{
            File f1 = new File(filename);
            Scanner scanner = new Scanner(f1);
            while(scanner.hasNextLine()){
                String data = scanner.nextLine();
                if(i>7 && !data.equals("EOF")) {
                    String str[]=data.split(" ");
                    xCoordinates[j]=((int)Double.parseDouble(str[1]));
                    yCoordinates[j]=((int)Double.parseDouble(str[2]));
                    i++;
                    j++;
                }
                else
                    i++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}