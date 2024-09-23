package fr.uvsq.cprog.mvnjunit;

import org.junit.Test;
import static org.junit.Assert.*;

public class ChaineCrypteeTest {

    @Test
    public void testCrypte() {
        ChaineCryptee chaine = ChaineCryptee.deEnClair("HELLO", 3);
        assertEquals("KHOOR", chaine.crypte());
    }

    @Test
    public void testDecrypte() {
        ChaineCryptee chaine = ChaineCryptee.deCryptee("KHOOR", 3);
        assertEquals("HELLO", chaine.decrypte("KHOOR"));
    }

    @Test
    public void testEspace() {
        ChaineCryptee chaine = ChaineCryptee.deEnClair("HELLO WORLD", 3);
        assertEquals("KHOOR ZRUOG", chaine.crypte());
    }

    @Test
    public void testDecrypteEspace() {
        ChaineCryptee chaine = ChaineCryptee.deCryptee("KHOOR ZRUOG", 3);
        assertEquals("HELLO WORLD", chaine.decrypte("KHOOR ZRUOG"));
    }

    @Test
    public void testCaractereSpecial() {
        ChaineCryptee chaine = ChaineCryptee.deEnClair("A B C", 1);
        assertEquals("B C D", chaine.crypte());
    }
}
