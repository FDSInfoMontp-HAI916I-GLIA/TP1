package fr.univ_montpellier.fsd.sudoku.imp;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Sudoku {

	int n;
	int s;
	int[][] grid ;
	
	Scanner reader = new Scanner(System.in);  // Reading from System.in
	int nn=0;
	/*
	 * Create an instance of the problem sudoku (nxn)
	 * 
	 */
	
	public Sudoku(int n) {
		this.n = n;
		this.s = (int) Math.sqrt(n);
		this.grid = new int[n][n];
	}

	public Sudoku() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * check if this.grid is a correct sudoku solution.
	 * 
	 */
	private boolean solutionChecker(int [][] grid) {
		
		boolean[] unique = new boolean[n+ 1];

		for(int i = 0; i < n; i++){
			Arrays.fill(unique, false);
			for(int j = 0; j < n; j++) {
				int Z = grid[i][j];
				if (unique[Z]){
					return false;
				}
				unique[Z] = true;
			}
		}

		for(int i = 0; i < n; i++){
		
			Arrays.fill(unique, false);
			for(int j = 0; j < n; j++){
				int Z = grid[j][i];

				if (unique[Z]){
					return false;
				}
				unique[Z] = true;
			}
		}

		for(int i = 0; i < n-2; i += s){
			for(int j = 0; j <n-2; j += s){
			
				Arrays.fill(unique, false);
				for(int k = 0; k < s; k++){
					for(int l = 0; l < s; l++){
						int X = i + k;
						int Y = j + l;
						int Z = grid[X][Y];
						if (unique[Z])
						{
							return false;
						}
						unique[Z] = true;
					}
				}
			}
		}

		// If all conditions satisfied
		return true;

	}

	/*
	 * Generate a random grid solution
	 * 
	 */

	private int[][] generateSolution() {
		
		
		for (int i=0; i<n; i++) {
		    for (int j=0; j<n; j++) {
		        grid[i][j] = (int) (Math.random()*(n)+1);
		    }           
		}
		
		return grid;

	}

	/*
	 * Find a solution to the sudoku problem
	 * 
	 */
	public void findSolution() {
		boolean a = false;
		boolean b = true;
		System.out.println("recherche de solution en cours...");
		while(b) {
			System.out.println();
			int[][]gr = generateSolution();
			if(solutionChecker(gr)==true) {
				System.out.println("une Solution trouvee !");
				System.out.println("la solution est : \t");
				for (int i=0; i<n; i++) {
					System.out.print("\t");
				    for (int j=0; j<n; j++) {
				        System.out.print(grid[i][j]+" ");
				    }
				    System.out.println(" ");
				}
				
				System.out.println("Compte tenu du systeme de generation aléatoire,\n "
						+ "A chaque solution trouvee vous pouvez rechercher une nouvelle ou vous arreter.\n");
				System.out.println("appuyez 1 pour afficher d'autres resultats :");
				nn = reader.nextInt(); 
				if(nn==1) {
					continue;
				}
				else {
					break;
				}
				
				
				//b=false;
			}
		}
		
		
		
		
	}

	public static void main(String args[]) {
		
		new Sudoku(4).findSolution();
		
		
		
	}
}
