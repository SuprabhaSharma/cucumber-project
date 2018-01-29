package part1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation class for service layer GetFileDetails
 * @author Suprabha
 *
 */

public class GetFileDetailsImpl implements GetFileDetails{

	List<FileInfo> files = new ArrayList<FileInfo>();

	/**
	 * Returns list of all the files present in a directory as mention in properties file
	 * @return List<FileInfo>
	 */
	@Override
	public List<FileInfo> getFileInfo() {

		try {
			String name = FileUtil.loadProperty("location");
			Path currentDir = Paths.get(name);
			Files.newDirectoryStream(currentDir).forEach(path -> populateFileInfodate(path));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return files;
	}


	/**
	 * Returns list of files with particular mime type in a directory
	 * @return List<FileInfo>
	 */
	@Override
	public List<FileInfo> getFileForMimeType() {
		String inputType =  FileUtil.loadProperty("mimetype");
		return getFileInfo().stream().filter(info -> inputType.equals(info.getMimeType())).collect(Collectors.toList());
	}

	private void populateFileInfodate(Path path) {
		files.add(new FileInfo(path.getFileName().toString(),
				FileUtil.getContentType(path.toFile()),
				new Long(path.toFile().length()),
				FileUtil.getFileExtension(path.getFileName().toString())));

	}



}
