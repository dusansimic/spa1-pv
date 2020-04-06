class Program1 {
	public static void main(String[] args) {
		int n = Svetovid.in.readInt("Koliko karaktera unosite:");

		Lista lista = new Lista();
		for (int i = 0; i < n; i++) {
			lista.dodaj(Svetovid.in.readChar(String.format("Unesite %d. karakter:", i + 1)));
		}

		Svetovid.out.print("Velika slova: ");
		lista.ispisiVelika();

		Svetovid.out.print("Lista pre izbacivanja malih: ");
		Svetovid.out.println(lista);
		lista.izbaciMala();
		Svetovid.out.print("Lista posle izbacivanja malih: ");
		Svetovid.out.println(lista);

		Lista listaCifara = lista.izvdojiCifre();
		Svetovid.out.print("Izdvojene cife u drugu listu: ");
		Svetovid.out.println(listaCifara);
		Svetovid.out.print("Originalna lista bez cifara: ");
		Svetovid.out.println(lista);
	}
}