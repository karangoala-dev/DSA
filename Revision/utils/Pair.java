package Revision.utils;

public class Pair {
    public int first;
    public int second;
    public Pair(int _f, int _s){
        this.first = _f;
        this.second = _s;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
