package part1;

/**
 * File object to hold file related information - name, mimetype, extension, size
 * @author Suprabha
 *
 */

public class FileInfo {
	
	public FileInfo(String name, String mimeType, Long size, String extension) {
		this.name = name;
		this.mimeType = mimeType;
		this.size = size;
		this.extension = extension;
	}
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	private String mimeType;
	
	private Long size;
	
	private String extension;

}
