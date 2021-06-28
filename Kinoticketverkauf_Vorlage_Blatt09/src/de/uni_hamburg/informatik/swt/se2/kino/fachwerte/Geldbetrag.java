package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

public final class Geldbetrag
{

    //TODO Exemplarvariablen hier
    private final int _betrag;
    private final int _euroAnteil;
    private final int _centAnteil;

    //Konstruktor
    public Geldbetrag(int betrag)
    {
        _betrag = betrag;
        _euroAnteil = betrag / 100;
        _centAnteil = betrag % 100;
    }

    public int getEuroAnteil()
    {
        return _euroAnteil;
    }

    public int getCentAnteil()
    {
        return _centAnteil;
    }

    public int getBetrag()
    {
        return _betrag;
    }

    public static Geldbetrag addiere(Geldbetrag betrag1, Geldbetrag betrag2)
    {
        assert betrag1 != null : "Vorbedingung verletzt: num1 ist null";
        assert betrag2 != null : "Vorbedingung verletzt: num2 ist null";
        int addiert = betrag1.getBetrag() + betrag2.getBetrag();

        Geldbetrag neu = new Geldbetrag(addiert);
        return neu; //TODO MAX-VALUE check!
    }

    public static Geldbetrag subtrahiere(Geldbetrag betrag1, Geldbetrag betrag2)
    {
        assert betrag1 != null : "Vorbedingung verletzt: num1 ist null";
        assert betrag2 != null : "Vorbedingung verletzt: num2 ist null";
        assert Geldbetrag.istGroesserGleich(betrag1,
                betrag2) : "Vorbedingung verletzt: betrag1 kleiner als betrag2";

        int subtrahiert = betrag1.getBetrag() - betrag2.getBetrag();
        Geldbetrag neu = new Geldbetrag(subtrahiert);
        return neu; //TODO Min Value? 
    }

    public static Geldbetrag multipliziere(Geldbetrag betrag, int multiplikator)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public static boolean istGroesserGleich(Geldbetrag betrag1,
            Geldbetrag betrag2)
    {
        assert betrag1 != null : "Vorbedingung verletzt: betrag1 ist null";
        assert betrag2 != null : "Vorbedingung verletzt: betrag2 ist null";
        int euro1 = betrag1.getEuroAnteil();
        int euro2 = betrag2.getEuroAnteil();
        int cent1 = betrag1.getCentAnteil();
        int cent2 = betrag2.getCentAnteil();

        return euro1 > euro2 || euro1 == euro2 && cent1 >= cent2;
    }

    public String getFormattiertenString()
    {
        if (getCentAnteil() < 10)
        {
            return getEuroAnteil() + ",0" + getCentAnteil() + " Euro";
        }
        return getEuroAnteil() + "," + getCentAnteil() + " Euro";
    }

    private boolean equals(Geldbetrag betrag)
    {
        // TODO Auto-generated method stub
        return false;
    }

    public static Geldbetrag konvertiereString(String betrag)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public Geldbetrag konvertiereInt(int betrag)
    {
        return null;
    }//TODO do we need it? 

    public static boolean istGueltig(Geldbetrag betrag)
    {
        // TODO Auto-generated method stub
        return false;
    }

}
