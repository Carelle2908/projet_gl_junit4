import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountCommentLines {
    public static void main(String[] args) {
        String filename = "TonFichier.java";
        int commentLines = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().startsWith("//") || line.trim().startsWith("/*")) {
                    commentLines++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Le nombre de lignes de commentaire dans " + filename + " est : " + commentLines);
    }
}
