import project.Observer.Observer;
public class ObserverOrder {
    public ObserverOrder(Hotel hotel){
        this.hotel = hotel;
        this.hotel.attach(this);
     }
  
  
    @Override
    public abstract void update(){
        // Update State
    };
}