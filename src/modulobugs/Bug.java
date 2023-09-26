package modulobugs;

import javax.swing.JFileChooser;

/**
 *
 * @author joaoflorao
 */
public class Bug {
    private int id;
    private String titulo;
    private String status;
    private String descricao;
    private String reproducao;
    private String filename;
    private String classificacao;

    public Bug(
            int id, 
            String titulo,
            String status, 
            String descricao,
            String reproducao,
            String filename,
            String classificacao) 
    {
        this.id = id;
        this.titulo = titulo;
        this.status = status;
        this.descricao = descricao;
        this.reproducao = reproducao;
        this.filename = filename;
        this.classificacao = classificacao;
        
    }

    public int getId() 
    {
        return this.id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }
    
    public String getTitulo() 
    {
        return this.titulo;
    }

    public void setTitulo(String titulo) 
    {
        this.titulo = titulo;
    }

    public String getStatus() 
    {
        return this.status;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }
    
    public String getDescricao() 
    {
        return this.descricao;
    }

    public void setDescricao(String descricao) 
    {
        this.descricao = descricao;
    }
    
    public String getReproducao() 
    {
        return this.reproducao;
    }

    public void setReproducao(String reproducao) 
    {
        this.reproducao = reproducao;
    }
    
    public String getFilename() 
    {
        return this.filename;
    }

    public void setFilename(String filename) 
    {
        this.filename = filename;
    }
    
    public String getClassificacao() 
    {
        return this.classificacao;
    }

    public void setClassificacao(String classificacao) 
    {
        this.classificacao = classificacao;
    }

    @Override
    public String toString() 
    {
        return "id=" + id +
                ", Titulo='" + titulo + '\'' +
                ", Status='" + status + '\'' +
                ", Descricao='" + descricao + '\'' +
                ", Reproducao='" + reproducao + '\'' +
                ", Filename='" + filename + '\'' +
                ", Classificacao='" + classificacao + '\'';
    }
}
