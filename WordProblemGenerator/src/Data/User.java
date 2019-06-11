package Data;

public class User {

    /***
     *
     * WPG will be provided various students.
     *
     * So it need to record User info for printing Test Sheet.
     *
     * It'll have organization of student and his/her name.
     *
     */
    private String organization;
    private String name;

    public User(String organization, String name)
    {
        this.name = name;
        this.organization = organization;
    }

    @Override
    public String toString() {
        return ( organization + " ... " + name );
    }
}
