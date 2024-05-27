package com.Herukles.CVBuilder.CV;

import com.Herukles.CVBuilder.CV.Models.CV;
import com.Herukles.CVBuilder.CV.Models.ContactInfo;
import com.Herukles.CVBuilder.CV.Models.PersonalInfo;
import com.itextpdf.testutils.ITextTest;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

@Component
public class CVGenerator {

    @Autowired
    public static ByteArrayOutputStream generatePDF(List<Map<String, Object>> queryResults) throws DocumentException, FileNotFoundException {
        Document document = new Document();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, outputStream);
        document.open();

        Map<String, Object> firstRow = queryResults.get(0);
        for (String column : firstRow.keySet()) {
            Font boldFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            Paragraph paragraph = new Paragraph(column, boldFont);
            document.add(paragraph);
        }
        document.add(new Paragraph("\n"));

        // Write data rows
        for (Map<String, Object> row : queryResults) {
            for (Object value : row.values()) {
                Paragraph paragraph = new Paragraph(value.toString());
                document.add(paragraph);
            }
            document.add(new Paragraph("\n"));
        }        document.close();
        return outputStream;
    }
}
