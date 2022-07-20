
package com.example.relationshipspractise.model.manytomany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Viewer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickName;

    @ManyToMany
    @JoinTable(
            name = "followedStreams",
            joinColumns = @JoinColumn(name = "viewer_id"),
            inverseJoinColumns = @JoinColumn(name = "stream_id")
    )
    private List<Stream> followedStreams = new ArrayList<>();

    public void follow(Stream stream) {
        followedStreams.add(stream);
    }
}
