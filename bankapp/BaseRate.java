package bankapp;

public interface BaseRate {
    default double getBaseRate(){
        return 2.50;
    }


}
