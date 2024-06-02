package pacote.cadastrandoclientes;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexao {   
    private final String dadosClientes;
    
    public Conexao(){
        String dados = "";

        try {
            String url = "jdbc:mysql://localhost:3306/cadastroclientes";
            Connection conexao = DriverManager.getConnection(url,"root","");
            ResultSet tabelaClientes = conexao.createStatement().executeQuery("SELECT * FROM clientes");

            int tamanho = 1;

            while(tabelaClientes.next()){
                String nome = tabelaClientes.getString("nome");
                String sobreNome = tabelaClientes.getString("sobrenome");
                String email = tabelaClientes.getString("email");

                // Esquece o StringBuilder, ele só deixa o código feio. Assim fica bem mais bonitnho
                dados += (
                    tamanho + "\n" +
                    "Nome: " + nome + " " + sobreNome + "\n" +
                    "Email: " + email + "\n\n"
                );

                tamanho++;
            }

        } catch(SQLException ex) {
            System.out.println("-----------------------------------------\nConexão com MySql não encontrada.\nERR? " + ex.getMessage() + "\nVocê provavelmente não tem acesso com o server.\n-----------------------------------------\n");
        }

        dadosClientes = dados.toString();
    }
    
    public String puxarDadosMysql(){
        return dadosClientes;
    }
    
    public void cadastrandoCliente(String nome, String sobrenome, String email){
        try{
            String url = "jdbc:mysql://localhost:3306/cadastroclientes";
            Connection conexao = DriverManager.getConnection(url,"root","");

            String inserirDado = "INSERT INTO clientes (nome, sobrenome, email) VALUES (?, ?, ?)";
            PreparedStatement declaracao = conexao.prepareStatement(inserirDado);

            declaracao.setString(1,nome);
            declaracao.setString(2,sobrenome);
            declaracao.setString(3,email);

            declaracao.executeUpdate();

            String mensagem = "Cliente inserido com sucesso, confira o relatorio";
            JOptionPane.showMessageDialog(null, mensagem);
            System.out.println(mensagem);
            
        }catch(SQLException ex){
            String mensagem = "-----------------------------------------\nErro ao cadastrar cliente.\nERR? " + ex.getMessage() + "\nVocê provavelmente não tem acesso com o server.\n-----------------------------------------\n";
            JOptionPane.showMessageDialog(null, mensagem);
            System.out.println(mensagem);
            
        }  
    }
    
}
