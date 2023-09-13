public class Human {
    private String name;

    public Human(String name){
        this.name=name;
    }

    public void order() {
        Customer.counter += 2;
    }

    public String getName(){
        return this.name;
    }
}
