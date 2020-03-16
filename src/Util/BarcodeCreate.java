package Util;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class BarcodeCreate {

	    
	    private static final String QR_CODE_IMAGE_PATH = "./product4.png";

	    private static void generateQRCodeImage(String text, int width, int height, String filePath)
	            throws WriterException, IOException {
	    	MultiFormatWriter barcodeWriter = new MultiFormatWriter();
	        BitMatrix bitMatrix = barcodeWriter.encode(text, BarcodeFormat.CODE_128, width, height);

	        Path path = FileSystems.getDefault().getPath(filePath);
	        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
	    }

	    public static void main(String[] args) {
	        try {
	            generateQRCodeImage("4", 350, 350, QR_CODE_IMAGE_PATH);
	        } catch (WriterException e) {
	            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
	        } catch (IOException e) {
	            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
	        }
	    }

}
