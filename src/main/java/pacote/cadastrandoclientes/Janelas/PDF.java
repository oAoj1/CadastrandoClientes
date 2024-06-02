package pacote.cadastrandoclientes.Janelas;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public interface PDF {

    // Nota: escrevi em português ai já que cê gosta 👍

    // Não precisa de "public" porque estamos em uma "interface", mas eu deixo porque acho melhor
    // Pode ser apenas "gerar" também
    public static void gerarPDF(String dados) {
        FileNameExtensionFilter extensaoPDF = new FileNameExtensionFilter("Portable Document Format", "pdf");

        JFileChooser arquivoChooser = new JFileChooser(System.getenv("OneDrive") + "\\Área de Trabalho\\");
        arquivoChooser.setFileFilter(extensaoPDF);

        try {
            arquivoChooser.showSaveDialog(null);
            String arquivo = arquivoChooser.getSelectedFile().getAbsolutePath();

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(arquivo + ".pdf"));

            document.open();
            document.add(new Paragraph("Relatório de Clientes\n\n" + dados));
            document.close();

            JOptionPane.showMessageDialog(null, "PDF gerado com sucesso verifique '" + arquivo + "'");
            System.out.println("PDF gerado com sucesso verifique '" + arquivo + "'");

        } catch(DocumentException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Erro ao gerar o PDF " + e.getMessage());
            System.out.println("Erro ao gerar o PDF " + e.getMessage());

        }
    }

}