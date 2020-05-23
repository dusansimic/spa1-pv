/**
 * Tip podataka red opsluživanja, koji omogućava skladištenje podataka u skladu
 * sa principom "prvi unutra, prvi napolje".
 * 
 * <p>
 * Ova klasa koristi niz za skladištenje podataka, te je samim tim ograničena i
 * moguće je da metod za dodavanje elemenata baci izuzetak u slučaju da više
 * nema mesta.
 * </p>
 *
 * @version v1.0.0
 *
 * @param <T>
 *            Tip podataka koji će se čuvati u konkretnoj instanci reda
 *            opsluživanja.
 */
public class Red<T> {
	/**
	 * Separator vrednosti u {@code toString} metodu: {@value} .
	 */
	public static final String SEPARATOR = ", ";

	private int prvi, poslednji;
	private T[] elementi;

	/**
	 * Veličina redova za koje nije prosleđen parametar o veličini. Konkretna
	 * vrednost je {@value} .
	 */
	public static final int PODRAZUMEVANA_VELICINA = 100;

	/**
	 * Kreira novi red opsluživanja podrazumevane veličine
	 * {@value #PODRAZUMEVANA_VELICINA}.
	 */
	public Red() {
		this(PODRAZUMEVANA_VELICINA);
	}

	/**
	 * Kreira novi red opsluživanja zadate veličine.
	 * 
	 * @param n
	 *            broj elemenata koji red opsluživanja može maksimalno da primi.
	 */
	// poželjno koristiti Suppress da kompajliranje ne prijavljuje upozorenja
	@SuppressWarnings("unchecked")
	public Red(int n) {
		prvi = -1;
		poslednji = -1;
		elementi = (T[]) (new Object[n]);
	}

	/**
	 * Pomoćni metod za zadržavanje indeksa niza u opsegu. Metod uvek vraća
	 * indeks sledećeg elementa u odnosu na onaj koji je prosleđen. Sledeći
	 * element je za jedno mesto više od trenutnog, osim za poslednji kome je
	 * sledeći prvi.
	 * 
	 * @param i
	 *            indeks elementa za koji se traži sledeći
	 * @return indeks elementa koji je posle onog koji je prosleđen.
	 */
	private int dodajJedan(int i) {
		return (i + 1) % elementi.length;
	}

	/**
	 * Vraća da li je red prazan.
	 * 
	 * @return da li je red prazan
	 */
	public boolean jePrazan() {
		return poslednji == -1;
	}

	/**
	 * Vraća da li je red pun.
	 * 
	 * @return da li je red pun
	 */
	public boolean jePun() {
		return dodajJedan(poslednji) == prvi;
	}

	/**
	 * Vraća vrednost elementa na početku reda opsluživanja. Ukoliko je red
	 * prazan baca se izuzetak.
	 * 
	 * @return vrednost elementa na početku reda opsluživanja
	 */
	public T prvi() {
		if (jePrazan())
			throw new IllegalStateException("Red je prazan");
		else
			return elementi[prvi];
	}

	/**
	 * Izbacuje element sa početka reda opsluživanja i vraća ga. Ukoliko je red
	 * prazan baca se izuzetak.
	 * 
	 * @return vrednost elementa koji je bio na početku reda opsluživanja
	 */
	public T izbaciPrvi() {
		if (jePrazan()) {
			throw new IllegalStateException("Red je prazan");
		} else {
			T el = elementi[prvi];
			if (prvi == poslednji) {
				prvi = -1;
				poslednji = -1;
			} else
				prvi = dodajJedan(prvi);
			return el;
		}
	}

	/**
	 * Ubacuje prosleđeni element na kraj reda opsluživanja. Ukoliko je red već
	 * pun baca se izuzetak.
	 * 
	 * @param x
	 *            element koji će biti ubačen na kraj reda
	 */
	public void naKraj(T x) {
		if (jePun())
			throw new IllegalStateException("Red je pun");
		else {
			if (jePrazan()) {
				prvi = 0;
				poslednji = 0;
			} else
				poslednji = dodajJedan(poslednji);
			elementi[poslednji] = x;
		}
	}

	/**
	 * Vraća String reprezentaciju ovog Reda. Reprezentacija će sadržati
	 * najviše 4 elementa iz reda, tačnije najviše prva dva i poslednja dva,
	 * razdvojenih sa {@value #SEPARATOR}, a ukoliko ima više od 4 elementa biće
	 * dodato i "..." između prvih i poslednjih elemenata.
	 */
	public String toString() {
		String rez = "Red:";

		if (jePrazan()) {
			rez += "prazan";
		} else {
			rez += elementi[prvi];
			if (prvi != poslednji) {
				int drugi = dodajJedan(prvi);
				rez += SEPARATOR + elementi[drugi];
				if (drugi != poslednji) {

					int predposlednji = poslednji - 1;
					if (poslednji == 0) {
						predposlednji = elementi.length - 1;
					}
					
					if (predposlednji != drugi) {
						if (dodajJedan(drugi) != predposlednji) {
							rez += SEPARATOR + "...";
						}
						rez += SEPARATOR + elementi[predposlednji];
					}
					rez += SEPARATOR + elementi[poslednji];
				}
			}
		}
		return rez;
	}
}