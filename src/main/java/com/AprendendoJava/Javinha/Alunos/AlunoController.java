package com.AprendendoJava.Javinha.Alunos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/primeirapagina")
    public String boasVindas() {
        return "Hello World";
    };

    @PostMapping("/cadastrar/aluno")
    public void createAluno(@RequestBody AlunoDTO alunoDTO) {
        alunoService.createAluno(alunoDTO);
    }

    @GetMapping("alunos/")
    public ResponseEntity<List<AlunoModel>> getAllAlunos() {
        var response = alunoService.getAllAlunos();

        return ResponseEntity.ok(response);

    }

}
