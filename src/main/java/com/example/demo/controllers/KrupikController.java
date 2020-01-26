package com.example.demo.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/")
public class KrupikController {


    @GetMapping("")
    public ResponseEntity getMethod() {
        return ResponseEntity.ok("GET");
    }


    @PostMapping("")
    public ResponseEntity createMethod(@RequestBody Body body) {
        return ResponseEntity.ok("POST for boy " + body);
    }


    @DeleteMapping("{id}")
    public ResponseEntity deleteMethod(@PathVariable int id) {
        return ResponseEntity.ok("DELETE for id:" + id);
    }


    @PutMapping("{id}")
    public ResponseEntity putMethod(@PathVariable int id, @RequestBody Body body) {
        return ResponseEntity.ok("PUT for id:" + id + " with body " + body);
    }
}

@Data
@AllArgsConstructor
class Body {
    private String title;
    private String author;
}
