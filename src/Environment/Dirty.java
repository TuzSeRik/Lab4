package Environment;

import Program.LunarShorty;

public class Dirty extends Exception {
    public Dirty(){}

    public void personIsDirty(int n, LunarShorty.Human human){
        human.recieveDamage(n);
    }
}
//+