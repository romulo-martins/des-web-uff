/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import dao.IngressoDao;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Ingresso;

/**
 *
 * @author Romulo
 */
@WebServlet("/imprimirIngresso")
public class ImprimirIngresso extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // obtem da requisição a conexão do banco de dados
        Connection connection = (Connection) req.getAttribute("conexao");

        int ingressoId = Integer.parseInt(req.getParameter("id"));
        Ingresso ingresso = new IngressoDao(connection).busca(ingressoId);

        try {
            ByteArrayOutputStream baos = getBaos(ingresso);
            resp.setHeader("Expires", "0");
            resp.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
            resp.setHeader("Pragma", "public");
            resp.setContentType("application/pdf");
            resp.setContentLength(baos.size());
            OutputStream os = resp.getOutputStream();
            baos.writeTo(os);
            os.flush();
            os.close();
        } catch (DocumentException ex) {
            Logger.getLogger(ImprimirIngresso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ByteArrayOutputStream getBaos(Ingresso ingresso) throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);
        document.open();
        document.add(new Paragraph("----- Ingresso ----- "));
        document.add(new Paragraph("Artista: " + ingresso.getEvento().getNome()));
        document.add(new Paragraph("Tipo: " + ingresso.getTipo()));
        document.add(new Paragraph("Preço: R$ " + ingresso.getValorPago()));
        document.add(new Paragraph("---------------------"));
        document.close();

        return baos;
    }
}
