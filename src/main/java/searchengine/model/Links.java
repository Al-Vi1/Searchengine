package searchengine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class Links {
    private final String url;
    private List<Links> childLinks = new ArrayList<>();

//    public Links(String url) {
//        this.url = url;
//        childLinks = new ArrayList<>();
//    }

//    public String getUrl() {
//        return url;
//    }
//
//    public List<Links> getChildLinks() {
//        return childLinks;
//    }
//
//    public void setChildLinks(List<Links> childLinks) {
//        this.childLinks = childLinks;
//    }
   public void addChildLink(Links link) {
        childLinks.add(link);
    }

}
