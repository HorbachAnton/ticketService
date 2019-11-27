package by.sam.horbach.ticketService.dto.forms;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileUploadDTO {

	private CommonsMultipartFile file;

	public FileUploadDTO() {

	}

	public FileUploadDTO(CommonsMultipartFile file) {
		this.file = file;
	}

	public CommonsMultipartFile getFile() {
		return file;
	}

	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}

}
