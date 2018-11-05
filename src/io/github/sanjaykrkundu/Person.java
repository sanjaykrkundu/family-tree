package io.github.sanjaykrkundu;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Person implements IPerson {
	private String name;
	private char gender;
	private Relation parents;
	private Relation partner;

	public Person() {
	}

	public Person(String name, char gender) {
		this.name = name;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Relation getParents() {
		return parents;
	}

	public void setParents(Relation parents) {
		this.parents = parents;
	}

	public Relation getPartner() {
		return partner;
	}

	public void setPartner(Relation partner) {
		this.partner = partner;
	}

	@Override
	public String toString() {
		String partner = "null";

		if (this.partner != null)
			partner = this.partner.getCouple().stream().filter(e -> e.hashCode() != this.hashCode()).map(e -> e.name).collect(Collectors.joining());
			String parents = this.parents == null ? "null"
				: this.parents.getCouple().stream().map(e->e.name).collect(Collectors.joining(","));

		String temp = String.format(
				"[Name : %6s, Sex : %1S, Partner : %6s, Parent : %13s, RelationObj : %12s, PerentObj : %12s ]",
				this.name, this.gender, partner, parents, this.partner == null ? "null" : this.partner.hashCode(),
				this.parents == null ? "null" : this.parents.hashCode());

		return temp;
	}

	@Override
	public void getMarried(Person spouse) {

		this.partner = new Relation();
		this.partner.addCouple(this, spouse);
		spouse.partner = this.partner;

		Main.persons.put(spouse.name, spouse);
	}

	@Override
	public void haveChild(Person... childs) {
		Arrays.stream(childs).parallel().forEach(e -> {
			e.parents = this.partner;
			this.partner.addChild(e);
			Main.persons.put(e.name, e);
		});

	}

}
