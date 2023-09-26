package modulobugs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author joaoflorao
 */
public class BugManager {
    private BufferedReader buffRead;
    private BufferedWriter buffWrite;
    private String filepath;
    
    public BugManager(String filepath){
        this.filepath = filepath;
    }

    public List<Bug> Ler() throws IOException 
    {
        List<Bug> bugs = new ArrayList<>();

        this.buffRead = new BufferedReader(new FileReader(this.filepath));
        String row;

        while ((row = buffRead.readLine()) != null) 
        {
            String[] col = row.split(";");
            if (col.length == 6) 
            {
                int id = Integer.parseInt(col[0]);
                String titulo = col[1];
                String status = col[2];
                String descricao = col[3];
                String reproducao = col[4];
                String file = col[5];
                String classificacao = col[6];
                Bug bug = new Bug(id, titulo, status, descricao, reproducao, file, classificacao);
                bugs.add(bug);
            }
        }

        buffRead.close();
        return bugs;
    }


    public void EditarBug(
            List<Bug> bugs, 
            int id, 
            String titulo,
            String status,
            String descricao,
            String reproducao) 
            throws IOException 
    {
        for (Bug bug : bugs) 
        {
            if (bug.getId() == id && bug.getStatus().equals("Aberto")) 
            {
                bug.setTitulo(titulo);
                bug.setStatus(status);
                bug.setDescricao(descricao);
                bug.setReproducao(reproducao);
                JOptionPane.showMessageDialog(null, 
                        "Bug editado com sucesso.");

                // Abre o arquivo para editar a linha do id informado.
                this.buffWrite = new BufferedWriter(new FileWriter(this.filepath));

                // Escreve todos os bugs atualizados no arquivo CSV.
                for (Bug bugAtualizado : bugs) 
                {
                    String row = bugAtualizado.getId() + ";" 
                            + bugAtualizado.getTitulo() + ";"
                            + bugAtualizado.getStatus() + ";"
                            + bugAtualizado.getDescricao() + ";" 
                            + bugAtualizado.getReproducao() + ";"
                            + bugAtualizado.getClassificacao() + ";";
                    buffWrite.write(row);
                    buffWrite.newLine();
                }

                buffWrite.close();

                return;
            }
            else if (bug.getId() == id)
            {
                JOptionPane.showMessageDialog(null, 
                        "Não é possível editar um bug com status: " + bug.getStatus());
            }
            else
            {
                JOptionPane.showMessageDialog(null, 
                        "Nenhum bug encontrado com o id: " + id);
            }
        }
    }
    

    public void EditarBugAberto(
            List<Bug> bugs, 
            int id, 
            String titulo,
            String status,
            String descricao,
            String reproducao,
            String filename,
            String classificacao) 
            throws IOException 
    {
        for (Bug bug : bugs) 
        {
            if (bug.getId() == id && bug.getStatus().equals("Aberto")) 
            {
                bug.setTitulo(titulo);
                bug.setStatus(status);
                bug.setDescricao(descricao);
                bug.setReproducao(reproducao);
                bug.setFilename(filename);
                bug.setClassificacao(classificacao);
                
                JOptionPane.showMessageDialog(null, 
                        "Bug editado com sucesso.");

                // Abre o arquivo para editar a linha do id informado.
                this.buffWrite = new BufferedWriter(new FileWriter(this.filepath));

                // Escreve todos os bugs atualizados no arquivo CSV.
                for (Bug bugEdit : bugs) 
                {
                    String row = bug.getId() + ";" 
                            + bugEdit.getTitulo() + ";"
                            + bugEdit.getStatus() + ";"
                            + bugEdit.getDescricao() + ";" 
                            + bugEdit.getReproducao() + ";"
                            + bugEdit.getFilename() + ";"
                            + bugEdit.getClassificacao() + ";";
                    buffWrite.write(row);
                    buffWrite.newLine();
                }

                buffWrite.close();

                return;
            }
            else if (bug.getId() == id)
            {
                JOptionPane.showMessageDialog(null, 
                        "Não é possível editar um bug com status: " + bug.getStatus());
            }
            else
            {
                JOptionPane.showMessageDialog(null, 
                        "Nenhum bug encontrado com o id: " + id);
            }
        }
    }


    public void Cadastrar(
            List<Bug> bugs, 
            String titulo,
            String status,
            String descricao, 
            String reproducao,
            String filename,
            String classificacao) 
            throws IOException 
    {
        int newId = 1;

        File arquivo = new File(this.filepath);

        // Se o arquivo existe, encontra o último ID e incrementa.
        if (arquivo.exists()) 
        {
            List<Bug> bugsList = Ler();
            if (!bugsList.isEmpty()) 
            {
                Bug lastBug = bugsList.get(bugsList.size() - 1);
                newId = lastBug.getId() + 1;
            }
        }

        Bug novoBug = new Bug(newId, titulo, status, descricao, reproducao, filename, classificacao);
        bugs.add(novoBug);

        // Abre o arquivo para adicionar a nova linha.
        this.buffWrite = new BufferedWriter(new FileWriter(this.filepath, true));

        // Escreve a nova linha no arquivo.
        String row = newId + ";" + titulo + ";" + status + ";" 
                + descricao + ";" + reproducao + ";" + filename + ";" + classificacao;
        buffWrite.write(row);
        buffWrite.newLine();

        // Fecha o arquivo após a escrita.
        buffWrite.close();

        JOptionPane.showMessageDialog(null, 
                "Bug cadastrado com sucesso.");
    }
}