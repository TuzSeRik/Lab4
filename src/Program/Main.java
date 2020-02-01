package Program;

import Environment.Dirty;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Cloth cloth = new Cloth("Рубаха");
        Furnace furnace = new Furnace("Картошка", 100, "PETITE");

        new LunarShorty.Human("") {
            void comp() {
                Furnace.Food foodA;
                Furnace.Food foodB;
                foodA = (Furnace.Food) furnace.getFood();
                foodB = (Furnace.Food) new Furnace("Фасолевое зерно", 0, "PETITE").getFood();
                if (foodA.getSize() == foodB.getSize()) {
                    System.out.println(foodA.getName() + " была такая же " + foodA.getSize().name() + " как и " + foodB.getName());
                }
            }
        }.comp();

        LunarShorty.Human human = new LunarShorty.Human("Незнайка");

        ShortiesCollection SC = new ShortiesCollection();

        SC.Load();

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        gson.
        shorties[0].LookAtShorty(shorties);
        shorties[0].Repair(cloth);
        for (LunarShorty shorty1 : shorties) {
            shorty1.Laugh();
        }

        for (LunarShorty shorty1 : shorties) {
            shorty1.Buzz(shorties);
        }

        for (int i = ((Furnace.Food) furnace.getFood()).getQuantity(); i > 0; i--) {
            shorties[i % 10].TryToEat(furnace);
        }
        shorties[1].Fight(shorties[4], shorties[7], shorties[8]);
        class Dirt {
            private String name;

            private Dirt(String n) {
                name = n;
            }

            private void applyOnHuman(LunarShorty.Human h) throws Dirty {
                h.changeDirty();
            }
        }
        Dirt dirt = new Dirt("Зола");
        try {
            while (true) {
                human.TryToEat(furnace);
                dirt.applyOnHuman(human);
            }
        }catch (Dirty dirty){
            dirty.personIsDirty(human.getHowDirty(), human);
            System.err.println(human.getName()+" испачкался в "+dirt.name+" и получил DAMAGE "+human.getHowDirty());

        }
    }
}
//+