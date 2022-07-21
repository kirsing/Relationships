
package com.example.relationshipspractise.model.manytomany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data

public class Viewer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

 @ManyToMany(mappedBy = "viewerList") // mappedBy – это имя атрибута сопоставления ассоциаций на стороне владельца
 @JsonIgnoreProperties("viewerList") //
    private List<Stream> followedStreams = new ArrayList<>();

    public void follow(Stream stream) {
        followedStreams.add(stream);
    }
}
