package Members;

public class CompetitiveSwimmer { // Skal huske at kunne skelne mellem junior / senior
    String name;
    int memberId;
    JuniorOrSenior hej; // variabel navn LOL
    double butterflyTime;
    double backstrokeTime;
    double breaststrokeTime;
    double freestyleTime;

    public CompetitiveSwimmer(String name, int memberId){
        this.name = name;
        this.memberId = memberId;
    }

    public void setHej(){
        this.hej = hej;
    }

    public void setButterflyTime(double butterflyTime) {
        this.butterflyTime = butterflyTime;
    }

    public void setBackstrokeTime(double backstrokeTime) {
        this.backstrokeTime = backstrokeTime;
    }

    public void setBreaststrokeTime(double breaststrokeTime) {
        this.breaststrokeTime = breaststrokeTime;
    }

    public void setFreestyleTime(double freestyleTime) {
        this.freestyleTime = freestyleTime;
    }
}


