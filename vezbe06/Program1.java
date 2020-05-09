class Program1 {
	public static void main(String[] args) {
		Ulica ulica = new Ulica();

		ulica.dodajKucu(1);
		ulica.dodajOsobu("Dusan", 1);
		ulica.dodajKucu(5);
		ulica.dodajOsobu("Milica", 5);
		ulica.dodajKucu(2);
		ulica.dodajOsobu("Aleksandar", 2);
		ulica.dodajKucu(5);
		ulica.dodajOsobu("Isidora", 5);
		ulica.dodajKucu(4);
		ulica.dodajOsobu("Vladimir", 4);
		ulica.dodajKucu(3);
		ulica.dodajOsobu("Osoba", 3);
		ulica.dodajOsobu("Osoba", 3);
		ulica.dodajOsobu("Osoba", 3);

		Svetovid.out.println(ulica);

		Svetovid.out.println(ulica.najvecaSaVeceOdN(5));

		ulica.prebaciAuB(5, 1);

		Svetovid.out.println(ulica);
	}
}
