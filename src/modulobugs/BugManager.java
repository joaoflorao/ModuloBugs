package modulobugs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    
    public BugManager(){}

    public List<Bug> LerArquivo(String filepath) throws IOException 
    {
        List<Bug> bugs = new ArrayList<>();

        this.buffRead = new BufferedReader(new FileReader(filepath));
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


    // Método de edição de bugs para o usuário do tipo testador. 
    // SE o status do bug estiver "aberto".
    public void EditarBugAberto(
            int id,
            String titulo,
            String status,
            String descricao,
            String reproducao,
            String filename,
            String classificacao
    ) throws SQLException 
    {
        try {
            ConnectDB db = new ConnectDB();

            Connection conn = db.getConnection();

            Statement stmt = conn.createStatement();

            String sql_edit_bug_aberto = "UPDATE DBCode.tbl_bugs SET "
                    + "titulo = '"+titulo+"', "
                    + "status = '"+status+"', "
                    + "descricao = '"+descricao+"', "
                    + "reproducao = '"+reproducao+"', "
                    + "file = '"+filename+"', "
                    + "classificacao = '"+classificacao+"' WHERE id = '"+id+"'";

            stmt.execute(sql_edit_bug_aberto);

            JOptionPane.showMessageDialog(null, "Bug editado com sucesso!");
        }
        catch(SQLException e){
            System.out.println("Erro na operação com o Banco de dados: "+e.getMessage());
        }
        catch(Exception e){
            System.out.println("Erro: "+e.fillInStackTrace());
        }
    }
    

    // Método de edição de bugs para os usuários dev e testador.
    // Só será utilizado para o usuário testador SE o status do bug != "aberto"
    public void EditarStatusClassificacao(
            int id, 
            String status,
            String classificacao
    ) throws SQLException  
    {
        try {
            ConnectDB db = new ConnectDB();

            Connection conn = db.getConnection();

            Statement stmt = conn.createStatement();

            String sql_edit_status_class = "UPDATE DBCode.tbl_bugs SET "
                    + "status = '"+status+"', "
                    + "classificacao = '"+classificacao+"' WHERE id = '"+id+"'";

            stmt.execute(sql_edit_status_class);

            JOptionPane.showMessageDialog(null, "Bug editado com sucesso!");
        } 
        catch(SQLException e){
            System.out.println("Erro na operação com o Banco de dados: "+e.getMessage());
        }
        catch(Exception e){
            System.out.println("Erro: "+e.fillInStackTrace());
        }
    }
    
    // Cadastra o bug
    public void CadastrarBug(
        String titulo,
        String status,
        String descricao, 
        String reproducao,
        String filename,
        String classificacao
    ) throws SQLException
    {
        try {
            ConnectDB db = new ConnectDB();

            Connection conn = db.getConnection();

            Statement stmt = conn.createStatement();

            String sql_insert = "INSERT INTO DBCode.tbl_bugs(titulo, status, descricao, "
                    + "reproducao, file, classificacao) VALUES('"+titulo+"', '"+status+"', "
                    + "'"+descricao+"', '"+reproducao+"', '"+filename+"', '"+classificacao+"')";

            stmt.execute(sql_insert);
            JOptionPane.showMessageDialog(null, "Bug cadastrado com sucesso!");
        }
        catch(SQLException e){
            System.out.println("Erro na operação com o Banco de dados: "+e.getMessage());
        }
        catch(Exception e){
            System.out.println("Erro: "+e.fillInStackTrace());
        }
        
    }
    
    // Exclui o bug se o status dele for "aberto"
    public void ExcluirBug(int id) throws SQLException
    {
        try {
            ConnectDB db = new ConnectDB();

            Connection conn = db.getConnection();

            Statement stmt = conn.createStatement();

            ResultSet rs = this.ConsultarBug(id);

            String status = "";

            while (rs.next())
            {   
                status = rs.getString("status");
            }

            if (status.equals("Aberto"))
            {
                String sql_delete = "DELETE FROM DBCode.tbl_bugs WHERE id = " + id;

                stmt.execute(sql_delete);

                JOptionPane.showMessageDialog(null, "Bug " + id + " excluido com sucesso!");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Não é possível excluir o bug com o status: " + '"'+status+'"');
            }
        }
        catch(SQLException e){
            System.out.println("Erro na operação com o Banco de dados: "+e.getMessage());
        }
        catch(Exception e){
            System.out.println("Erro: "+e.fillInStackTrace());
        }
    }
    
    // Consulta o bug pelo id
    public ResultSet ConsultarBug(int id) throws SQLException
    {
        try {
            ConnectDB db = new ConnectDB();

            Connection conn = db.getConnection();

            Statement stmt = conn.createStatement();

            String sql_query = "SELECT * FROM DBCode.tbl_bugs WHERE id = " + id;

            ResultSet rs = stmt.executeQuery(sql_query);
            
            return rs;
        }
        catch(SQLException e){
            System.out.println("Erro na operação com o Banco de dados: "+e.getMessage());
        }
        catch(Exception e){
            System.out.println("Erro: "+e.fillInStackTrace());
        }
        return null;
    }
}