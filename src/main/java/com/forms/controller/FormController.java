package com.forms.controller;

import com.forms.entity.Form;
import com.forms.service.FormService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/form")
public class FormController {
    private final FormService formService;
    @GetMapping("/get")
    @Operation(summary = "Search")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Search", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Form.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid data", content = @Content)})
    public List<Form> getAll()
    {
        return formService.getAllByUserId(UUID.fromString("3fa85f64-5717-4562-b3fc-2c963f66afa6"));
    }
    @PostMapping("/create")
    @Operation(summary = "Search")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Search", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Form.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid data", content = @Content)})
    public Form creat(@RequestBody Form form)
    {
        return formService.create(form);
    }
}