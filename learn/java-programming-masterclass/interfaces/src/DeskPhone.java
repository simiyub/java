public class DeskPhone implements ITelephone{

    private boolean ringing;
    private int myNumber;

    public DeskPhone(int number) {
        this.myNumber=number;
    }

    @Override
    public void powerOn() {
        System.out.println("Always on, no action taken..");
    }

    @Override
    public void dial(int number) {
        System.out.println("Dialled "+number+". Waiting for answer.");
    }

    @Override
    public void answer() {
        if(isRinging()){
            System.out.println("Answered the phone.");
            ringing=false;
        }
        else{
            System.out.println("Can't answer as phone is not ringing.");
        }
    }

    @Override
    public boolean callPhone(int number) {
        if(number == myNumber){
            ringing=true;
            System.out.println("Ring ring");
        }
        else{
            ringing=false;
        }
        return ringing;
    }

    @Override
    public boolean isRinging() {
        return ringing;
    }
}
