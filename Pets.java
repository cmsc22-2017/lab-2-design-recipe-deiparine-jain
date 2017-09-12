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
}

// to represent a pet
interface IPet { }

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
}


class ExamplesPet {
	
	ExamplesPet() {}
	
	IPet snow = new Cat("Snow", "Himalayan", true);
	IPet ginger = new Cat("Ginger", "Ocicat", false);
	IPet darky = new Dog("Darky", "Doberman", true);
	IPet bella = new Dog("Bella", "Shih Tzu", false);
	
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
}
