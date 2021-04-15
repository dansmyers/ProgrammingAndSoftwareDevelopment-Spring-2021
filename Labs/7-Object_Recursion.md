# Practice Using Objects with Recursion

## Brothers Poking Each Other

Take a look at the program below. It defines a `Brother` object, representing one of my three sons. Sometimes, brothers like to hug each other, but if one brother is sick, the others might get sick too.

- Ian, the youngest, likes to hug Will.
- Will likes to hug Scott.
- Scott doesn't like to hug anybody (this is truth).

Suppose that Ian gets sick one day and decides to start a hug-a-thon. If Ian hugs Will, then Will might get sick. If Will continues and hugs Scott, then Scott will get sick.

```
public class ObjectRecursion {
  
  public static final int SCOTT = 0;
  public static final int WILL = 1;
  public static final int IAN = 2;
  
  private Person[] people = new Person[3];
  
  // Constructor
  public FluQuiz() {
    people[SCOTT] = new Person("Scott", null); // Scott doesn't hug anybody
    people[WILL] = new Person("Will", people[SCOTT]); // Will hugs Scott
    people[IAN] = new Person("Ian", people[WILL]); // Ian hugs Will
  }
  
  // Return the first Person in the people array
  public Person getYoungestPerson() {
    return people[people.length - 1];
  }
  
  // Here are two different versions of the infectAll() method
  //
  // Explain IN DETAIL what each version of the method will do.
  
  public void infectAll(Person victim) {
    if ( victim.getHugTarget() != null ) {
      victim.getHugTarget().infect();
    }
  }//end version1
  
  public void infectAll(Person victim) {
    victim.infect();
    if ( victim.getHugTarget() != null ) {
      infectAll(victim.getHugTarget());
    }
  }//end version2
  
  
  // Main method
  // Tries to infect everybody starting with John
  public static void main(String[] args) {
    ObjectRecursion o = new ObjectRecrusion();
    Person ian = o.getFYoungestPerson();
    o.infectAll(ian);
  }
}

class Person {
  private String name;
  private Person hugTarget;
  private boolean isSick;
  
  // Constructor
  public Person(String name, Person hugs) {
    this.name = name;
    this.hugTarget = hugs;
    isSick = false;
  }
  
  // Make this Person sick
  public void infect() {
    isSick = true;
  }
  
  // Return the other Person that this Person hugs
  public Person getHugTarget() {
    return this.hugTarget;
  }
}
```


## More Hugs

```
public class ObjectRecursion {
  
  public static final int DAD = 0;
  public static final int MOM = 1;
  public static final int SCOTT = 2;
  public static final int WILL = 3;
  public static final int IAN = 4;

  private Person[] people = new Person[5];
  
  // Constructor
  public FluQuiz() {
    people[SCOTT] = new Person("Scott", null); // Scott doesn't hug anybody
    people[WILL] = new Person("Will", people[MOM]); // Will hugs Mom
    people[IAN] = new Person("Ian", people[WILL]); // Ian hugs Will
    people[DAD] = new Person("Dad", people[SCOTT]); // Dad hugs Scott
    people[MOM] = new Person("Mom", people[DAD]); // Mom hugs Dad
  }
  
  // Return the first Person in the people array
  public Person getYoungestPerson() {
    return people[people.length - 1];
  }
  
  // Here are THREE different versions of the infectAll() method
  //
  // Explain IN DETAIL what each version of the method will do.
  
  public void infectAll(Person victim) {
    if ( victim.getHugTarget() != null ) {
      victim.getHugTarget().infect();
    }
  }//end version1
  
  public void infectAll(Person victim) {
    victim.infect();
    if ( victim.getHugTarget() != null ) {
      infectAll(victim.getHugTarget());
    }
  }//end version2
  
  public void infectAll(Person victim) {
    if ( victim.getHugTarget() != null ) {
      infectAll(victim.getHugTarget());
    }
    victim.infect();
  } //end version 3
  
  
  // Main method
  // Tries to infect everybody starting with John
  public static void main(String[] args) {
    ObjectRecursion o = new ObjectRecrusion();
    Person ian = o.getFYoungestPerson();
    o.infectAll(ian);
  }
}
```
