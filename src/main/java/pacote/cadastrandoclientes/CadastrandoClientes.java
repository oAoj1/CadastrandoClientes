package pacote.cadastrandoclientes;

import java.awt.*;
import java.awt.event.*;

import pacote.cadastrandoclientes.Janelas.AdicionarCliente;
import pacote.cadastrandoclientes.Janelas.Relatorio;
import pacote.cadastrandoclientes.Janelas.PDF;

import javax.swing.*;

public class CadastrandoClientes{

    public static void main(String[] args){  
        
        /* JANELA */
        JFrame janela = new JFrame("Cadastrando clientes");
        JLabel titulo = new JLabel("CADASTRAR");
        
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 50));
        
        janela.add(titulo);
        
        /* CADASTRO */
        JPanel painelCadastro = new JPanel();
        JButton btnCadastro = new JButton("Cadastrar");
        
        btnCadastro.setPreferredSize(new Dimension(250, 70));
        btnCadastro.setFont(new Font("Arial", Font.BOLD, 18));
        btnCadastro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        btnCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                AdicionarCliente janelaAdd = new AdicionarCliente();
            }  
            
        });
        
        painelCadastro.add(btnCadastro);
        janela.add(painelCadastro);    
        
        /* RELATORIO */ 
        JPanel painelRelatorio = new JPanel();
        JButton btnRelatorio = new JButton("Relatorio");
        
        btnRelatorio.setPreferredSize(new Dimension(250, 70));
        btnRelatorio.setFont(new Font("Arial", Font.BOLD, 18));
        btnRelatorio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        painelRelatorio.add(btnRelatorio);
        janela.add(painelRelatorio);
        
        btnRelatorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Relatorio janelaRelatorio = new Relatorio();
            }    
            
        });
        
        /* PDF */
        JPanel painelPdf = new JPanel();
        JButton btnPdf = new JButton("Gerar PDF");
        
        btnPdf.setPreferredSize(new Dimension(250, 70));
        btnPdf.setFont(new Font("Arial", Font.BOLD, 18));
        btnPdf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        painelPdf.add(btnPdf);
        janela.add(painelPdf);
        
        btnPdf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Conexao conexao = new Conexao();
                String dados = conexao.puxarDadosMysql();
                
                PDF.gerarPDF(dados);
            }
            
        });
        
        /* */
        
        janela.setLayout(new GridLayout(0,1));
        
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
        janela.setSize(500,500);
        janela.setLocationRelativeTo(null);
        
    }
}
