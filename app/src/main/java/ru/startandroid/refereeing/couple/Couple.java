package ru.startandroid.refereeing.couple;

/**
 * Created by Slav on 26.12.2016.
 */

public class Couple {
    private int number;
    private int place;
    public Couple (int number, int place){
        this.number = number;
        this.place = place;
    }
    public int getNumber(){
        return number;
    }
    public int getPlace(){
        return place;
    }
}
