class DrumKit
{
    boolean topHat = true ; 
    boolean snare = true ; 
    void PlaySnare()
    {
        System.out.println("banbabababbabab");
    }
    void PlaytopHat()
    {
        System.out.println("lallalalalalal");
    }
}

public class DrumKitTestDrive
{
    public static void main(String[] args) {
        DrumKit d = new DrumKit();
        d.topHat = false;
        d.snare = false;
        d.PlaytopHat();
        d.PlaySnare();
    }
}