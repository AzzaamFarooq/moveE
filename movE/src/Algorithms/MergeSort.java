package Algorithms;

import java.util.ArrayList;

import MovieDatabase.Movie;

public class MergeSort {
	private ArrayList<Movie> inputArray;
	private ArrayList<Movie> ratingOrder;
	private ArrayList<Movie> nameOrder;

	/**
	 * Return the movies sorted in order of ratings
	 * 
	 * @return
	 */
	public ArrayList<Movie> getSortedRatingsArray() {
		return ratingOrder;
	}

	/**
	 * Return the movies sorted in order of names
	 * 
	 * @return
	 */
	public ArrayList<Movie> getSortedNameArray() {
		return nameOrder;
	}

	/**
	 * Creating a MergeSort object that will perform mergesort algorithm on a given
	 * Arraylist through divide and conquer method
	 * 
	 * @param inputArray
	 */
	public MergeSort(ArrayList<Movie> inputArray) {
		this.inputArray = inputArray;
		this.ratingOrder = inputArray;
		this.nameOrder = inputArray;
	}

	public void sortRatings() {
		divideRatings(0, this.inputArray.size() - 1);
	}

	public void sortNames() {
		divideNames(0, this.inputArray.size() - 1);
	}

	/**
	 * Method used for dividing the ratings
	 * 
	 * @param startIndex
	 * @param endIndex
	 */
	public void divideRatings(int startIndex, int endIndex) {

		// Divide till you breakdown your list to single element
		if (startIndex < endIndex && (endIndex - startIndex) >= 1) {
			int mid = (endIndex + startIndex) / 2;
			divideRatings(startIndex, mid);
			divideRatings(mid + 1, endIndex);

			// merging Sorted array produce above into one sorted array
			mergeRatings(startIndex, mid, endIndex);

		}
	}

	/**
	 * Method used for dividing the name of the movies
	 * 
	 * @param startIndex
	 * @param endIndex
	 */
	public void divideNames(int startIndex, int endIndex) {

		// Divide till you breakdown your list to single element
		if (startIndex < endIndex && (endIndex - startIndex) >= 1) {
			int mid = (endIndex + startIndex) / 2;
			divideNames(startIndex, mid);
			divideNames(mid + 1, endIndex);

			// merging Sorted array produce above into one sorted array
			mergeNames(startIndex, mid, endIndex);

		}
	}

	/**
	 * Merges the sub-arrays together for Names
	 * 
	 * @param startIndex
	 * @param midIndex
	 * @param endIndex
	 */
	public void mergeNames(int startIndex, int midIndex, int endIndex) {

		// Below is the merged array that will be sorted array Array[i-midIndex] ,
		// Array[(midIndex+1)-endIndex]
		ArrayList<Movie> mergedSortedArray = new ArrayList<Movie>();

		int leftIndex = startIndex;
		int rightIndex = midIndex + 1;

		while (leftIndex <= midIndex && rightIndex <= endIndex) {
			int bool = nameOrder.get(leftIndex).getMovieName().compareTo(nameOrder.get(rightIndex).getMovieName());
			if (bool <= 0) {
				mergedSortedArray.add(nameOrder.get(leftIndex));
				leftIndex++;
			} else {
				mergedSortedArray.add(nameOrder.get(rightIndex));
				rightIndex++;
			}
		}

		// Either of below while loop will execute
		while (leftIndex <= midIndex) {
			mergedSortedArray.add(nameOrder.get(leftIndex));
			leftIndex++;
		}

		while (rightIndex <= endIndex) {
			mergedSortedArray.add(nameOrder.get(rightIndex));
			rightIndex++;
		}

		int i = 0;
		int j = startIndex;
		// Setting sorted array to original one
		while (i < mergedSortedArray.size()) {
			nameOrder.set(j, mergedSortedArray.get(i++));
			j++;
		}
	}

	/**
	 * Merges the sub-arrays together for ratings
	 * 
	 * @param startIndex
	 * @param midIndex
	 * @param endIndex
	 */
	public void mergeRatings(int startIndex, int midIndex, int endIndex) {

		ArrayList<Movie> mergedSortedArray = new ArrayList<Movie>();

		int leftIndex = startIndex;
		int rightIndex = midIndex + 1;

		while (leftIndex <= midIndex && rightIndex <= endIndex) {
			if (ratingOrder.get(leftIndex).getRating() <= ratingOrder.get(rightIndex).getRating()) {
				mergedSortedArray.add(ratingOrder.get(leftIndex));
				leftIndex++;
			} else {
				mergedSortedArray.add(ratingOrder.get(rightIndex));
				rightIndex++;
			}
		}

		while (leftIndex <= midIndex) {
			mergedSortedArray.add(ratingOrder.get(leftIndex));
			leftIndex++;
		}

		while (rightIndex <= endIndex) {
			mergedSortedArray.add(ratingOrder.get(rightIndex));
			rightIndex++;
		}

		int i = 0;
		int j = startIndex;
		while (i < mergedSortedArray.size()) {
			ratingOrder.set(j, mergedSortedArray.get(i++));
			j++;
		}
	}

}
