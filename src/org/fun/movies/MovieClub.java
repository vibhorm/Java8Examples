package org.fun.movies;

import java.util.HashSet;
import java.util.Set;

public class MovieClub {
	private static Person ram = new Person("Ram");
	private static Person amit = new Person("Amit");
	private static Person vicky = new Person("Vicky");
	private static Person abbas = new Person("Abbas");

	private static Movie dabangg = new Movie("Dabangg", 250, Actor.Salman);
	private static Movie kick = new Movie("Kick", 300, Actor.Salman);
	private static Movie wanted = new Movie("Wanted", 200, Actor.Salman);
	private static Movie chennai = new Movie("Chennai Express", 200, Actor.Shahrukh);
	private static Movie ra1 = new Movie("RA One", 150, Actor.Shahrukh);
	private static Movie boss = new Movie("Boss", 225, Actor.AkshayKumar);
	private static Movie rowdy = new Movie("Rowdy Rathore", 250, Actor.AkshayKumar);
	private static Movie singham = new Movie("Singham", 250, Actor.AjayDevgn);
	private static Movie idiots3 = new Movie("Three Idiots", 350, Actor.AamirKhan);
	private static Movie dhoom3 = new Movie("DHOOM 3", 400, Actor.AamirKhan);
	private static Movie krrish = new Movie("Krrish 3", 350, Actor.Hritik);

	public static Set<Movie> ALL_MOVIES = new HashSet<>();
	public static Set<Person> ALL_MEMBERS = new HashSet<>();

	static  {
		ram.addMovie(dabangg);
		ram.addMovie(boss);
		ram.addMovie(chennai);

		amit.addMovie(singham);
		amit.addMovie(dabangg);
		amit.addMovie(kick);
		amit.addMovie(idiots3);

		vicky.addMovie(kick);
		vicky.addMovie(dabangg);
		vicky.addMovie(krrish);
		vicky.addMovie(dhoom3);

		abbas.addMovie(wanted);
		abbas.addMovie(ra1);
		abbas.addMovie(rowdy);
		abbas.addMovie(boss);

		areFriends(ram,amit);
		areFriends(ram,vicky);
		areFriends(abbas, amit);

		ALL_MEMBERS.add(ram);
		ALL_MEMBERS.add(amit);
		ALL_MEMBERS.add(vicky);
		ALL_MEMBERS.add(abbas);

		ALL_MOVIES.add(dabangg);
		ALL_MOVIES.add(kick);
		ALL_MOVIES.add(wanted);
		ALL_MOVIES.add(chennai);
		ALL_MOVIES.add(ra1);
		ALL_MOVIES.add(boss);
		ALL_MOVIES.add(rowdy);
		ALL_MOVIES.add(singham);
		ALL_MOVIES.add(idiots3);
		ALL_MOVIES.add(dhoom3);
		ALL_MOVIES.add(krrish);
	}

	private static void areFriends(Person p1, Person p2) {
		if (p1 != p2) {
			p1.makeFriend(p2);
			p2.makeFriend(p1);
		}
	}
	public static Person president(){
		return ram;
	}

	public static Set<Person> gang(){
		return ram.getFriendCircle();
	}
}


