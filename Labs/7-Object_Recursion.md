# Practice Using Objects with Recursion

## Brothers Hugging Each Other

Take a look at the program below. It defines a `Person` object, representing one of my three sons. Sometimes, brothers like to hug each other, but if one brother is sick the others might get sick too.

- Ian, the youngest, likes to hug Will.
- Will likes to hug Scott.
- Scott doesn't like to hug anybody (this is truth).

Suppose that Ian gets sick one day and decides to start a hug-a-thon. If Ian hugs Will, then Will might get sick. If Will continues and hugs Scott, then Scott will get sick. The class below defines two versions of the `infectAll` method, which is intended to model this process of infection transmission through affection.

Study the code, then describe, **in detail**, what the two versions of `infectAll` will actually do to Scott, Will, and Ian. Note that I am not asking for a summary of the statements in the method, but a discussion of what will happen to the `People` defined by the program: who will get sick and in what order? Think carefully!

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
    // Tries to infect everybody starting with Ian
    public static void main(String[] args) {
        ObjectRecursion o = new ObjectRecrusion();
        Person ian = o.getYoungestPerson();
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

Now repeat the same analysis on the version below, which has more people and adds a third version of the `infectAll` method. Again, explain in detail what will happen for each version of `infectAll`. There are no tricks or syntax errors in the program.

Type your answers to this part in a document that you can upload to Canvas.

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
    // Tries to infect everybody starting with Ian
    public static void main(String[] args) {
        ObjectRecursion o = new ObjectRecrusion();
        Person ian = o.getYoungestPerson();
        o.infectAll(ian);
    }
}
```
