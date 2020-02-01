package Program;

import Environment.*;
import com.google.gson.*;
import com.google.gson.GsonBuilder;
import net.sf.jsefa.csv.annotation.CsvDataType;
import net.sf.jsefa.csv.annotation.CsvField;

import java.io.Serializable;
import java.util.Objects;

@CsvDataType()
public class LunarShorty extends Person implements Serializable {

    @CsvField(pos = 1)
    private String name;

    @CsvField(pos = 2)
    private int power;

    @CsvField(pos = 3)
    private float height;

    @CsvField(pos = 4)
    private float width;

    public String jsonFormat = "{\"name\":\"Striga\", \"power\":100, \"height\":1.0, \"width\":0.5}";

    public LunarShorty() {
    }

    LunarShorty(String name) {
        super(name);
        this.name = name;
    }

    public LunarShorty(String name, Status status) {
        super(name, status);
        this.name = name;
    }


    int getPower() {
        return power;
    }

    private void setPower(int power) {
        this.power = power;
    }


    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    LunarShorty checkPower(LunarShorty[] shorties) {
        int maxPower = 0;
        LunarShorty laughiest = null;

        for (LunarShorty shorty : shorties) {
            if (shorty.getPower() > maxPower) {
                maxPower = shorty.getPower();
                laughiest = shorty;
            }
        }
        return laughiest;
    }

    void Buzz(LunarShorty[] shorties) {
        if (!checkPower(shorties).getName().equals(this.getName())) {
            this.setStatus(Status.BUZZING);
            System.out.println(this.getName() + " одобрительно загудел в сторону " + checkPower(shorties).getName());
        }
    }

    @Override
    void LookAtShorty(LunarShorty... s){
        for (LunarShorty lunarShorty : s) {
            if (!lunarShorty.equals(this)){
                System.out.println(this.getName() + " посмотрел на " + lunarShorty.getName());
            }
        }
    }

    void PokrutilPalcemUViska(Human h){
        System.out.println(this.getName()+" покрутил пальцем у виска, как бы показывая, что поехавший тут "+h.getName());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LunarShorty)) return false;
        if (!super.equals(o)) return false;
        LunarShorty that = (LunarShorty) o;
        return getPower() == that.getPower();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPower());
    }

    @Override
    public String toString() {
        return "Program.LunarShorty{" +
                "power=" + power +
                '}';
    }


    @Override
    public void Fight(Person... persons) {
        int l;
        StringBuilder end = new StringBuilder();

        this.setStatus(Status.FIGHTING);
        l = persons.length;
        for (int i = 0; i < l; i++) {
            persons[i].setStatus(Status.FIGHTING);
            end.append(persons[i].getName()).append(" ");
        }
        System.out.println(this.getName() + " начал драку с " + end);
    }

    @Override
    public void Laugh() {
        this.setPower((int) Math.round(Math.random() * 100));
        if (getStatus() == Status.REPAIRING) {
            setPower(100);
        }
        this.setStatus(Status.LAUGHING);
        System.out.println(getName() + " засмеялся с силой " + getPower());
    }

    @Override
    public void Repair(Object object) {
        if ((object instanceof Repairable)&(((Cloth)object).isBroken())) {
            this.setStatus(Status.REPAIRING);
            ((Cloth) object).Repair();
            System.out.println(this.getName() + " ремонтировал " + ((Cloth) object).getName());
        } else {
            System.out.println(this.getName() + " не мог отремонтировать " + object.toString());
        }
    }

    @Override
    public void TryToEat(Furnace furnace){
        if(furnace.getFood() instanceof Eatable){
            if(((Furnace.Food) furnace.getFood()).getQuantity()<=0){
                System.out.println(((Furnace.Food) furnace.getFood()).getName()+" закончилась.");
            }
            else {
                ((Furnace.Food) furnace.getFood()).changeQuantity();
                System.out.println(this.getName()+" выхватил себе "+((Furnace.Food) furnace.getFood()).getName());
            }
        }
        else{
            System.out.println("Да не стал никто это есть. Оно же несъедоно!");
        }
    }

    @Override
    void LookAtFood(Furnace.Food f){}




    public static class Human extends Person {
        private int howDirty = 0;
        int hp = 100;


        Human(String name){
            super(name);
        }

        public void recieveDamage(int n){
            hp = hp - n;
        }

        void changeDirty() throws Dirty {
            howDirty++;
            if (howDirty>=10) throw new Dirty();
        }


        int getHowDirty(){
            return howDirty;
        }


        @Override
        public String toString() {
            return super.toString();
        }

        @Override
        public boolean equals(Object o) {
            return super.equals(o);
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }


        @Override
        void Fight(Person... persons){
            throw new Dismorale(this, "Незнайка не может драться!", 10);
        }

        @Override
        void Laugh(){
            throw new Dismorale(this,"Незнайка не может смеяться!",10);
        }

        @Override
        void Repair(Object object){
            throw  new Dismorale(this,"Незнайка не может ничего ремонтировать!",10);
        }

        @Override
        void LookAtShorty(LunarShorty... s){
            throw new Dismorale(this, "Only homies can look at homies!", 10);
        }

        @Override
        void TryToEat(Furnace furnace){
            if(furnace.getFood() instanceof Eatable){
                if(((Furnace.Food) furnace.getFood()).getQuantity()>0){
                    System.out.println(this.getName()+" не мог добраться до еды печке.");
                }
                else{
                    System.out.println(this.getName()+" только потянулся к печке, а там уже ничего не было.");
                }
            }
            else{
                System.out.println("Это нельзя есть.");
            }
        }

        @Override
        void LookAtFood(Furnace.Food food){
            if (food.getSize().name().equals("PETITE")){
                System.out.println(this.getName()+" глянул на нее и его начало разбирать жгучее желание настучать по пальцам разработчику этой программы, который не стал переписывать метод смеха, потому что ему лень и теперь "+this.getName()+" не может разбирать смех.");
            }
        }
    }






}
//+