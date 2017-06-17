package com.yoxnet.common.file;

import java.io.File;
import java.io.IOException;
import java.net.ConnectException;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

public class OfficetoPdfUtil {
	/**
	 * office文件转PDF
	 * @param sourceFile office源文件路径
	 * @param destFile
	 * @return
	 */
	public static void createPDF(String sourceFile, String destFile) {
		try {
			File inputFile = new File(sourceFile);
			// 如果目标路径不存在, 则新建该路径
			File outputFile = new File(destFile);
			if (!outputFile.getParentFile().exists()) {
				outputFile.getParentFile().mkdirs();
			}
			
			// connect to an OpenOffice.org instance running on port 8100
			OpenOfficeConnection connection = new SocketOpenOfficeConnection(
					"127.0.0.1", 8100);
			connection.connect();

			// convert
			DocumentConverter converter = new OpenOfficeDocumentConverter(
					connection);
			converter.convert(inputFile, outputFile);

			// close the connection
			connection.disconnect();

		} catch (ConnectException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
