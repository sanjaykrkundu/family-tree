package io.github.sanjaykrkundu;

import java.util.concurrent.ConcurrentHashMap;

public class Main {

	public static ConcurrentHashMap<String, Person> persons = new ConcurrentHashMap<>();

	private static void createTree() {

		// creating the objects
		Person king = new Person("King", 'M');
		Person queen = new Person("Queen", 'F');
		Person ish = new Person("Ish", 'M');
		Person chit = new Person("Chit", 'M');
		Person vich = new Person("Vich", 'M');
		Person satya = new Person("Satya", 'F');
		Person ambi = new Person("Ambi", 'F');
		Person crita = new Person("Crita", 'M');
		Person vrita = new Person("Vrita", 'M');
		Person jaya = new Person("Jaya", 'F');
		Person jata = new Person("Jata", 'M');
		Person driya = new Person("Driya", 'F');
		Person mnu = new Person("Mnu", 'M');
		Person lika = new Person("Lika", 'F');
		Person vila = new Person("Vila", 'M');
		Person chika = new Person("Chika", 'F');
		Person jnki = new Person("Jnki", 'F');
		Person lavnya = new Person("Lavnya", 'F');
		Person kpilar = new Person("Kpila", 'M');
		Person gru = new Person("Gru", 'M');
		Person vyan = new Person("Vyan", 'M');
		Person satvy = new Person("Satvy", 'F');
		Person savya = new Person("Savya", 'M');
		Person saayan = new Person("Saayan", 'M');
		Person asva = new Person("Asva", 'M');
		Person krpi = new Person("Krpi", 'F');
		Person kriya = new Person("Kriya", 'M');
		Person mina = new Person("Mina", 'F');
		Person misa = new Person("Misa", 'M');

		persons.put(king.getName(), king);
		king.getMarried(queen);
		king.haveChild(ish, chit, vich, satya);

		chit.getMarried(ambi);
		chit.haveChild(crita, vrita);

		crita.getMarried(jaya);
		crita.haveChild(jata, driya);

		driya.getMarried(mnu);

		vich.getMarried(lika);
		vich.haveChild(vila, chika);

		vila.getMarried(jnki);
		vila.haveChild(lavnya);

		lavnya.getMarried(gru);

		chika.getMarried(kpilar);
		satya.getMarried(vyan);
		satya.haveChild(satvy, savya, saayan);

		satvy.getMarried(asva);
		savya.getMarried(krpi);
		savya.haveChild(kriya);

		saayan.getMarried(mina);
		saayan.haveChild(misa);

	}

	public static void main(String[] args) {

		createTree();

		System.out.println(persons.size());

		persons.values().stream().filter(e -> e.getParents() == null).forEach(System.out::println);

	}
	
	
	
	
	
	
	

}
