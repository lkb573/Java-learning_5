package kr.re.kitri.model;

import java.sql.Date;

/**
 * Created by danawacomputer on 2017-05-12.
 */
public class Searchs {

    private int search_id;
    private Date lastbuilddate;
    private int total;
    private String keyword;


    @Override
    public String toString() {
        return "Searchs{" +
                "search_id=" + search_id +
                ", lastbuilddate=" + lastbuilddate +
                ", total=" + total +
                ", keyword='" + keyword + '\'' +
                '}';
    }

    public int getSearch_id() {
        return search_id;
    }

    public void setSearch_id(int search_id) {
        this.search_id = search_id;
    }

    public Date getLastbuilddate() {
        return lastbuilddate;
    }

    public void setLastbuilddate(Date lastbuilddate) {
        this.lastbuilddate = lastbuilddate;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Searchs(int search_id, Date lastbuilddate, int total, String keyword) {

        this.search_id = search_id;
        this.lastbuilddate = lastbuilddate;
        this.total = total;
        this.keyword = keyword;
    }
}
