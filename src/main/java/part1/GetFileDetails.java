package part1;

import java.util.List;

/**
 * Interface for service layer
 * @author Suprabha
 *
 */

public interface GetFileDetails {

	/**
	 * Returns list of all the files present in a directory
	 * @return List<FileInfo>
	 */
	public List<FileInfo> getFileInfo() ;

	/**
	 * Returns list of files with particular mime type in a directory
	 * @return List<FileInfo>
	 */
	public List<FileInfo> getFileForMimeType();


}
