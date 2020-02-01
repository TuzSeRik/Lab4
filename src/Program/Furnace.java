package Program;

import Environment.Eatable;
import Environment.Size;

import java.util.Objects;

public class Furnace {
    private Food food;
    private Food foodForComparasion;

    public class Food implements Eatable {
        private String name;
        private int quantity;
        private Dump causedDump;
        private Size size;

        Food(String name, String size){
            setName(name);
            this.size = Size.valueOf(size);
            causedDump = new Dump();
        /*    switch (this.size){
                case PETITE:{System.out.println(getName()+" была очень маленькая. Как фасолевое зернышко.");}
                case SMALL:{}
                case MEDIUM:{}
                case MODERATE:{}
                case BIG:{}
                case ENORMOUS:{}
            }*/
        }


        Food(String name, int quantity, String size){
            setName(name);
            setQuantity(quantity);
            this.size = Size.valueOf(size);
            causedDump = new Dump();
        /*    switch (this.size){
                case PETITE:{System.out.println(getName()+" была очень маленькая. Как фасолевое зернышко.");}
                case SMALL:{}
                case MEDIUM:{}
                case MODERATE:{}
                case BIG:{}
                case ENORMOUS:{}
            }*/
        }



        String getName() {
            return name;
        }

        private void setName(String name) {
            this.name = name;
        }

        int getQuantity() {
            return quantity;
        }

        void changeQuantity() {
            quantity--;
            incDump();
        }

        private void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public Size getSize() {
            return size;
        }

        public void setSize(Size size) {
            this.size = size;
        }


        @Override
        public void makeDump(){
            causedDump = new Dump();
        }

        @Override
        public void incDump(){
            causedDump.changeSize();
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Food)) return false;
            Food food = (Food) o;
            return getQuantity() == food.getQuantity() &&
                    getName().equals(food.getName()) &&
                    causedDump.equals(food.causedDump);
        }

        @Override
        public int hashCode() {
            return Objects.hash(getName(), getQuantity(), causedDump);
        }

        @Override
        public String toString() {
            return "Food{" +
                    "name='" + name + '\'' +
                    ", quantity=" + quantity +
                    ", causedDump=" + causedDump +
                    '}';
        }
    }





    Furnace(String name, int quantity, String size){
        food = new Food(name,quantity, size);
    }


    Object getFood() {
        return food;
    }

    public void setFood(Object food) {
        this.food = (Food) food;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Furnace)) return false;
        Furnace furnace = (Furnace) o;
        return getFood().equals(furnace.getFood());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFood());
    }

    @Override
    public String toString() {
        return "Program.Furnace{" +
                "food=" + food +
                '}';
    }
}
//+