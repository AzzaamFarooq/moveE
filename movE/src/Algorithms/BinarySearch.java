package Algorithms;

import java.util.ArrayList;

import MovieDatabase.Movie;

public class BinarySearch {

	private Movie selected;
	private String movieName;

	private ArrayList<Movie> nameSort;
	private ArrayList<Movie> inputArray;

	private ArrayList<Movie> recommendedRating = new ArrayList<>();
	private ArrayList<Movie> recommendedGenre = new ArrayList<>();
	private ArrayList<Movie> recommendedByBoth = new ArrayList<>();

	public BinarySearch(ArrayList<Movie> inputArray, String movieName) {
		this.inputArray = inputArray;
		this.movieName = movieName;

		MergeSort byName = new MergeSort(inputArray);

		byName.sortNames();

		this.nameSort = byName.getSortedNameArray();

	}

	/**
	 * Search for the users movies by performing a binary search on the array list
	 * of movies that is sorted in order of names
	 */
	public void findUserMovie() {

		int first = 0;
		int last = nameSort.size() - 1;

		int mid = (first + last) / 2;

		while (first <= last) {
			if (nameSort.get(mid).getMovieName().compareTo(movieName) < 0) {
				first = mid + 1;

			} else if (nameSort.get(mid).getMovieName().equals(movieName)) {

				selected = nameSort.get(mid);

				break;

			} else {
				last = mid - 1;
			}
			mid = (first + last) / 2;
		}
		if (first > last) {
			System.out.println("Not Found");
		}

	}

	/**
	 * Builds a recommended array that is based off of rating. The rating of the
	 * users movie is recorded an movies that have a equal or higher rating is
	 * recommended to the user
	 */
	public void buildRatingRecommendation() {

		MergeSort ms = new MergeSort(inputArray);

		ms.sortRatings();

		int first = 0;
		int last = ms.getSortedRatingsArray().size() - 1;

		int mid = (first + last) / 2;

		while (first <= last) {
			if (ms.getSortedRatingsArray().get(mid).getRating() < selected.getRating()) {
				first = mid + 1;

			} else if (ms.getSortedRatingsArray().get(mid).getRating() >= selected.getRating()) {

				for (int i = mid; i < ms.getSortedRatingsArray().size(); i++) {

					recommendedRating.add(ms.getSortedRatingsArray().get(i));

				}

				break;

			} else {
				last = mid - 1;
			}
			mid = (first + last) / 2;
		}
		if (first > last) {
			System.out.println("No");
		}

	}

	/**
	 * Builds a recommended array that is based off of the genre of the users
	 * entered movie. The genre of the movie is compared to all other movies, and if
	 * another movies genre is a subset of the selected movie then it is recommended
	 * to the user
	 */
	public void buildGenreRecommendations() {

		for (Movie movie : inputArray) {
			if (selected.getGenres().containsAll(movie.getGenres())) {

				recommendedGenre.add(movie);
			}

		}

	}

	/**
	 * If the user cared for both the rating and genre of the movies then we take
	 * the movies from the recommended movies based off of ratings and check to see
	 * which movies have the same genre set as the other movies
	 */
	public void buildBothRecommendations() {
		for (Movie movie : recommendedRating) {
			if (selected.getGenres().containsAll(movie.getGenres())) {
				recommendedByBoth.add(movie);
			}

		}

	}

	/**
	 * Returns a list of recommended movies based on ratings
	 * 
	 * @return
	 */
	public ArrayList<Movie> getRatingRecommendations() {
		return recommendedRating;
	}

	/**
	 * Returns a list of recommended movies based on genre
	 * 
	 * @return
	 */
	public ArrayList<Movie> getGenreRecommendations() {
		return recommendedGenre;
	}

	/**
	 * Returns a list of recommended movies based on ratings and genre
	 * 
	 * @return
	 */
	public ArrayList<Movie> getBothRecommendations() {
		return recommendedByBoth;

	}

	/**
	 * Returns the users selected movie
	 * 
	 * @return
	 */
	public Movie getUserMovie() {
		return selected;
	}

}
