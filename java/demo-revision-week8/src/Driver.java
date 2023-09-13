public class Driver implements Orderable{

    @Override
    public void order(){
        Customer.counter += 3;
    }
    
}
