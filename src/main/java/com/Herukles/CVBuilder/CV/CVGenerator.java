package com.Herukles.CVBuilder.CV;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Component
public class CVGenerator {

    @Autowired
    public Document generatePDF() throws DocumentException, FileNotFoundException {
        Document document = new Document();

        PdfWriter.getInstance(document, new FileOutputStream("iTextHelloWorld.pdf"));
        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Chunk chunk = new Chunk("Hello World", font);

        document.add(chunk);
        document.close();
        return document;
    }
}
