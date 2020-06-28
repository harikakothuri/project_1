package com.app.bo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.app.exception.BusinessException;

public interface FilesBO {
	public void delete(String delFile, File path, ArrayList<File> files) throws BusinessException;

	public void add(String addFile, File path, ArrayList<File> files) throws BusinessException, IOException;

	public void search(String searchFile, File path, ArrayList<File> files) throws BusinessException;
}
