package modulobugs;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author joaoflorao
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        // Define o caminho do arquivo
        String filePath = "src/modulobugs/relatorio/bugs.csv";

        BugManager manager = new BugManager(filePath);

        // Lê os bugs do arquivo
        List<Bug> bugs = manager.Ler();
       

        // Mostra os bugs cadastrados
        for (Bug bug : bugs) {
            System.out.println(bug); // Exibe os detalhes de cada bug.
        }
       
    }
    
}
