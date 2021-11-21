import project.Observer.Observer;

public class ObserverAvailability extends Observer {
    public ObserverAvailability(Hotel hotel){
        this.hotel = hotel;
        this.hotel.attach(this);
     }
  
  
    @Override
    public abstract void update(){
        // Update State
    };
}