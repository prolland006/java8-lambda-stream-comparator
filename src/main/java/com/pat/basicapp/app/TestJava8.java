package com.pat.basicapp.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestJava8 {
	
	List<Commande> listeCommandes = new ArrayList<Commande>();

	public TestJava8() {
		listeCommandes.add(new Commande("20140509", 113.12));
		listeCommandes.add(new Commande("20140508", 113.07));
		listeCommandes.add(new Commande("20140507", 356.03));
		listeCommandes.add(new Commande("20140512", 78.94));
		listeCommandes.add(new Commande("20140409", 163.23));
		listeCommandes.add(new Commande("20140429", 982.34));
		listeCommandes.add(new Commande("20140508", 172.89));		
	}
	
	/**
	 * Interface mandatory for lambda
	 * @author patrice
	 *
	 */
	private interface Lambda {
		public int execute(int a, int b);
	}
	
	public void lambda() {
		System.out.println("**** lambda ****");
		Lambda addition = (int a, int b) -> a + b;
		System.out.println(addition.execute(10, 5));		
	}
	
	public void display() {
		System.out.println("**** display ****");
		this.display(listeCommandes);
	}

	public void display(List<Commande> list) {
		Stream<Commande> stream = list.stream();
		stream.forEach(System.out::println);
	}
	
	public List<Commande> filter() {
		return listeCommandes.stream()
				 .filter(x -> x.numero.startsWith("201405"))
				 .collect(Collectors.toList());
	}
	
	public void map() {
		System.out.println("**** map ****");
		System.out.println(listeCommandes.stream()
				 .filter(x -> x.numero.startsWith("201405"))
				 .map(x -> x.getMontant())
				 .collect(Collectors.toList()));
	}

	public void reduce() {
		System.out.println("**** reduce ****");
		System.out.println(listeCommandes.stream()
				 .filter(x -> x.numero.startsWith("201405"))
				 .map(x -> x.getMontant())
				 .reduce((x,y) -> x > y ? x : y)
				);
	}
	
	public void comparator() {
		List<Commande> listToSort = listeCommandes.stream().
				collect(Collectors.toList());
		
		Comparator<Commande> comparator = Comparator
				.comparing(Commande::getNumero)
				.thenComparing(Commande::getMontant);
		Collections.sort(listToSort, comparator);
		
		this.display();
		
		System.out.println("**** sorted list ****");
		this.display(listToSort);
	}
	
	public void sorted() {
		System.out.println("**** sorted ****");
		Comparator<Commande> comparator = Comparator
				.comparing(Commande::getNumero)
				.thenComparing(Commande::getMontant);

		
		System.out.println(this.listeCommandes.stream()
			.sorted(comparator)
			.collect(Collectors.toList()));
	}
	
}
