/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amdy6moviesf20;

/**
 *
 * @author adammenker
 */
public class Movie {
    
    // 8 private fields, some initialized with default values
    private String name;
    private String director;
    private String summary;
    private float rating = 0.0f;
    private double revenue = 0.0;
    private Category category;
    private int year = 1888;
    private int version;
    
    // initialized with a value of 0
    public static int numOfMovies = 0;
    
    // no arg constructor
    public Movie(){
        this.name = "";
        this.director = "";
        numOfMovies++;
    }
    
    // 2nd constructor
    public Movie(String name, String director){
        this();
        this.name = name;
        this.director = director;
        this.version = 0;
    }
    
    // 3rd constructor
    public Movie(String name, String director, String summary, Category category, int year){
        this(name, director);
        this.summary = summary;
        this.category = category;
        this.year = year;
        this.version = 1;
    }
    
    // 4th constructor
    public Movie(String name, String director, String summary, Category category, int year, float rating, double revenue){
        this(name, director, summary, category, year);
        this.rating = rating;
        this.revenue = revenue;
    }
    
        // custom methods below
    
    // setters
    public void setName(String name){
        this.name = name;
        incrementVersion();
    }
    
    public void setDirector(String director){
        this.director = director;
    }
    
    public void setRating(float rating){
        this.rating = rating;
        incrementVersion();
    }
    
    public void setRevenue(double revenue){
        this.revenue = revenue;
        incrementVersion();
    }
    
    public void setYear(int year){
        this.year = year;
        incrementVersion();
    }
    
    public void setCategory(Category category){
        this.category = category;
    }
    
    public void setSummary(String summary){
        this.summary = summary;
        incrementVersion();
    }
    
    //getters
    
    public String getName(){
        return this.name;
    }
    
    public String getDirector(){
        return this.director;
    }
    
    public float getRating(){
        return this.rating;
    }
    
    public double getRevenue(){
        return this.revenue;
    }
    
    public int getYear(){
        return this.year;
    }
    
    public Category getCategory(){
        return this.category;
    }
    
    public String getSummary(){
        return this.summary;
    }
    
    public int getVersion(){
        return this.version;
    }
    // * end getters and setters
    
    public void incrementVersion(){
        this.version++;
    }
    
    // https://javadevnotes.com/java-integer-to-string-with-commas/ I used this to learn how to comma separate the revenue 
    public String commaSeparateRevenue(double revenue){
        String numberAsString = String.format("%,.0f", revenue);
        return numberAsString;
    }
    
    // I named it this, because "print()" does not seem specific enough
    public void printFieldValues(){
        System.out.printf("NAME: %s\nDirector: %s\nSummary: %s\nCategory: %s\nYear: %s\nRating: %.1f\nRevenue: $%s\nVersion: %s\n\n", this.name, this.director, this.summary, this.category, String.format("%d", this.year), this.rating, this.commaSeparateRevenue(this.revenue), String.format("%d", this.version));
    }
    
}
