package com.example.relationshipspractise.model.manytomany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Stream {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @ManyToMany
    @JoinTable(name = "followedStreams",
        joinColumns = @JoinColumn(name = "stream_id"),
        inverseJoinColumns = @JoinColumn(name = "viewer_id")
    )
//    targetEntity = Viewer.class,
//    cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH}
    private List<Viewer> viewerList = new ArrayList<>();

    public void addViewer(Viewer viewer) {
        viewerList.add(viewer);
    }
}
