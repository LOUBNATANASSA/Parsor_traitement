import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class apperence {

    //nalyser la phrase
    public static boolean parsePhrase(String phrase) {
        String[] words = phrase.split(" "); // Diviser la phrase en mots
        if (words.length < 3) return false; // Vérifier que la phrase a au moins 3 mots

        int index = 0;

        // Analyse du sujet
        if (index < words.length && parseNom(words[index])) {
            index++;
        } else if (index + 1 < words.length && parseArticle(words[index]) && parseNom(words[index + 1])) {
            index += 2;
        } else {
            return false; // Sujet invalide
        }

        // Analyse du verbe
        if (index < words.length && parseVerbe(words[index])) {
            index++;
        } else {
            return false; // Verbe invalide
        }

        // Analyse du complément
        if (index < words.length && parseNom(words[index])) {
            index++;
        } else if (index + 1 < words.length && parseArticle(words[index]) && parseNom(words[index + 1])) {
            index += 2;
        } else {
            return false; // Complément invalide
        }

        // La phrase doit être entièrement consommée
        return index == words.length;
    }

    // Vérifie si un mot est un nom valide
    private static boolean parseNom(String word) {
        String[] noms = {"fille","fromage", "fromages","fruit", "fruits","pain", "pains","légume", "légumes","gâteau", "gâteaux","soupe","souris", "soupes","pizza", "pizzas","viande", "viandes","salade", "salades","langage", "langages","discours","voix","conversation", "conversations","mot", "mots","idée", "idées","travail", "travaux","projet", "projets","devoir", "devoirs","livre", "livres","repas","tâche", "tâches","exercice", "exercices","paysage", "paysages","film", "films","image", "images","personne", "personnes","voiture", "voitures","tableau", "tableaux","spectacle", "spectacles","objet", "objets","activité", "activités","cuisine", "cuisines","ménage", "ménages","sport", "sports","voyage", "voyages","place", "places","question", "questions","décision", "décisions","transport", "transports","autorisation", "autorisations","aide", "aides","choix","envie", "envies","expérience", "expériences","relation", "relations","argent", "argents","temps","courage", "courages","réunion", "réunions","fête", "fêtes","moment", "moments","heure", "heures","événement", "événements","personne", "personnes","passion", "passions","sujet", "sujets","sport", "sports","musique","film", "films","histoire", "histoires","lettre", "lettres","magazine", "magazines","journal", "journaux","information", "informations","temps", "temps"};
        for (String nom : noms) {
            if (nom.equals(word)) {
                return true;
            }
        }
        return false;
    }

    // Vérifie si un mot est un article valide
    private static boolean parseArticle(String word) {
        String[] articles = {"le", "la", "les", "un", "une", "des"};
        for (String article : articles) {
            if (article.equals(word)) {
                return true;
            }
        }
        return false;
    }

    // Vérifie si un mot est un verbe valide
    private static boolean parseVerbe(String word) {
        String[] verbes = { "mange", "manges", "mangeons", "mangez", "mangent","parle", "parles", "parlons", "parlez", "parlent","finis", "finit", "finissons", "finissez", "finissent","suis", "es", "est", "sommes", "êtes", "sont","ai", "as", "a", "avons", "avez", "ont","vais", "vas", "va", "allons", "allez", "vont","aime", "aimes", "aime", "aimons", "aimez", "aiment","vois","voit", "voyons", "voyez", "voient","fais", "fait", "faisons", "faites", "font","sais", "sait", "savons", "savez", "savent","prends", "prend", "prenons", "prenez", "prennent","viens", "vient", "venons", "venez", "viennent","peux", "peut", "pouvons", "pouvez", "peuvent","dois", "doit", "devons", "devez", "doivent","mets", "met", "mettons", "mettez", "mettent","lis", "lit", "lisons", "lisez", "lisent"};
        for (String verbe : verbes) {
            if (verbe.equals(word)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //JFrame principal
        JFrame frame = new JFrame("Validation de phrase");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 200);
        //frame.setLayout(new FlowLayout());
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 20));

        //les composants
        JLabel promptLabel = new JLabel("Entrez une phrase :");
       // JLabel promptLabel2 = new JLabel("\n\n\nles verbes :");
        //JLabel promptLabel3 = new JLabel("les noms :");
        JTextField textField = new JTextField(20);
        //textField.setSize(90,50);
        JButton submitButton = new JButton("Valider");
        JLabel displayLabel = new JLabel("");

        // Ajouter les composants au JFrame
        frame.add(promptLabel);
        frame.add(textField);
        frame.add(submitButton);
        frame.add(displayLabel);
        frame.add(promptLabel2);
        frame.add(promptLabel3);

        // Ajouter un écouteur au bouton
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String phrase = textField.getText().trim(); // Récupérer le texte entré
                boolean result = parsePhrase(phrase); // Valider la phrase
                displayLabel.setText("Résultat : " + (result ? "Valide" : "Invalide"));
            }
        });

        // Rendre le JFrame visible
        frame.setVisible(true);
    }
}
