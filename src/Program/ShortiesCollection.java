package Program;

import net.sf.jsefa.Deserializer;
import net.sf.jsefa.Serializer;
import net.sf.jsefa.flr.FlrIOFactory;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShortiesCollection{

    public static PriorityQueue getSC() {
        return SC;
    }

    public static void setSC(PriorityQueue SC) {
        ShortiesCollection.SC = SC;
    }

    static PriorityQueue SC = new PriorityQueue();





    public void addIfMax(LunarShorty S){
        if (S.getPower()>S.checkPower((LunarShorty[]) SC.toArray()).getPower())
            SC.add(S);
    }

    public void removeLast(){
        LunarShorty[] SH;
        SH = (LunarShorty[]) SC.toArray();
        SC.remove(SH[SH.length-1]);
    }

    void Load() throws FileNotFoundException {

        Scanner reader = new Scanner(new File("input.csv"));
        while (reader.hasNext()) {
            Deserializer deserializer = FlrIOFactory.createFactory(LunarShorty.class).createDeserializer();
            StringReader dreader = new StringReader(reader.nextLine());
            deserializer.open(dreader);
            while (deserializer.hasNext()) {
                LunarShorty shorty = deserializer.next();
                SC.add(shorty);
            }
            deserializer.close(true);
        }
    }

    public void Save(){
        Serializer serializer = FlrIOFactory.createFactory(LunarShorty.class).createSerializer();
        StringWriter writer = new StringWriter();
        serializer.open(writer);
        serializer.write(SC);
        serializer.close(true);
    }

    public void Show(){}

    public void Info(){}

}