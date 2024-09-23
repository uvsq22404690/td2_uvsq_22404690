package fr.uvsq.cprog.mvnjunit;

public class ChaineCryptee {
    private String chaineEnClair;
    private int decalage;

    private ChaineCryptee(String chaine, int decalage) {
        this.decalage = decalage;
        this.chaineEnClair = chaine;
    }

    public static ChaineCryptee deEnClair(String chaine, int decalage) {
        return new ChaineCryptee(chaine, decalage);
    }

    public static ChaineCryptee deCryptee(String chaine, int decalage) {
        ChaineCryptee instance = new ChaineCryptee("", decalage);
        instance.chaineEnClair = instance.decrypte(chaine);
        return instance;
    }

    public String crypte() {
        return transformer(chaineEnClair, decalage);
    }

    public String decrypte(String chaine) {
        return transformer(chaine, -decalage);
    }

    private String transformer(String chaine, int decalage) {
        StringBuilder result = new StringBuilder();
        for (char c : chaine.toCharArray()) {
            if (c == ' ') {
                result.append(c);
            } else {
                result.append(decaleCaractere(c, decalage));
            }
        }
        return result.toString();
    }

    private char decaleCaractere(char c, int decalage) {
        return (char) ((c - 'A' + decalage + 26) % 26 + 'A');
    }
}
