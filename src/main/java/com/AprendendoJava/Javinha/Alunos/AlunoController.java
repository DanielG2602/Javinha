package com.AprendendoJava.Javinha.Alunos;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping("/cadastrar/aluno")
    public void createAluno(@RequestBody AlunoDTO alunoDTO) {
        alunoService.createAluno(alunoDTO);
    }

    @GetMapping("alunos/")
    public ResponseEntity<List<AlunoModel>> getAllAlunos() {
        var response = alunoService.getAllAlunos();

        return ResponseEntity.ok(response);
    }

    @PutMapping("aluno/{alunoId}")
    public ResponseEntity<Void> updateAluno(@PathVariable("alunoId") String alunoId,
                                                @RequestBody AlunoDTO alunoDTO) {
        var aluno = alunoRepository.findById(Long.valueOf(alunoId));

        if (aluno.isPresent()) {
            alunoService.updateAluno(alunoId, alunoDTO);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("aluno/{alunoId}")
    public ResponseEntity<AlunoModel> getSingleAluno(@PathVariable("alunoId") String alunoId) {
        var aluno = alunoRepository.findById(Long.valueOf(alunoId));

        if (aluno.isPresent()) {
            return ResponseEntity.ok(aluno.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("aluno/{alunoId}")
    public ResponseEntity<Void> deleteSingleAluno(@PathVariable("alunoId") String alunoId) {
        alunoService.deleteAluno(alunoId);
        return ResponseEntity.ok().build();
    }
}
