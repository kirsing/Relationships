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

    @GetMapping("/viewers")
    public List<Viewer> getAllViewers() {
        return viewerRepository.findAll();
    }
    @GetMapping("/streams")
    public List<Stream> getAllStream() {
        return streamRepository.findAll();
    }

    @PostMapping("/createViewer")
    Viewer createViewer(@RequestBody Viewer viewer) {
        return viewerRepository.save(viewer);
    }
    @PostMapping("/createStream")
    Stream createStream(@RequestBody Stream stream) {
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
    @PutMapping("/{streamid}/viewers/{viewerid}")
    Stream followToStream(@PathVariable Long streamid, @PathVariable Long viewerid) {
        Stream stream = streamRepository.findById(streamid).get();
        Viewer viewer = viewerRepository.findById(viewerid).get();
        stream.addViewer(viewer);
        return streamRepository.save(stream);

    }
}
