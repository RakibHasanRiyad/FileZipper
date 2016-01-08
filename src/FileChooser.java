import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.JFileChooser;


public class FileChooser {

	static private JFileChooser chooser = new JFileChooser();
	
	public FileChooser()
	{
		
	}
	
	public void chooseFile()
	{
		chooser.setCurrentDirectory(new File("C:\\Users\\rHr\\Desktop"));
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.showSaveDialog(null);
//		System.out.println(chooser.getSelectedFile().toString());
	}
	
	public String fileName()
	{
		return chooser.getSelectedFile().toString();
	}
	

	  static public void zipFolder(String srcFolder, String destZipFile) throws Exception {
	    ZipOutputStream zip = null;
	    FileOutputStream fileWriter = null;

	    fileWriter = new FileOutputStream(destZipFile);
	    zip = new ZipOutputStream(fileWriter);

	    addFolderToZip("", srcFolder, zip);
	    zip.flush();
	    zip.close();
	  }

	  static private void addFileToZip(String path, String srcFile, ZipOutputStream zip)
	      throws Exception {

	    File folder = new File(srcFile);
	    if (folder.isDirectory()) {
	      addFolderToZip(path, srcFile, zip);
	    } else {
	      byte[] buf = new byte[1024];
	      int len;
	      FileInputStream in = new FileInputStream(srcFile);
	      zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
	      while ((len = in.read(buf)) > 0) {
	        zip.write(buf, 0, len);
	      }
	    }
	  }

	  static private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip)
	      throws Exception {
	    File folder = new File(srcFolder);

	    for (String fileName : folder.list()) {
	      if (path.equals("")) {
	        addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
	      } else {
	        addFileToZip(path + "/" + folder.getName(), srcFolder + "/" + fileName, zip);
	      }
	    }
	  }
	
//	public static void main(String[] args) throws Exception {
//		FileChooser m = new FileChooser();
//
//		zipFolder( m.fileName(),m.fileName()+".zip");
//		
//		
//	}
	
}
