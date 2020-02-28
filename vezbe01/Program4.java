class Program4 {
	public static void main(String[] args) {
		String ime = Svetovid.in.readToken("Unesite ime koje trazite:");

		boolean doMore = true;
		while (Svetovid.in("imena.txt").hasMore() && doMore) {
			if (ime.equals(Svetovid.in("imena.txt").readToken())) {
				System.out.println(String.format("Ime %s je nadjeno u fajlu.", ime));
				doMore = false;
			}
		}

		if (doMore) {
			System.out.println(String.format("Ime %s nije nadjeno u fajlu!", ime));
		}
	}
}
