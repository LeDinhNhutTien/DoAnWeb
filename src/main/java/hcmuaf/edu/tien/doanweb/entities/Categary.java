package hcmuaf.edu.tien.doanweb.entities;

public class Categary {
    private  int cid;
    private  String cname;
    private  String image;

    public  Categary(){

    }

    public Categary(int cid, String cname, String image) {
        this.cid = cid;
        this.cname = cname;
        this.image = image;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Categary{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }
}
