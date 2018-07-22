package studentcompanion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anmol singh sethi
 */
public class papers {
String title, desc, dateofupload, subjectid,postedby,yearofexamination;
int paperid;

        public papers(String title, String desc, String dateofupload, String subjectid, int paperid) {
        this.title = title;
        this.desc = desc;
        this.dateofupload = dateofupload;
        this.subjectid = subjectid;
        this.paperid = paperid;
    }

    /**
     *
     * @param title
     * @param desc
     * @param dateofupload
     * @param postedby
     * @param paperid
     */
    public papers(String title, String desc, String dateofupload, int paperid,String postedby) {
        this.title = title;
        this.desc = desc;
        this.dateofupload = dateofupload;
        //this.subjectid = subjectid;
        this.postedby = postedby;
        this.paperid = paperid;
    }

    public papers(String title, String desc, String dateofupload,  String postedby, String yearofexamination, int paperid) {
        this.title = title;
        this.desc = desc;
        this.dateofupload = dateofupload;
        //this.subjectid = subjectid;
        this.postedby = postedby;
        this.yearofexamination = yearofexamination;
        this.paperid = paperid;
    }
        
    


}
