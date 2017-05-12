package kr.re.kitri.model;


public class Items {

    private int serch_id;
    private String title;
    private String link;
    private String image;
    private String subtitle;
    private String pubDate;
    private String director;
    private String actor;
    private double userRating;

    @Override
    public String toString() {
        return "Items{" +
                "serch_id=" + serch_id +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", image='" + image + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", director='" + director + '\'' +
                ", actor='" + actor + '\'' +
                ", userRating=" + userRating +
                '}';
    }

    public int getSerch_id() {
        return serch_id;
    }

    public void setSerch_id(int serch_id) {
        this.serch_id = serch_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public double getUserRating() {
        return userRating;
    }

    public void setUserRating(double userRating) {
        this.userRating = userRating;
    }

    public Items(int serch_id, String title, String link, String image, String subtitle, String pubDate, String director, String actor, double userRating) {

        this.serch_id = serch_id;
        this.title = title;
        this.link = link;
        this.image = image;
        this.subtitle = subtitle;
        this.pubDate = pubDate;
        this.director = director;
        this.actor = actor;
        this.userRating = userRating;
    }
}
