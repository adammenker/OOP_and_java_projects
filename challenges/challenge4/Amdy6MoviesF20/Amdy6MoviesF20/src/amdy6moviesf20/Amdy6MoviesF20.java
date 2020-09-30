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
public class Amdy6MoviesF20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Movie movie1 = new Movie("Frozen 2 (Plus Bonus Content)", "Chris Buckand Jennifer Lee");
        
        movie1.setCategory(Category.ANIMATION);
        movie1.setSummary("Together with Anna, Kristoff, Olaf and Sven, Elsa faces a dangerous but remarkable journey into the unknown—to the enchanted forests and dark seas beyond Arendelle, in search of truths about the past.");
        movie1.setRating(6.9f);
        movie1.setRevenue(1450000000);
        movie1.setYear(2019);
        
        Movie movie2 = new Movie("Shrek Forever After", "Mike Mitchell", "The further adventures of the giant green ogre, Shrek, living in the land of Far, Far Away.", Category.COMEDY, 2010, 6.3f, 752600000);
    
        Movie movie3 = new Movie("The Matrix", "The Wachowski Brothers", "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war againstits controllers.", Category.SCI_FI, 1999);
        movie3.setRating(8.7f);
        movie3.setRevenue(460000000);
        
        Movie movie4 = new Movie();
        
        movie4.setName("Inception");
        movie4.setDirector("Christopher Nolan");
        movie4.setSummary("A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.");
        movie4.setCategory(Category.SUSPENSE);
        movie4.setRating(8.8f);
        movie4.setRevenue(826137188);
        movie4.setYear(2010);
        
  
        System.out.println("Movie 1:");
        System.out.printf("NAME: %s\nDirector: %s\nSummary: %s\nCategory: %s\nYear: %s\nRating: %.1f\nRevenue: $%s\nVersion: %s\n\n", movie1.getName(), movie1.getDirector(), movie1.getSummary(), movie1.getCategory(), String.format("%d", movie1.getYear()), movie1.getRating(), movie1.commaSeparateRevenue(movie1.getRevenue()), String.format("%d", movie1.getVersion()));
        System.out.println("Movie 2:");
        System.out.printf("NAME: %s\nDirector: %s\nSummary: %s\nCategory: %s\nYear: %s\nRating: %.1f\nRevenue: $%s\nVersion: %s\n\n", movie2.getName(), movie2.getDirector(), movie2.getSummary(), movie2.getCategory(), String.format("%d", movie2.getYear()), movie2.getRating(), movie2.commaSeparateRevenue(movie2.getRevenue()), String.format("%d", movie2.getVersion()));
        System.out.println("Movie 3:");
        movie3.printFieldValues();
        System.out.println("Movie 4:");
        movie4.printFieldValues();
        
        System.out.printf("Number of Movies: %d\n", Movie.numOfMovies);

    }
    
}
