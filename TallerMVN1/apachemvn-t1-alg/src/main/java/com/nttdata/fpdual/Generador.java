package com.nttdata.fpdual;

import java.io.File;
import java.io.IOException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;

/**
 * Formación Centros
 * 
 * Apache Maven
 * 
 * @author NTT DATA
 * @author Álvaro Labrador García
 */
public class Generador {

    /**
     * Método principal que genera el código QR.
     *
     * @param args
     */
    public static void main(String[] args) {
    	/**Mi nombre*/
        String name = "Álvaro Labrador García";
        
        /**Nombre del archivo*/
        String filePath = "QRCode.png";
        
        /**Anchura del QR*/
        int width = 250;
        
        /**Altura del QR*/
        int height = 250;

        try {
            generateQRCodeImage(name, filePath, width, height);
            System.out.println("Código QR generado y guardado en: " + filePath);
        } catch (WriterException | IOException e) {
            System.err.println("Error al generar el código QR: " + e.getMessage());
        }
    }

    /**
     * Genera una imagen de código QR a partir de un texto.
     *
     * @param name El texto a codificar en el código QR.
     * @param width La anchura del código QR.
     * @param height La altura del código QR.
     * @param filePath La ruta donde se guardará la imagen del código QR.
     * @throws WriterException Si hay un error al escribir el código QR.
     * @throws IOException Si hay un error al guardar el archivo.
     */
    public static void generateQRCodeImage(String name, String filePath, int width, int height) throws WriterException, IOException {
        //Crear un nuevo QRCodeWriter
    	QRCodeWriter qrCodeWriter = new QRCodeWriter();
    	
    	// Generar la matriz de bits para el código QR
        BitMatrix bitMatrix = qrCodeWriter.encode(name, BarcodeFormat.QR_CODE, width, height);
        
        // Crear un archivo con la ruta especificada
        File archivo = new File(filePath);
        
        // Escribir la matriz de bits en el archivo en formato PNG
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", archivo.toPath());
    }
}
