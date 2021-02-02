import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;

public class pdfMaker_v2 {
    public static final String FONT_PATH = "assets/Font/consola.ttf";
    //added parameters
    public void write(Graph graph,String src) {
        OutputStream file = null;
        try {
            file = new FileOutputStream(new File("Receipt.pdf"));

            // Create a new Document object
            Document document = new Document();

            // You need PdfWriter to generate PDF document
            PdfWriter.getInstance(document, file);

            // Set Font

            /*
            FontFactory.register(FONT_PATH, "CONSOLA");*/
            Font font0 = FontFactory.getFont("CONSOLA",14);
            Font font1 = FontFactory.getFont(FontFactory.HELVETICA, 16, BaseColor.BLACK);

            // Opening document for writing PDF
            document.open();

            // Writing content
            document.add(new Paragraph("Hamburger Time Corporation", font1));
            document.add(new Paragraph("Burgers Everyday!", font1));
            document.add(new Paragraph(" ", font1));


          //  document.add(new Paragraph(String.valueOf(graph.getAllFriends(src)),font1));
            //document.add(new Paragraph(graph.getAllFriends(src).forEach(System.out::println),font1);

            //Get time
            document.add(new Paragraph("Time & Date:", font0));
            Date date = new Date(System.currentTimeMillis());

            //Display Time
            String timeF;
            SimpleDateFormat formatterT = new SimpleDateFormat("HH:mm:ss");
            timeF = formatterT.format(date);
            document.add(new Paragraph(timeF, font0));
            String dateF;
            SimpleDateFormat formatterD = new SimpleDateFormat("MM-dd-yyyy");
            dateF = formatterD.format(date);
            document.add(new Paragraph(dateF, font0));

            //Display Receipt
            document.add(new Paragraph(" "));
            document.add(new Paragraph("OFFICIAL RECEIPT"));

            //Display ordered items and prices

            PdfPTable t = new PdfPTable(2);
            t.getDefaultCell().setBorder(0);
            document.add(new Paragraph(" "));
            for (String element : graph.getAllOrders(src)) {
                t.addCell(element);
                t.addCell(Integer.toString(graph.getPrice()));
            }
            document.add(t);

            // Add meta data information to PDF file
            document.addCreationDate();
            document.addAuthor("Hamburger Time POS");
            document.addTitle("Receipt");
            document.addCreator("Java iText");

            // close the document
            document.close();

            System.out.println("Your PDF File is successfully created"); //for debugging

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            // closing FileOutputStream
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException ignored) { }
        }
    }
}

//PDF Maker codes: //https://www.javacodegeeks.com/2020/11/how-to-create-pdf-file-in-java-itext-example.html
//PDF Table codes: https://kb.itextpdf.com/home/it5kb/examples/101-a-very-simple-table
//Table border: https://stackoverflow.com/questions/4900514/an-invisible-border-of-pdfptable
//Get time: https://stackabuse.com/how-to-get-current-date-and-time-in-java/
//Consola Font: https://www.download-free-fonts.com/details/95277/consolas
//Change Font: https://kb.itextpdf.com/home/it5kb/examples/using-fonts
