package telran.io;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class CodeCommentsSeparation {

	
	public static void main(String[] args) {
		// args[0] - file path for file containing both Java class code and comments
		//args[1] - result file with only code
		//args[2] - result file with only comments
		//example of args[0] src/telran/io/test/InputOutputTest.java
		//TODO
		//from one file containing code and comments to create two files : one with code and one with comments
		//
		try {
			checkArgs(args);
			try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
				 PrintWriter codeWriter = new PrintWriter(args[1]);
				 PrintWriter commentWriter = new PrintWriter(args[2]) ) {
					 reader.lines().forEachOrdered( line -> {
						 if ( isComment(line) ) {
							 commentWriter.println(line);
						 } else {
							 codeWriter.println(line);
						 }
					});
				}
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

	private static void checkArgs(String[] args) throws Exception {
		if ( args.length < 3 ) {
			throw new Exception("Usage: first argument - existing file, second argument - file name to write code lines only, third argument - file name to write comment lines only" );
		}
	}
	private static boolean isComment(String line) {
		 return line.stripLeading().startsWith("//");
		 
	}
}
