package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GeldbetragTest
{

    public void testKonstruktor()
    {
        Geldbetrag betrag1 = new Geldbetrag(3050);

        assertEquals(30, betrag1.getEuroAnteil());
        assertEquals(50, betrag1.getCentAnteil());
    }

    public void testEquals()
    {
        Geldbetrag betrag1 = new Geldbetrag(2000);
        Geldbetrag betrag2 = new Geldbetrag(3050);
        Geldbetrag betrag3 = new Geldbetrag(2000);

        assertEquals(betrag1, betrag3);
        assertFalse(betrag1.equals(betrag2));
        assertTrue(betrag1.equals(betrag3));
    }

    public void testHashCode()
    {
        Geldbetrag betrag1 = new Geldbetrag(3000);
        Geldbetrag betrag2 = new Geldbetrag(3000);

        assertEquals("HashCode bleibt bei zwei Aufrufen gleich",
                betrag1.hashCode(), betrag1.hashCode());
        assertEquals("HashCodes mit gleicher Uhrzeit sind gleich",
                betrag1.hashCode(), betrag2.hashCode());
    }

    public void testIstGueltig()
    {
        assertTrue(Geldbetrag.istGueltig(new Geldbetrag(300)));
        assertTrue(Geldbetrag.istGueltig(new Geldbetrag(0)));

        assertFalse(Geldbetrag.istGueltig(new Geldbetrag(-300)));
        assertFalse(Geldbetrag.istGueltig(new Geldbetrag(-1)));

    }

    public void testAddiere()
    {
        Geldbetrag betrag1 = new Geldbetrag(2000);
        Geldbetrag betrag2 = new Geldbetrag(3050);

        assertEquals(5050, Geldbetrag.addiere(betrag1, betrag2));
    }

    public void testSubtrahiere()
    {
        Geldbetrag betrag1 = new Geldbetrag(2000);
        Geldbetrag betrag2 = new Geldbetrag(3050);

        assertEquals(1050, Geldbetrag.subtrahiere(betrag2, betrag1));

    }

    public void testMultipliziere()
    {
        Geldbetrag betrag1 = new Geldbetrag(300);
        int multiplikator = 3;
        assertEquals(900, Geldbetrag.multipliziere(betrag1, multiplikator));
    }

    public void testIstGroesserGleich()
    {

    }

    public void testKonvertiereString()
    {
        String betrag1 = "900";
        String betrag2 = "0";
        String betrag3 = "3050";

        assertEquals(new Geldbetrag(900),
                Geldbetrag.konvertiereString(betrag1));
        assertEquals(new Geldbetrag(0), Geldbetrag.konvertiereString(betrag2));
        assertEquals(new Geldbetrag(3050),
                Geldbetrag.konvertiereString(betrag3));
    }

}
