package com.AprendendoJava.Javinha.Alunos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public void createAluno(AlunoDTO alunoDTO) {
        AlunoModel aluno = new AlunoModel(
                alunoDTO.email(),
                alunoDTO.idade(),
                alunoDTO.name(),
                alunoDTO.turma()
        );

        alunoRepository.save(aluno);
    }

    public List<AlunoModel> getAllAlunos() {
        return alunoRepository.findAll();
    }
}
