package breizhcamp2016;

public class Conference {


    public String title;
    
    public String description;
    
    public Speaker[] speakers;

    
    public Conference(String title, String description, Speaker... speakers) {
        this.title = title;
        this.description = description;
        this.speakers = speakers;
    }

}
