package demo.skyland.com.demo.playbill;

/**
 * Created by skyland on 2017/4/5
 */

public class ProgramModel {

    private String date;
    private String name;

    public ProgramModel(String date, String name) {
        this.date = date;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
