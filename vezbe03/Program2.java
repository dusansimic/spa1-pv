class Program2 {
	public static void main(String[] args) {
		String filename1 = Svetovid.in.readToken("Unesite ime fajla za citanje:");

		Lista lista = new Lista();
		lista.ucitaj(filename1);

		String ime = Svetovid.in.readToken("Unesite ime:");
		if (!lista.includes(ime)) {
			lista.dodaj(new Node(ime));
			
			String filename2 = Svetovid.in.readToken("Unesite ime fajla za pisanje:");
			lista.snimi(filename2);
		}
	}
}