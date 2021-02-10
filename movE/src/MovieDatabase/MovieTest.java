package MovieDatabase;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Algorithms.BinarySearch;

class MovieTest {

	
	private static MoviesArray a = new MoviesArray();

	@BeforeClass
	public void setUp() throws Exception {
		
		MoviesArray a = new MoviesArray();

		
	}

	@AfterClass
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetMovieName() {
		
		 
		 
		assertTrue(a.getMovies().get(2).getMovieName().compareTo("Spectre†") == 1);
		/*
		BinarySearch recommendations = new BinarySearch(a.getMovies(), "my date with drew");

		recommendations.findUserMovie();

		recommendations.buildRatingRecommendation();

		recommendations.buildGenreRecommendations();

		recommendations.buildBothRecommendations();

		for (Movie first : recommendations.getBothRecommendations()) {

			System.out.println(first.movieName + " This is rating: " + first.rating);
			break;

		}*/
	}
		
	@Test
	public void testGetGenres() {
		
		ArrayList<String> test1 = new ArrayList<String>();
		
		//assertTrue(a.getMovies().get(2).getGenres() == );
		
	}
	
	public void testGetRating() {
		assertTrue(a.getMovies().get(2).getRating() == 6.8);
		
	}

}
