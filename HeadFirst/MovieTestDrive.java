class Movie{
    String tilte ; 
    String gener ;
    float rank;

    void playTi()
    {
        System.out.println("Playing the Movie");
    }
}

 class MovieTestDrive{
    public static void main(String[] args) {
        Movie one = new Movie();
        one.playTi() ;
        one.tilte = "lalallal";
        one.gener = "123";
        one.rank = 7;
        Movie two = new Movie() ;
        two.playTi();
        two.tilte = "bblblbl";
        two.gener = "clclclc";
        two.rank = 3;
    }
}