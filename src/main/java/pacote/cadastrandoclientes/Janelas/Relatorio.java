package pacote.cadastrandoclientes.Janelas;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pacote.cadastrandoclientes.Conexao;

import javax.swing.*;

public class Relatorio extends JFrame{
    
    public Relatorio(){
        /* JANELA E TITULO*/
        setTitle("Relatorio clientes");
        
        JPanel painelTitulo = new JPanel();
        JLabel titulo = new JLabel("-> Relatorio clientes");
        JButton gerarPdf = new JButton("Gerar PDF");
        
        gerarPdf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Conexao conexao = new Conexao();
                String dados = conexao.puxarDadosMysql();
                
                PDF.gerarPDF(dados);
            }
            
        });
        
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        
        painelTitulo.add(titulo);
        painelTitulo.add(gerarPdf);
        
        add(painelTitulo);
        
        /* PUXAR CLIENTES */
        Conexao conexao = new Conexao();
        String dados = conexao.puxarDadosMysql();

        JTextArea areaTexto = new JTextArea();
        areaTexto.setFont(new Font("Arial", Font.PLAIN, 16));
        areaTexto.setEditable(false);
        areaTexto.setText(dados);
        
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        add(scrollPane);
        
        /* */
        setLayout(new GridLayout(0,1));
        setSize(700,500);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
}
