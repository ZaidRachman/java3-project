package com.rachman.data_access;

import com.rachman.fun_stuff.Country;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountryDAO_CSV {
    public static List<Country> getAll(HttpServletRequest request, HttpServletResponse response){
        List<Country> countries = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File(request.getContextPath() + "/WEB-INF/funstuff/countries.csv"))){

            int lineCount = 1;

            while(scanner.hasNext()){
                String[] dataStr = scanner.nextLine().split(",");
                if(lineCount != 1){
                    String name = dataStr[0];
                    String continent = dataStr[2];
                    int population = Integer.parseInt(dataStr[5]);
                    Country country = new Country(name, continent, population);
                    countries.add(country);
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }

        return countries;
    }
}
