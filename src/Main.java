import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;

import cities.Cities10k;


public class Main {
    public static void main(String[] args) {
    double maxDistance =0, result=0;
    String name1 = " ", name2= " ";
    String cityName1=" ", cityName2=" ";
    Cities10k cityA = new Cities10k();
    Cities10k cityB = new Cities10k();

        try {
            File myObj = new File("wincities10k.txt");

            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(" "); // dividing sting by spaces
                cityA.name = parts[0];
                cityA.latitude = Double.parseDouble(parts[1]);
                cityA.longitude = Double.parseDouble(parts[2]);

                Scanner myReaderB = new Scanner(myObj);
                while (myReaderB.hasNextLine()){
                    String dataB = myReaderB.nextLine();
                    String[] partsB = dataB.split(" ");
                    cityB.name = partsB[0];
                    cityB.latitude = Double.parseDouble(partsB[1]);
                    cityB.longitude = Double.parseDouble(partsB[2]);

                    Object[] objectResult = new Object[3];
                    objectResult = Cities10k.Calculations(cityA, cityB);
                    result = (Double) objectResult[0];
                    name1 = (String) objectResult[1];
                    name2 = (String) objectResult[2];
                    if (result > maxDistance) {
                        maxDistance = result;
                        cityName1 = name1;
                        cityName2 = name2;
                    }

                }
                myReaderB.close();

            }

            System.out.println("Max distance between " +cityName1 + " and " + cityName2+ " is "+ maxDistance);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}