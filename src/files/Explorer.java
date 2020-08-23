package files;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Explorer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Path path = Paths.get("C:\\Test");
		Long size = checkDirectory(path);
		System.out.println("Size: " + size);
		
	}
	
	private static Long checkDirectory(Path dir) throws IOException {
		Long size = (long) 0.0;
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
	           for (Path entry: stream) {
	        	   if (Files.isDirectory(entry)) {
	        		   size += checkDirectory(entry);
	   				} else {
	   					size += Files.size(entry);
	   				}
	           }
	       } catch (DirectoryIteratorException ex) {
	           // I/O error encounted during the iteration, the cause is an IOException
	           throw ex.getCause();
	       } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return size;
	}

}

