package edu.upc.eetac.dsa.grouptalk.entity;

import org.glassfish.jersey.linking.InjectLinks;

import javax.ws.rs.core.Link;
import java.util.List;

/**
 * Created by Enric on 27/03/2016.
 */
public class Topic {
    @InjectLinks({})
    private List<Link> links;
    private String title;
    private List<Answer> Answers;

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Answer> getAnswers() {
        return Answers;
    }

    public void setAnswers(List<Answer> answers) {
        Answers = answers;
    }
}
