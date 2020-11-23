 class Switch {

     void switchLesson(){
        int switchValue = 1;
        String messageHeader = "value was " ;
        switch(switchValue){
            //Must have case otherwise it will step into each case.
            case 0:
                System.out.println(messageHeader+0);
                break;
            case 1:
                System.out.println(messageHeader+1);
                break;
            case 2: case 3: case 4: //group the cases
                System.out.println(messageHeader+2+","+3+" or "+4+" which is maximum value.");
                break;
            default:
                System.out.println("unknown");
                break;
        }
    }


     void challengeChar() {
        char switchValue = 'A';
        String message = "value was ";
        char a = 'A';
        char b = 'B';
        char c = 'C';
        char d = 'D';
        char e = 'E';
        switch(switchValue){

            case 'A':
                System.out.println(message+switchValue);
                break;
            case 'B':
                System.out.println(message+switchValue);
                break;
            case 'C': case 'D': case'E':
                System.out.println(message+switchValue);
                break;
            default:
                System.out.println("Not found");
        }

    }

     void switchString(){
        String switchValue = "January";

        switch (switchValue){
            case "February":
                System.out.println("Feb");
                break;
            case "January":
                System.out.println("Jan");
                break;
            default:
                System.out.println("Nothing found");
                break;
        }
    }

     void challengeString(int day
    ) {
        String wordedDay="unknown";

       switch(day){
           case 1:
               wordedDay="Monday";
               break;
           case 2:
               wordedDay="Tuesday";
               break;
           case 3:
               wordedDay="Wednesday";
               break;
           case 4:
               wordedDay="Thursday";
               break;
           case 5:
               wordedDay="Friday";
       }

        String message = "Day "+day+" of the week is:"+wordedDay;
        System.out.println(message);
    }

     void challengeStringBonus(int dayNumber) {

        String day =
                  dayNumber==0 ? "Sunday"
                : dayNumber==1 ? "Monday"
                : dayNumber==2 ? "Tuesday"
                : dayNumber==3 ? "Wednesday"
                : dayNumber==4 ? "Thursday"
                          : "Unknown";
        System.out.println("Day "+dayNumber+" of the week is "+day);
    }


}
