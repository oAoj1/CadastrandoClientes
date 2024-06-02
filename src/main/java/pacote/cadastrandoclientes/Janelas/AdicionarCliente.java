package pacote.cadastrandoclientes.Janelas;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import pacote.cadastrandoclientes.Conexao;

public class AdicionarCliente extends JFrame {
    
    public AdicionarCliente() {
        
        /* PAINEL */ 
        
        setTitle("Adicionar Clientes");
        JLabel titulo = new JLabel("-> Cadastre um cliente");
        
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        
        add(titulo);
        
        /* NOME */
        
        JPanel painelNome = new JPanel();
        JLabel textoNome = new JLabel("Nome: ");
        JTextField inputNome = new JTextField(20);
        
        textoNome.setFont(new Font("Arial", Font.BOLD, 15));
        inputNome.setPreferredSize(new Dimension(450, 30));
        
        painelNome.add(textoNome);
        painelNome.add(inputNome);
        add(painelNome);
        
        /* SOBRE NOME */ 
        
        JPanel painelSobreNome = new JPanel();
        JLabel textoSobreNome = new JLabel("Sobre nome:");
        JTextField inputSobreNome = new JTextField(20);
        
        textoSobreNome.setFont(new Font("Arial", Font.BOLD, 15));
        inputSobreNome.setPreferredSize(new Dimension(450, 30));
        
        painelSobreNome.add(textoSobreNome);
        painelSobreNome.add(inputSobreNome);
        add(painelSobreNome);
        
        /* EMAIL */
        
        JPanel painelEmail = new JPanel();
        JLabel textoEmail = new JLabel("Email:");
        JTextField inputEmail = new JTextField(20);  
        
        textoEmail.setFont(new Font("Arial", Font.BOLD, 15));
        inputEmail.setPreferredSize(new Dimension(450, 30));
        
        painelEmail.add(textoEmail);
        painelEmail.add(inputEmail);
        add(painelEmail);
        
        /* BOTAO */
        
        JButton btnCadastrar = new JButton("Cadastrar");
        JPanel painelBtn = new JPanel();
        painelBtn.add(btnCadastrar);
        add(painelBtn);
        
        btnCadastrar.setPreferredSize(new Dimension(300, 55));
        btnCadastrar.setFont(new Font("Arial", Font.BOLD, 18));
        btnCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Conexao conexao = new Conexao();
                conexao.cadastrandoCliente(inputNome.getText(), inputSobreNome.getText(), inputEmail.getText());
            }  
            
        });
        
        /* PAINEIS */
        
        setLayout(new GridLayout(0,1));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    
        setVisible(true);
        setSize(500,500); 
        
    }
    
}
