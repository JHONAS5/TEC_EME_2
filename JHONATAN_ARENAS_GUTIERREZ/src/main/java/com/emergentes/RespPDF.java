
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;


@WebServlet(name = "RespPDF", urlPatterns = {"/RespPDF"})
public class RespPDF extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=archivo.pdf");
        
        try (PDPageContentStream out = new PDPageContentStream(document, page)) {
            // Agregamos contenido al PDF
            out.setFont(PDType1Font.HELVETICA_BOLD, 12);
            out.beginText();
            out.newLineAtOffset(100, 700); // Posición del texto en la página
            out.showText("JHOANTAN ARENAS CON UN ARCHIVO SERVET");
            out.endText();
        }
        try {
            document.save(response.getOutputStream());
            document.close();
            } catch (IOException e) {
            e.printStackTrace();
            }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
