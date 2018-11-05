package io.github.sanjaykrkundu;

import java.util.HashSet;
import java.util.Set;

public class Relation {
	private Set<Person> couple;
	private Set<Person> childs;

	public Relation() {
		couple = new HashSet<>();
		childs = new HashSet<>();
	}

	public void addCouple(Person p1, Person p2) {
		this.couple.add(p1);
		this.couple.add(p2);
	}

	public Set<Person> getCouple() {
		return couple;
	}

	public Set<Person> getChilds() {
		return childs;
	}

	public void addSpouse(Person p) {
		this.couple.add(p);
	}

	public void addChild(Person p) {
		this.childs.add(p);
	}

	public void addChild(Set<Person> p) {
		this.childs.addAll(p);
	}

}
