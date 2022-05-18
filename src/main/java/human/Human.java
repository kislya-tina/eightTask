package human;

public class Human {
    private String name;
    private int age;

    public String Stringer(){
        return "Stringer";
    }

    public int Counter(){
        return 10;
    }

    private void voider(){

    }

    public int getTen(){
        System.out.println("getter");
        return 10;
    }

    public void setTen(int set){
        System.out.println("set 10");
    }
}
