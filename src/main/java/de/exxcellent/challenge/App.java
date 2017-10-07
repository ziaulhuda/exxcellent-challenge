package de.exxcellent.challenge;

import de.exxcellent.challenge.model.*;
import de.exxcellent.challenge.readers.*;
import de.exxcellent.challenge.analyzers.*;

import java.util.*;
/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */



public final class App {

    public static void main(String... args) {

        // Your preparation code …
		FileReader fr = new CSVReader();
		//the input files can also be taken as input params to the program.
		Database weatherDB = fr.readData(System.getProperty("user.dir") + "/target/classes/de/exxcellent/challenge/weather.csv");
		Database eplDB = fr.readData(System.getProperty("user.dir") + "/target/classes/de/exxcellent/challenge/football.csv");
		
		if(weatherDB == null || eplDB == null){
			System.out.println("Database could not be created. Exiting.");
			System.exit(1);
		}
		
		WeatherAnalyzer wa = new WeatherAnalyzer(weatherDB);
		EPLAnalyzer epla = new EPLAnalyzer(eplDB);

		String dayWithSmallestTempSpread = wa.dayWithSmallestTempSpread();     // Your day analysis function call …
        String teamWithSmallesGoalSpread = epla.teamWithSmallesGoalSpread(); // Your goal analysis function call …

        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallesGoalSpread);
    }
}
