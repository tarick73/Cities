import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import cities.Cities10k;

import java.util.Scanner;
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
            List<Double> latitudes = new ArrayList<>();
            List<Double> longitudes = new ArrayList<>();
            List<String> names = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(" "); // dividing sting by spaces
                names.add(parts[0]);
                latitudes.add(Double.parseDouble(parts[1]));
                longitudes.add(Double.parseDouble(parts[2]));
            }

            for(int i=0;i<names.size();i++){
                for(int j=i+1;j<names.size();j++){
                    result=Cities10k.Calculations(names.get(i), latitudes.get(i), longitudes.get(i), names.get(j), latitudes.get(j), longitudes.get(j));
                    if (result > maxDistance) {
                        maxDistance = result;
                        cityName1 = names.get(i);
                        cityName2 = names.get(j);
                    }
                }
            }

            System.out.println("Max distance between " +cityName1 + " and " + cityName2+ " is "+ maxDistance);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}