package fr.uvsq.cprog.mvnjunit;


public class ChaineCryptee {
    private String chaineEnClair;
    private String chaineCryptee;
    private int decalage;

    private ChaineCryptee(String chaine, int decalage) {
        this.decalage = decalage;
        this.chaineEnClair = chaine;
        this.chaineCryptee = crypte();
    }

    public static ChaineCryptee deEnClair(String chaine, int decalage) {
        return new ChaineCryptee(chaine, decalage);
    }

    public static ChaineCryptee deCryptee(String chaine, int decalage) {
        ChaineCryptee instance = new ChaineCryptee("", decalage);
        instance.chaineCryptee = chaine;
        instance.chaineEnClair = decrypte(chaine, decalage);
        return instance;
    }

    public String crypte() {
        StringBuilder result = new StringBuilder();
        for (char c : chaineEnClair.toCharArray()) {
            result.append(decaleCaractere(c, decalage));
        }
        return result.toString();
    }

    public String decrypte() {
        return chaineEnClair;
    }

    private static String decrypte(String chaine, int decalage) {
        StringBuilder result = new StringBuilder();
        for (char c : chaine.toCharArray()) {
            result.append(decaleCaractere(c, -decalage));
        }
        return result.toString();
    }

    private static char decaleCaractere(char c, int decalage) {
        if (c == ' ') return c;
        int base = 'A';
        return (char) ((c - base + decalage + 26) % 26 + base);
    }
}

