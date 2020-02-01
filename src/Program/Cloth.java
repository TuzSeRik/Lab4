package Program;

import Environment.Repairable;

import java.util.Objects;

public class Cloth implements Repairable {
    private String name;
    private boolean isBroken;


    Cloth(String name){
        setBroken(true);
        setName(name);
    }


    String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    boolean isBroken() {
        return isBroken;
    }

    private void setBroken(boolean broken) {
        isBroken = broken;
    }


    @Override
    public void Break(){
        setBroken(true);
    }

    @Override
    public void Repair(){
        setBroken(false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cloth)) return false;
        Cloth cloth = (Cloth) o;
        return isBroken() == cloth.isBroken() &&
                getName().equals(cloth.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), isBroken());
    }

    @Override
    public String toString() {
        return "Program.Cloth{" +
                "name='" + name + '\'' +
                ", isBroken=" + isBroken +
                '}';
    }
}
//+