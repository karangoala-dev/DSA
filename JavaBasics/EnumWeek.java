package JavaBasics;

public enum EnumWeek implements Iweek{

    Sunday,
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday;

    public int dayOfWeek(){
        return ordinal() + 1;
    }
}
