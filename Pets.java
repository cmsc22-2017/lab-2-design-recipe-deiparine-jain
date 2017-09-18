import tester.Tester;


// to represent a pet owner
class Person {
    String name;
    IPet pet;
    int age;

    Person(String name, IPet pet, int age) {
        this.name = name;
        this.pet = pet;
        this.age = age;
    }
    
  /*TEMPLATE
   Fields
	  ...this.name - string
	  ...this.pet - IPet
	  ...this.age - int
  
   Methods
   	...isOlder - boolean
   */

	boolean isOlder(Person other){
		return this.age > other.age;
	}
// Person -> boolean
// Returns true if this Person is older than the given Person
/* boolean isOlder(Person other) {
	 	return false;
 } */
	
/*TEMPLATE
  Fields
	  ...this.name - string
	  ...this.pet - IPet
	  ...this.age - int
 
  Methods
  	...perish - Person
*/

Person perish() {
		return new Person(this.name, new NoPet(), this.age);
}
	
//for method perish
// -> Person
//Produces this Person's name whose pet has perished
/* String perish() {
	return null;
}*/

}

class NoPet implements IPet{
	/*Person p;
	boolean hasPerished;
	
	NoPet(Person p, boolean hasPerished) {
		this.p = p;	
		this.hasPerished = hasPerished;
	}*/
	
	NoPet() {}

	@Override
	public boolean sameNamePet(String name) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/*public boolean sameNamePet(String name) {
  	return this.name.equals(name);
  }*/
	
}



// to represent a pet
interface IPet {
	boolean sameNamePet(String name); 
}

// to represent a pet cat
class Cat implements IPet {
    String name;
    String kind;
    boolean longhaired;

    Cat(String name, String kind, boolean longhaired) {
        this.name = name;
        this.kind = kind;
        this.longhaired = longhaired;
    }
    
    /*TEMPLATE
		Fields
	 ...this.name - string
	 ...this.kind - String
	 ...this.longhaired - boolean

		Methods
			...sameNamePet - boolean
*/
    
    public boolean sameNamePet(String name) {
    	return this.name.equals(name);
    }


    // for method sameNamePet
    //String -> boolean
    //Determines whether this name matches the given name
    /*boolean sameNamePet () {
    	return false;
    }*/
}

// to represent a pet dog
class Dog implements IPet {
    String name;
    String kind;
    boolean male;

    Dog(String name, String kind, boolean male) {
        this.name = name;
        this.kind = kind;
        this.male = male;
    }
    
    /*TEMPLATE
		Fields
	 ...this.name - string
	 ...this.kind - String
	 ...this.male - boolean

		Methods
			...sameNamePet - boolean
*/
    
    public boolean sameNamePet(String name) {
    	return this.name == name;
    }


    // for method sameNamePet
    //String -> boolean
    //Determines whether this name matches the given name
    /*boolean sameNamePet () {
    	return false;
    }*/
}


//Examples
class ExamplesPet {
	
	ExamplesPet() {}
	
	IPet snow = new Cat("Snow", "Himalayan", true);
	IPet ginger = new Cat("Ginger", "Ocicat", false);
	IPet darky = new Dog("Darky", "Doberman", true);
	IPet bella = new Dog("Bella", "Shih Tzu", false);
	
	NoPet noPet = new NoPet();
	
	Person shayne = new Person("Shayne", snow, 19);
	Person dianne = new Person("Dianne", ginger, 19);
	Person danny = new Person("Danny", darky, 32);
	Person franky = new Person("Franky", bella, 27);
	
	boolean testPet(Tester t){
		return 
				t.checkExpect(this.shayne.isOlder(dianne), false) &&
		    t.checkExpect(this.franky.isOlder(danny),false) &&
		    t.checkExpect(this.danny.isOlder(shayne),true) &&
		    t.checkExpect(this.franky.isOlder(dianne),true) &&
		    t.checkExpect(this.dianne.isOlder(danny), false) &&
		    t.checkExpect(this.franky.isOlder(shayne), true);
		
	}
	
	boolean testSameNamePet(Tester t) {
		return
				t.checkExpect(this.snow.sameNamePet("Olivia"), false) &&
				t.checkExpect(this.bella.sameNamePet("Edward"), false) &&
				t.checkExpect(this.ginger.sameNamePet("Ginger"), true) &&
				t.checkExpect(this.darky.sameNamePet("Darky"), true);
		
	}
	
	boolean testPerish(Tester t) {
		Person a = this.danny.perish();
		Person b = this.dianne.perish();
		Person c = this.franky.perish();
		
		return
				t.checkExpect(a.name, "Danny") &&
				t.checkExpect(a.pet, noPet) &&
				t.checkExpect(a.age, 32) &&
				t.checkExpect(b.name, "Dianne") &&
				t.checkExpect(b.pet, noPet) &&
				t.checkExpect(b.age, 19) &&
				t.checkExpect(c.name, "Franky") &&
				t.checkExpect(c.pet, noPet) &&
				t.checkExpect(c.age, 27);
		
	}
}

