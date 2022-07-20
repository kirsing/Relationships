package com.example.relationshipspractise.controller;

import com.example.relationshipspractise.model.manytomany.Stream;
import com.example.relationshipspractise.model.manytomany.Viewer;
import com.example.relationshipspractise.repository.StreamRepository;
import com.example.relationshipspractise.repository.ViewerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/streams-viewers/")
@AllArgsConstructor
public class StreamViewerController {

    StreamRepository streamRepository;
    ViewerRepository viewerRepository;

    @GetMapping("/allviewers")
    public List<Viewer> getAllViewers() {
        return viewerRepository.findAll();
    }
    @GetMapping("/allstreams")
    public List<Stream> getAllStream() {
        return streamRepository.findAll();
    }

    @PostMapping("/createViewer")
    public Viewer createViewer(Viewer viewer) {
        return viewerRepository.save(viewer);
    }
    @PostMapping("/createStream")
    public Stream createStream(Stream stream) {
        return streamRepository.save(stream);
    }
    @DeleteMapping("/viewer/delete/{id}")
    public void deleteViewerById(@PathVariable Long id) {
        viewerRepository.deleteById(id);
    }
    @DeleteMapping("/stream/delete/{id}")
    public void deleteStreamById(@PathVariable Long id) {
        streamRepository.deleteById(id);
    }
    @PutMapping("{streamId}/viewers/{viewerId}")
    Stream followToStream(@PathVariable Long streamId, @PathVariable Long viewerId) {
        Stream stream = streamRepository.findById(streamId).get();
        Viewer viewer = viewerRepository.findById(viewerId).get();
        stream.addViewer(viewer);
        return streamRepository.save(stream);

    }
}
