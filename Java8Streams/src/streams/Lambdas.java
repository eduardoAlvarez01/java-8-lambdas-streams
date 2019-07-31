package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.*;

import java.util.List;


public class Lambdas {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Files.find(Paths.get("/Users/Eduardo/Downloads/"),Integer.MAX_VALUE,
				(filePath,fileAttr) -> fileAttr.isDirectory()).forEach(System.out::println);
		
		//(int a,int b)>a+b; 
		
		/* 
		 * Lambdas, 
		 * Lambda expressions basically express instances of functional interfaces (An interface with single abstract method is 
		 * called functional interface. An example is java.lang.Runnable). lambda expressions implement the only abstract function and therefore
		 *  implement functional interfaces
		 *  
		 * sin parametros () -> System.out.println("Zero parameter lambda");
		 * un parametro (p) -> System.out.println("One parameter: " + p);
		 * multi-parametro (p1, p2) -> System.out.println("Multiple parameters: " + p1 + ", " + p2);
		 * 
		 *multi-thread 
		 *
		 *source --> filter --> sort --> map --> colect 
		 *           (intermediate operations)||(terminal operation)
		 *souce =(whatever list arraylist etc) 
		 *
		 * 
		 **/
		
		IntStream
			.range(1,10)
			//foreach is a terminal operation
			.forEach(System.out::print);
		System.out.println();
		//123456789
		
		
		
		IntStream
		.range(1,10)
		//skip the first 5 elements
		.skip(5)
		.forEach(x -> System.out.println(x));
	System.out.println();
	//123456789
	
	Stream.of("Eduardo", "Alvarez", "Alvarez")
		.sorted()
		.findFirst()
		.ifPresent(System.out::println);
	
	String [] names= {"Al", "Josue","alberto","Miranda","Karla","Fabian","Jeshua","Sravan"};
	
	Arrays.stream(names)
		.filter(x -> x.startsWith("S"))
		.sorted()
		.forEach(System.out::println);
		
	
	Arrays.stream(new int [] {2,4,6,8,10})
	//map each element to square
		.map(x -> x*x)
		//display average of all
		.average()
		.ifPresent(System.out::println);
	
		
	List <String> people = Arrays.asList("Al", "Josue","alberto","Miranda","Karla","Fabian","Jeshua","Sravan");
		people.stream()
			.map(String::toLowerCase)
			.filter(x -> x.startsWith("a"))
			.forEach(System.out::println);
		
		//desde archivo 
		Stream <String> bands = null;
		try{
		bands = Files.lines(Paths.get("/Users/Eduardo/Downloads/userVolarisTest/VOLARIS/hola.txt"));
		}catch (Exception e) {System.out.println("Excepcion choncha"+ e);}
		bands
			.sorted()
			.filter(x -> x.length()>13)
			.forEach(System.out::println);
		bands.close();
		
		
	}

}
