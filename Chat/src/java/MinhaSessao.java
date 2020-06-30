
import javax.websocket.Session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tonon
 */
public class MinhaSessao {
    private Session sessao;
    private Pessoa pessoa;

    public MinhaSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    public Session getSessao() {
        return sessao;
    }

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public String getNome() {
        return this.pessoa.getNome();
    }

    public void setNome(String nome) {
        this.pessoa.setNome(nome); 
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    
}
