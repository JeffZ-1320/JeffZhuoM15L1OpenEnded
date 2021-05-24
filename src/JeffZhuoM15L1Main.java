/*
Program Name:JeffZhuoM15L1Main
Author: Jeff Zhuo
Date:4/21/2021
Program description:
    Identify the age group that is most affected by COVID-19
What I learned from this program:
    Using an external library and make data analysis.
What difficulties did I have and how I solved them:
    Sinbad only allows for online data source and does not support local data source. Figured it out and changed it to a online url.
*/

//
import java.util.ArrayList;

import core.data.*;

public class JeffZhuoM15L1Main {
    public static void main(String[] args) {
        DataSource ds = DataSource.connectAs("CSV", "https://data.cdc.gov/api/views/3apk-4u4f/rows.csv?accessType=DOWNLOAD");
        ds.load();
        // ds.printUsageString();
        // stores the data set into an array list
        ArrayList<JeffZhuoDeathCase> deathList = ds.fetchList("JeffZhuoDeathCase", "Age Years", "COVID-19 Deaths", "Data as of", "End Date", "Sex", "Start Date", "Total deaths");
        int firstFemale = JeffZhuoDeathCase.firstFemaleOfList(deathList);
        // a new list for the percent of death based on age
        ArrayList<Double> percentOfCovidDeath = new ArrayList<Double>();
        for(int i = 0; i < firstFemale; i++){
            int ageDeath = deathList.get(i).getTotalDeath() + deathList.get(i + firstFemale).getTotalDeath();
            int covidAgeDeath = deathList.get(i).getCovidDeath() + deathList.get(i + firstFemale).getCovidDeath();
            percentOfCovidDeath.add(((double)covidAgeDeath) / ageDeath * 100.0);
        }
        // index = age and it identify the index with the largest percentage 
        int maxIndex = 0;
        for (int i = 0; i < percentOfCovidDeath.size(); i++) {
            if (percentOfCovidDeath.get(maxIndex) < percentOfCovidDeath.get(i)) {
                maxIndex = i;
            }
        }
        

        System.out.printf("Age group most affected by COVID-19 is %d year olds. With percent of death at %.2f%%.", maxIndex, percentOfCovidDeath.get(maxIndex));


    }
}

/*
Sample Output:
Age group most affected by COVID-19 is 74 year olds. With percent of death at 14.97%.
*/
