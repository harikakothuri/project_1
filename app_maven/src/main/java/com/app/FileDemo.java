package com.app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.app.bo.FilesBO;
import com.app.bo.impl.FilesImplem;

public class FileDemo {
	public static void main(String args[]) throws IOException {
		Scanner scanner = new Scanner(System.in);
		File path = new File("F:\\Harika");
		File list[] = path.listFiles();
		ArrayList<File> files = new ArrayList<File>();
		for (File f : list) {
			files.add(f);
		}
		System.out.println("Welcome to the File app");
		System.out.println("Developer details:");
		System.out.println("Harika - Full Stack Developer");
		FilesBO fbo = new FilesImplem();
		int option = 0;
		do {
			System.out.println("------------------------------------------------------");
			System.out.println("Select one of the options below:");
			System.out.println("1) Select 1 to print Ascending order of the Files");
			System.out.println("2) Select 2 for adding, deleting and searching a file");
			System.out.println("3) Exit");
			System.out.println("------------------------------------------------------");
			System.out.println("Your option:");
			option = scanner.nextInt();
			switch (option) {
			case 1: {
				System.out.println("Printing the files in Ascending order:");
				Collections.sort(files);
				for (File f : files) {
					System.out.println(f.getName());
				}
				break;
			}
			case 2: {
				System.out.println("Select one of the three options below:");
				int op1 = 0;
				do {
					Scanner sc = new Scanner(System.in);
					System.out.println("--------------------------------------");
					System.out.println("1)Adding a file to the directory");
					System.out.println("2)Deleting a file from the directory");
					System.out.println("3)Search a file in the directory");
					System.out.println("4)Back to the main options");
					System.out.println("--------------------------------------");
					System.out.println("Your option:");
					op1 = scanner.nextInt();
					switch (op1) {

					case 1: {
						System.out.println("Enter the file name to add:");
						String addFile = sc.nextLine();
						try {
							fbo.add(addFile, path, files);
						} catch (Exception e) {
							System.out.println("Exception " + e);
						}

						break;
					}
					case 2: {
						System.out.println("Enter the file name to delete:");
						String delFile = sc.nextLine();
						try {
							fbo.delete(delFile, path, files);
						} catch (Exception e) {
							System.out.println("Exception " + e);
						}
						break;
					}
					case 3: {
						System.out.println("Enter the file name to search:");
						String searchFile = sc.nextLine();
						try {
							fbo.search(searchFile, path, files);
						} catch (Exception e) {
							System.out.println("Excpetion " + e);
						}

						break;
					}
					case 4: {
						System.out.println("Go back!");
						break;
					}
					default: {
						System.out.println("Invalid option. Please try again!");
					}
					}
				} while (op1 != 4);

				break;
			}
			case 3:
				System.out.println("Thankyou!!!");
				System.out.println("-----------");
				break;
			default:
				System.out.println("Invalid Option, Please try again!");
			}
		} while (option != 3);
	}
}
