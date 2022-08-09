package com.example.camp.controller;

import com.example.camp.dto.CamperResponseDTO;
import com.example.camp.dto.CamperSearchResultDTO;
import com.example.camp.dto.CreateCamperDTO;
import com.example.camp.service.CamperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/campers")
public class CamperController {

    @Autowired
    private CamperService camperService;

    @PostMapping
    public CamperSearchResultDTO createCamper(@Valid @RequestBody CreateCamperDTO createCamperDTO) {
        return camperService.create(createCamperDTO);
    }

    @GetMapping
    public List<CamperSearchResultDTO> getAllCampers() {
        return camperService.getAll();
    }

    @GetMapping("/{id}")
    public CamperResponseDTO getCamper(@PathVariable Long id) {
        return camperService.getById(id);
    }
}
