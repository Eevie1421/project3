/* Eve Totman.
 * Hiker: Stores and enables the access of important information on each hiker who goes up the mountain.
 */

import java.util.Objects;

public class Hiker {
    private String name;
    private int hikerNum;

    public Hiker(String name, int hikerNum){
        this.name = name;
        this.hikerNum = hikerNum;
    }

    public String getName() {
        ArrayStack<Integer> test = new ArrayStack<>(2);
        return name;
    }

    public int getHikerNum() {
        return hikerNum;
    }

    @Override
    public String toString() {
        return "Hiker # : " + hikerNum + " " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hiker hiker = (Hiker) o;
        return hikerNum == hiker.hikerNum && Objects.equals(name, hiker.name);
    }

}
