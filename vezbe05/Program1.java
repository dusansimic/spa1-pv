class Program1 {
	public static void main(String[] args) {
		ListaFilmova lista = new ListaFilmova();

		lista.dodaj("Martian");
		lista.dodajGlumca("Matt Damon", "Martian");
		lista.dodajGlumca("Matt Damon", "Martian");
		lista.dodaj("The Third Man");
		lista.dodajGlumca("Orson Welles", "The Third Man");
		lista.dodaj("Contagion");
		lista.dodajGlumca("Matt Damon", "Contagion");
		lista.dodaj("Four Rooms");
		lista.dodajGlumca("Quentin Tarantino", "Four Rooms");

		Svetovid.out.println(lista);

		lista.obrisiSaGlumcem("Matt Damon");

		Svetovid.out.println(lista);
	}
}