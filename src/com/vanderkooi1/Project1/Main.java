package com.vanderkooi1.Project1;


import java.util.*;

public class Main {
    static void displayAverages(Map<String, Double> averages) {
        for (String key: averages.keySet()) {
            System.out.println(key + ": " + averages.get(key));
        }
    }

    static Map<String, Double> calculateAverages(Map<String, List<Double>> dailyTemps) {
        Map<String, Double> averages = new TreeMap<>();

        for (String city: dailyTemps.keySet()) {
            List<Double> temps = dailyTemps.get(city);
            double total = 0;
            for (double temp: temps){
                total += temp;
            }
            total /= temps.size();
            averages.put(city, total);
        }

        return averages;
    }

    static Map<String, List<Double>> getUserInput() {
        List<String> cities = new ArrayList<>();
        Map<String, List<Double>> cityTemps = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a city name.");
        String city = scanner.nextLine();

        while (!city.equals("END")) {
            cities.add(city);
            System.out.println("Enter a city name.");
            city = scanner.nextLine();
        }

        for (String cityName: cities) {
            System.out.println("Enter the temperature for the next five days for " + cityName
                    + " (separate each temperature with a space).");
            String userInput = scanner.nextLine();

            /*
            split the string into an array based on the
            pattern specified to split(). Instead of
            spaces, we could have used commas:
            userInput.split(",")
            */

            String[] stringTemps = userInput.split(" ");

            List<Double> doubleTemps = new ArrayList<>();
            for (String temp: stringTemps) {
                doubleTemps.add(Double.parseDouble(temp));
            }

            cityTemps.put(cityName, doubleTemps);

        }
        return cityTemps;
    }

    public static void main(String[] args) {
        Map<String, List<Double>> userInput = getUserInput();
        Map<String, Double> averages = calculateAverages(userInput);
        displayAverages(averages);
    }
}
