import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
public class Menu {
	
	private Membership membership;

	private Scanner keyboard = new Scanner(System.in);
	
	LinkedList<Compatibility> compatibilityList;
	
	
	public Menu() {
		membership = new Membership();
		
	}

	
	public void run() throws InvalidInterestException, ClassNotFoundException, IOException {

	
		while(true) { 
			System.out.println("");
			System.out.println("Choose an option between 1-8:");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("1: Load Members                         |"
					+ "\n2: Save Members                         |"
					+ "\n3: List All Members                     |\n"
					+ "4: Add a Member                         |"
					+ "\n5: Remove a Member                      |"
					+ "\n6: List Member                          |\n"
					+ "7: Add an Interest to a Member          |"
					+ "\n8: Quit                                 |");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			int option;
			option = keyboard.nextInt();
	
				switch (option) {
				case 1:
					loadMembers();
					break;
					
				case 2:
					saveMembers();
					break;
			
				case 3:
					listAllMembers();
					break;
					
				case 4:
					addMember();
					break;
					
				case 5:
					removeMember();
					break;
					
				case 6:
					listMember();
					break;
					
				case 7:
					addInterest();
					break;
					
				case 8:
					System.exit(0);
					break;
					
				default:
					System.out.println("Invalid option choice");
					System.out.println("Try again");
				
			}
		}
	
	}
	
	
	private void loadMembers() throws ClassNotFoundException, IOException {
		keyboard.nextLine();
		System.out.println("Name: ");
		String name = keyboard.nextLine();
		
		
		membership = Membership.load(name);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(name + " loaded successfully.");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	}
		
	
	
	private void saveMembers() throws IOException {
		keyboard.nextLine();
		System.out.println("Name: ");
		String name = keyboard.nextLine();
		
		
		membership.save(name);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(name + " has been saved.");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");

		
	}
	
	private void listAllMembers() {
		
		System.out.println(membership.toString());
	}
	
	private void addMember() {
		keyboard.nextLine();
		System.out.println("Name: ");
		String name = keyboard.nextLine();
		
		if(membership.findMember(name) != null) {
			System.out.println("That member already exists");
			return;
		}

		System.out.println("Year (1-5): ");
		
		
		int year = keyboard.nextInt();
	
		
		
		try {
			Member member = new Member(name, year);
			membership.addMember(member);
		}catch(InvalidMemberException e) {
			System.out.println(e.getMessage());
		}
		}
	
	
	private void removeMember() {
		Iterator<Member> iter = membership.iterator();
		keyboard.nextLine();
		System.out.println("Member's name?");
		String name = keyboard.nextLine();
		if(membership.findMember(name) != null) {
			while(iter.hasNext()) {
				if(iter.next().getName().equalsIgnoreCase(name)) {
					iter.remove();
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println(name + " has been removed.");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
					return;
				}
			}
		}else {
			
			System.out.println("Member doesn't exist");
		}
	}
	

	private void listMember() {
		keyboard.nextLine();
		System.out.println("Member's name?");
		String name = keyboard.nextLine();
		if(membership.findMember(name) != null) {
			System.out.println(membership.findMember(name).toString());
			}else {
				
				System.out.println("Member doesn't exist");
				
			}
		
//		Iterator<Member> member = membership.iterator();
		for(Member member : membership) {
		Compatibility compatibility = new Compatibility(member, member);
		compatibilityList.add(compatibility);
		compatibilityList.sort(null);
		}
		
		
		for(Compatibility c : compatibilityList) {
			if(compatibilityList.size() <= 5) {
				int size = compatibilityList.size();
				for(int i=0; i<size; i++) {
					
				}
			}
		}
			
	}
	
	private void addInterest() throws InvalidInterestException {
		keyboard.nextLine();
		System.out.println("Member's Name: ");
		String name = keyboard.nextLine();
		
		
		if(membership.findMember(name) != null) {
			System.out.println("Add Interest: ");
			String topic = keyboard.nextLine();
			if(membership.findMember(name).findInterest(topic) != null) {
				System.out.println("Interest Level between 1-10: ");
				int level = keyboard.nextInt();
				membership.findMember(name).findInterest(topic).setLevel(level);
			}else {
				System.out.println("Interest Level between 1-10: ");
				int level = keyboard.nextInt();
				Interest interest = new Interest(topic, level);
				membership.findMember(name).addInterest(interest);
			}
			return;
			}else {
				System.out.println("Member doesn't exist");
			return;
		}

		}
	
	private LinkedList<Compatibility> getCombatibilityList(){
		return compatibilityList;
	}

	}
	



