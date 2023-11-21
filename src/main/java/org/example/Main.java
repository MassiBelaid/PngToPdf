package org.example;

import java.io.File;
import com.aspose.words.*;


public class Main {
    public static void main(String[] args) {
        File parent = new File("C:\\Users\\a833243\\OneDrive - Atos\\Bureau\\Déplacement-CD92");
        parcourir(parent);
        System.out.println("finish");
    }


    public static void parcourir(File directory) {
        for(File child: directory.listFiles()) {
            if (child.isFile()) {
                System.out.println("Fichier " + child.getName());
                tranform(child);
            }
            else {
                System.out.println("Dossier " + child.getName());
                parcourir(child);
            }
        }
    }

    public static void tranform(File file) {
        try {
            String fileName = file.getName();
            String[] fileNameSplit = fileName.split("\\.");
            if(fileNameSplit[fileNameSplit.length - 1].toLowerCase().equals("png") ||
                    fileNameSplit[fileNameSplit.length - 1].toLowerCase().equals("jpg")) {
                Document doc = new Document();
                DocumentBuilder documentBuilder = new DocumentBuilder(doc);

                String path = file.getPath();
                documentBuilder.insertImage(path);
                path = path.replace(".png", ".pdf");
                path = path.replace(".jpg",".pdf");

                doc.save(path);
                System.out.println("Fichier " + fileName + " transformé avec succés.");

            }
        } catch (Exception e) {
            System.out.println("Impossible pour " + file.getName());
        }
    }
}