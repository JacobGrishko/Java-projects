package animals;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<Animal> AnimalList = new ArrayList<Animal>();
		
		
		Owner o1 = new Owner("Jacob", "0541234567");
		Owner o2 = new Owner("Alex", "0541111111");
		Owner o3 = new Owner("dimitri", "0543333333");		
		
		Animal a1 = new Parrot("Tuki", "white", 60, o1);
		AnimalList.add(a1);
		Animal a2 = new Eagle("Baldy", "gray", 15);
		AnimalList.add(a2);
		Animal a3 = new Dog("Rexy", "gray", 3, o2);
		AnimalList.add(a3);
		Animal a4 = new Elephant("Dambo", "gray", 20);
		AnimalList.add(a4);
		Animal a5 = new Comodo("Smaug", "gray", 45);
		AnimalList.add(a5);
		Animal a6 = new Gecko("Itzik", "gray", 15, o3);
		AnimalList.add(a6);
		
		for (int i=0; i<AnimalList.size();i++)
		{
			AnimalList.get(i).toString();
			AnimalList.get(i).feed();
			AnimalList.get(i).sleep();
			AnimalList.get(i).special();
		}
		
		System.out.println("\n\n***Demonstration of clonening function:");
		Animal clone = a1.clone();
		System.out.println("***Original:");
		a1.toString();
		System.out.println("***Clone:");
		clone.toString();
		System.out.println("\n\n***changing parameters of the cloned animal's owner:");
		clone._owner.set_name("Shmulik");
		clone._owner.set_phoneNo("0529999999");
		System.out.println("***Original:");
		a1.toString();
		System.out.println("***Clone:");
		clone.toString();
		

	}

}
