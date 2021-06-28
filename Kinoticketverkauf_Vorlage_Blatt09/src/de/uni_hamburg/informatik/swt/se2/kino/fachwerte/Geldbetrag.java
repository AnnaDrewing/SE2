package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import java.util.HashMap;
import java.util.Map;

public final class Geldbetrag
{
    private int _euroAnteil;
    private int _centAnteil;

    private static Map<String, Geldbetrag> _werteMenge = new HashMap<String, Geldbetrag>();

    private Geldbetrag(int centbetrag)
    {
        _euroAnteil = centbetrag / 100;
        _centAnteil = centbetrag % 100;
    }

    private Geldbetrag(int euroAnteil, int centAnteil)
    {
        _euroAnteil = euroAnteil;
        _centAnteil = centAnteil;
    }

    public static Geldbetrag select(int euroAnteil, int centAnteil)
    {
        String key = euroAnteil + "," + centAnteil;
        if (!_werteMenge.containsKey(key))
        {
            _werteMenge.put(key, new Geldbetrag(euroAnteil, centAnteil));
        }

        return _werteMenge.get(key);
    }

    public boolean istGueltigerEuroAnteil(int euroAnteil)
    {
        return 0 <= euroAnteil && euroAnteil <= Integer.MAX_VALUE;
    }

    public boolean istGueltigerCentAnteil(int centAnteil)
    {
        return 0 <= centAnteil && centAnteil < 100;
    }

    /*
     * @require istAddierenMoeglich
     */
    public Geldbetrag addiere(Geldbetrag summand1, Geldbetrag summand2)
    {
        assert istAddierenMoeglich(summand1,
                summand2) : "Vorbedingung verletzt: istAddierenMoeglich(summand1, summand2)";
        int summe = summand1.getCentbetrag() + summand2.getCentbetrag();

        return select(summe / 100, summe % 100);
    }

    public boolean istAddierenMoeglich(Geldbetrag betrag1, Geldbetrag betrag2)
    {
        long euroBetrag = (long) betrag1.getEuroAnteil()
                + betrag2.getEuroAnteil();
        long centBetrag = (long) betrag1.getCentAnteil()
                + betrag2.getCentAnteil();

        if (centBetrag >= 100)
        {
            euroBetrag++;
        }

        return euroBetrag <= Integer.MAX_VALUE;
    }

    /*
     * @require istMultiplizierenMoeglich
     */
    public Geldbetrag multipliziere(Geldbetrag betrag, int faktor)
    {
        assert istMultiplizierenMoeglich(betrag,
                faktor) : "Vorbedingung verletzt: istMultiplizierenMoeglich()";
        int produkt = betrag.getCentbetrag() * faktor;

        return select(produkt / 100, produkt % 100);
    }

    /*
     * speichern intern als integer
     */
    public boolean istMultiplizierenMoeglich(Geldbetrag betrag, int faktor)
    {
        long euroBetrag = (long) betrag.getEuroAnteil() * faktor;
        long centBetrag = (long) betrag.getCentAnteil() * faktor;

        return euroBetrag + centBetrag <= Integer.MAX_VALUE;
    }

    public Geldbetrag subtrahiere(Geldbetrag betrag1, Geldbetrag betrag2)
    {
        if (istGroesserGleich(betrag1, betrag2))
        {
            int euroAnteil = betrag1.getEuroAnteil() - betrag2.getEuroAnteil();
            int centAnteil = betrag1.getCentAnteil() - betrag2.getCentAnteil();

            if (centAnteil < 0)
            {
                euroAnteil--;
                centAnteil += 100;
            }

            return select(euroAnteil, centAnteil);
        }

        return subtrahiere(betrag2, betrag1);
    }

    public boolean istGroesserGleich(Geldbetrag betrag1, Geldbetrag betrag2)
    {
        int euro1 = betrag1.getEuroAnteil();
        int euro2 = betrag2.getEuroAnteil();
        int cent1 = betrag1.getCentAnteil();
        int cent2 = betrag2.getCentAnteil();

        return euro1 > euro2 || (euro1 == euro2 && cent1 >= cent2);
    }

    public int getEuroAnteil()
    {
        return _euroAnteil;
    }

    public int getCentAnteil()
    {
        return _centAnteil;
    }

    private int getCentbetrag()
    {
        return _euroAnteil * 100;
    }

    public String getFormattiertenString()
    {
        return _euroAnteil + "," + _centAnteil;
    }

    public Geldbetrag toGeldbetrag(String betrag)
    {
        String[] split = betrag.split(",");
        int euroAnteil = Integer.valueOf(split[0]);
        int centAnteil = Integer.valueOf(split[1]);

        return select(euroAnteil, centAnteil);
    }

    public Geldbetrag toGeldbetrag(int betrag)
    {
        return select(betrag / 100, betrag % 100);
    }

}
