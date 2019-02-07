package utils;

import java.io.File;

public class Utilitarios {

	
	public static void deletarRelatorio() {
		File file = new File( "./Reports/ResultadoTest.html" );
		if(file.delete())
			System.out.println("apagou");
		else
			System.out.println("não apagou");
		
	}
}
