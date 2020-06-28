package com.app.bo.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.app.bo.FilesBO;
import com.app.exception.BusinessException;

public class FilesImplem implements FilesBO {

	@Override
	public void delete(String delFile, File path, ArrayList<File> files) throws BusinessException {
		boolean found = false;
		File file1 = new File(path + "\\" + delFile);
		for (File f : files) {
			found = delFile.equals(f.getName());
			if (found) {
				files.remove(file1);
				file1.delete();
				System.out.println("File deleted successfully");
				break;
			}
		}
		if (found == false) {
			throw new BusinessException("File not found");
		}

	}

	@Override
	public void add(String addFile, File path, ArrayList<File> files) throws BusinessException, IOException {
		File file = new File(path + "\\" + addFile);

		boolean result = false;
		result = file.createNewFile();
		if (result) {
			System.out.println("File created ");
			files.add(file);
		} else {
			throw new BusinessException("File Already exists");
		}
	}

	@Override
	public void search(String searchFile, File path, ArrayList<File> files) throws BusinessException {
		boolean found = false;

		for (File f : files) {
			found = searchFile.equals(f.getName());
			if (found) {
				System.out.println("File found");
				break;
			}
		}
		if (found == false) {

			throw new BusinessException("File not Found");

		}
	}
}
