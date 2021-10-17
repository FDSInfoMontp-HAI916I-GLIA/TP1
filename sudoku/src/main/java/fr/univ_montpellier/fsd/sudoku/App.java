package fr.univ_montpellier.fsd.sudoku;

import org.apache.commons.cli.ParseException;

import fr.univ_montpellier.fsd.sudoku.ppc.Sudoku;
import fr.univ_montpellier.fsd.sudoku.imp.SuMain;



/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String[] args) throws ParseException, InterruptedException {
		
	
		SuMain sudoimp = new SuMain();
		long start = System.currentTimeMillis();
		sudoimp.main(args);
		Thread.currentThread().sleep(1000);
		System.out.println("Solution java terminée !");
		System.out.println("Temps d'exécution en seconde: " + (System.currentTimeMillis() - start)/1000+"s");
		
		System.out.println("début solution ppc :");
		Sudoku suppc = new Sudoku();
		suppc.main(args);
		
		
	}

}
