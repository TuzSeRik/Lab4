package Environment;

import Program.LunarShorty;

public class Dismorale extends Error {
    private int damage;

    public Dismorale(LunarShorty.Human human, String m, int n){
        damage = n;
        System.err.println(m);
        personIsDirty(damage, human);
    }

    private void personIsDirty(int n, LunarShorty.Human human){
        damage = n;
        human.recieveDamage(n);
    }
}
//+