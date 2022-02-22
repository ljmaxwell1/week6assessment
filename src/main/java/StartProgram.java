/**
 *Larry J Maxwell - ljmaxwell1@dmacc.edu
 *CIS175 - Spring 2022
 *Feb 1, 2022
 **/

import java.util.List;
import java.util.Scanner;
import controller.ListNameHelper;
import model.ListName;

public class StartProgram {
		static Scanner in = new Scanner(System.in);
		static ListNameHelper lih = new ListNameHelper();

		private static void addAName() {
			System.out.print("Enter a Family Name: ");
			String familyName = in.nextLine();
			System.out.print("Enter an Given Name: ");
			String givenName = in.nextLine();
			ListName toAdd = new ListName(familyName, givenName);
			lih.insertName(toAdd);
		}

		private static void deleteAName() {
			System.out.print("Enter the Family Name to delete: ");
			String familyName = in.nextLine();
			System.out.print("Enter the Given Name to delete: ");
			String givenName = in.nextLine();
			ListName toDelete = new ListName(familyName, givenName);
			lih.deleteName(toDelete);
		}

		private static void editAName() {
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Family Name");
			System.out.println("2 : Search by Given Name");
			int searchBy = in.nextInt();
			in.nextLine();
			List<ListName> foundNames;
			if (searchBy == 1) {
				System.out.print("Enter the Family Name: ");
				String familyName = in.nextLine();
				foundNames = lih.searchForFamilyName(familyName);
			} else {
				System.out.print("Enter the Given Name: ");
				String givenName = in.nextLine();
				foundNames = lih.searchForGivenName(givenName);
			}
			if (!foundNames.isEmpty()) {
				System.out.println("Found Results.");
				for (ListName l : foundNames) {
					System.out.println(l.getId() + " : " + l.getFamilyName() + ", " + l.getGivenName());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();
				ListName toEdit = lih.searchForItemById(idToEdit);
				System.out.println("Retrieved: " + toEdit.getFamilyName() + ", " + toEdit.getGivenName() );
				System.out.println("1 : Update Family Name");
				System.out.println("2 : Update Given Name");
				int update = in.nextInt();
				in.nextLine();
				if (update == 1) {
					System.out.print("New Family Name: ");
					String newFamilyName = in.nextLine();
					toEdit.setFamilyName(newFamilyName);
				} else if (update == 2) {
					System.out.print("New Given Name: ");
					String newGivenName = in.nextLine();
					toEdit.setGivenName(newGivenName);
				}
				lih.updateName(toEdit);
			} else {
				System.out.println("---- No results found");
			}
		}

		public static void main(String[] args) {
			runMenu();
		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("*** Thanks for using my genealogy database ***");
			while (goAgain) {
				System.out.println("*  Select an action to complete:");
				System.out.println("*  1 -- Add a name");
				System.out.println("*  2 -- Edit a name");
				System.out.println("*  3 -- Delete a name");
				System.out.println("*  4 -- View the database");
				System.out.println("*  5 -- Exit the genealogy program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();
				if (selection == 1) {
					addAName();
				} else if (selection == 2) {
					editAName();
				} else if (selection == 3) {
					deleteAName();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}
			}
		}

		private static void viewTheList() {
			List<ListName>allNames=lih.showAllNames();
			for(ListName singleName : allNames) {
				System.out.println(singleName.returnNameDetails());
				
			}
		}
	}
