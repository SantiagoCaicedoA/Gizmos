package sait.gizmo.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import sait.gizmo.problemdomain.Gizmo;

public class RetailManager {
	private ArrayList<Gizmo> gizmos;
	private Scanner keyboard;

	public RetailManager() throws IOException {
		gizmos = new ArrayList<>();
		loadGizmosFromFile();
		printGizmoList();
		displayMenu();
		saveGizmoListToFile();
	}

	private void displayMenu() {

		System.out.println("\n1. add ");
		System.out.println("2. delete ");
		System.out.println("3. update ");
		System.out.println("4. search");
		System.out.println("5. Quit the program");

		keyboard = new Scanner(System.in);
		int choice = keyboard.nextInt();
		keyboard.nextLine();
		switch (choice) {
		case 1:
			addGizmo();
			break;
		case 2:
			deleteGizmo();
			break;
		case 3:
			updateGizmo();
			break;
		case 4:
			searchGizmo();
			break;
		case 5:
			System.exit(0);

		}

	}

	private void addGizmo() {
		System.out.println("Please enter the gizmo information using the following format name;quantity;price");
		System.out.println("\nAdding...\n");
		String line = keyboard.nextLine();

		String[] fields = line.split(";");

		int id = gizmos.get(gizmos.size() - 1).getId() + 1;
		String name = fields[0];
		int quantity = Integer.parseInt(fields[1]);
		double price = Double.parseDouble(fields[2]);

		Gizmo gizmo = new Gizmo(id, name, quantity, price);
		gizmos.add(gizmo);
	}

	private void deleteGizmo() {
		System.out.println("Enter the id of the gizmo to delete: ");
		System.out.println("\nDeleting...\n");
		int id = keyboard.nextInt();
		int indexOfFound = -1;
		boolean found = false;
		for (int i = 0; i < gizmos.size() && !found; i++) {
			if (gizmos.get(i).getId() == id && gizmos.get(i).isActive()) {
				indexOfFound = i;
				found = true;
			}
		}
		if (indexOfFound != -1) {
			gizmos.remove(indexOfFound);
		} else {
			System.out.println("Gizmo not found!");
		}

	}

	private void updateGizmo() {
		System.out.println("1. Updating - by name: ");
		System.out.println("\nUpdating...\n");
		System.out.println("2. Updating - by id: ");
		int choice = keyboard.nextInt();
		keyboard.nextLine();
		boolean found = false;
		int indexOfFound = -1;
		if (choice == 1) {
			System.out.println("Enter the name of the gizmo to update:");
			String name = keyboard.nextLine();

			for (int i = 0; i < gizmos.size() && !found; i++) {
				if (gizmos.get(i).getName().equalsIgnoreCase(name) && gizmos.get(i).isActive()) {
					indexOfFound = i;
					found = true;
				}
			}
		} else if (choice == 2) {
			System.out.println("Enter the id of the gizmo to update:");
			int id = keyboard.nextInt();
			for (int i = 0; i < gizmos.size() && !found; i++) {
				if (gizmos.get(i).getId() == id && gizmos.get(i).isActive()) {
					indexOfFound = i;
					found = true;
				}
			}
		}
		if (indexOfFound != -1) {
			System.out.println("Currently " + gizmos.get(indexOfFound));
			System.out.println("Enter the new quantity");
			int quantity = keyboard.nextInt();
			gizmos.get(indexOfFound).setQuantity(quantity);
		} else {
			System.out.println("Gizmo not found!");
		}

	}

	private void searchGizmo() {

		System.out.println("Searching - Enter the name of the gizmo to search:");
		String name = keyboard.nextLine();
		for (int i = 0; i < gizmos.size(); i++) {
			if (gizmos.get(i).getName().equalsIgnoreCase(name) && gizmos.get(i).isActive()) {
				System.out.println(gizmos.get(i));
				return;
			}
		}

		System.out.println(name + " Gizmo not found!");

	}

	private void printGizmoList() {
		for (Gizmo gizmo : gizmos) {
			System.out.println(gizmo);
		}

	}

	private void loadGizmosFromFile() throws FileNotFoundException {
		Scanner in = new Scanner(new File("res/gizmos.txt"));
		while (in.hasNext()) {
			String line = in.nextLine();
			// System.out.println(line);
			String[] fields = line.split(";");

			int id = Integer.parseInt(fields[0]);
			String name = fields[1];
			int quantity = Integer.parseInt(fields[2]);
			double price = Double.parseDouble(fields[3]);

			Gizmo gizmo = new Gizmo(id, name, quantity, price);
			gizmos.add(gizmo);
		}

		in.close();

	}

	private void saveGizmoListToFile() throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter("res/gizmos.txt"));
		for (Gizmo gizmo : gizmos) {
			if (gizmo.isActive()) {
				out.println(gizmo);
			}
		}
		out.close();

	}

}
