package Algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import MovieDatabase.MoviesArray;

class BinarySearchTest {

	private static MoviesArray a = new MoviesArray();
	
	@BeforeClass
	public void setUp() throws Exception {
		
		MoviesArray a = new MoviesArray();

	}

	@AfterClass
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetUserMovie() {
		
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
			
		assertTrue(a.getMovies().get(2).getMovieName().compareTo("Spectre†") == a.getMovies().get(2).getUserMovie());
		
	}

}
