package Program;

import Environment.Status;

import java.util.Objects;

public abstract class Person {

    private String name;

    private Status status;


    Person(){}

    Person(String name){
        setName(name);
        setStatus(Status.NONE);
    }

    Person(String name, Status status){
        setName(name);
        setStatus(status);
    }


    @Override
    public String toString() {
        return "Program.Person{" +
                "name='" + name + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getName().equals(person.getName()) &&
                getStatus() == person.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getStatus());
    }


    String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    Status getStatus() {
        return status;
    }

    void setStatus(Status status) {
        this.status = status;
    }


    abstract void Fight(Person... persons);

    abstract void Laugh();

    abstract void Repair(Object thing);

    abstract void TryToEat(Furnace furnace);

    abstract void LookAtFood(Furnace.Food f);

    abstract void LookAtShorty(LunarShorty... s);
}
//+