public class Mobile implements ITelephone{

    private boolean ringing;
    private int myNumber;
    private boolean isOn;

    public Mobile (int number) {
        this.myNumber=number;
    }

    @Override
    public void powerOn() {
        System.out.println("Powering up..");
        isOn=true;
        System.out.println("Is on.");
    }

    @Override
    public void dial(int number) {
        if(isOn){
            System.out.println("Dialled "+number+". Waiting for answer.");
        }
        else{
            System.out.println("Phone is off");
        }

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
            System.out.println("Melody ring..");
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
