package org.fun.movies;

public class Movie {
	String name;

	public String getName() {
		return name;
	}

	public Movie(String name, int amount, Actor actor) {
		this.name = name;
		this.amount = amount;
		this.actor = actor;
	}

	public int getAmount() {
		return amount;
	}

	public Actor getActor() {
		return actor;
	}

	int amount;
	Actor actor = Actor.Salman;

	@Override
	public String toString() {
//		return name;
		return name + " (" + actor + ")" + " Rs." + amount;
	}

}
