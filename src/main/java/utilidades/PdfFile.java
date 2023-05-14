/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import core.domain.Consentimiento;
import core.domain.process.Process;

/**
 *
 * @author diego.ramirez
 */
public class PdfFile {

    public PdfFile() {
    }

    public static void createPDF(String pathPdf, String HTML) {
        PdfWriter writer = null;
        try {
            ConverterProperties converterProperties = new ConverterProperties();
            writer = new PdfWriter(new File(pathPdf));
            PdfDocument pdfDocument = new PdfDocument(writer);
            pdfDocument.setDefaultPageSize(PageSize.LETTER);

            HtmlConverter.convertToPdf(HTML, pdfDocument, converterProperties);
        } catch (Exception ex) {
            Logger.getLogger(PdfFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Objects.requireNonNull(writer).close();
            } catch (IOException ex) {
                Logger.getLogger(PdfFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
