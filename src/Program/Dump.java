package Program;

import java.util.Objects;

public class Dump {
    private int size;
    private boolean bigEnough;


    Dump(){
        size = 0;
    }


    private int getSize() {
        return size;
    }

    private boolean isBigEnough() {
        return bigEnough;
    }

    private void setBigEnough() {
        this.bigEnough = true;
    }


    void changeSize() {
        size++;
        int thrashhold = 90;
        if (size == thrashhold){
            this.setBigEnough();
            System.out.println("Куча мусора стала большой.");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dump)) return false;
        Dump dump = (Dump) o;
        return getSize() == dump.getSize() &&
                isBigEnough() == dump.isBigEnough();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSize(), isBigEnough());
    }

    @Override
    public String toString() {
        return "Program.Dump{" +
                "size=" + size +
                ", bigEnough=" + bigEnough +
                '}';
    }
}
//++