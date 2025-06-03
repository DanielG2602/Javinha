package com.AprendendoJava.Javinha.Alunos;

import jakarta.transaction.Transactional;
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

    @Transactional
    public void updateAluno(String alunoId, AlunoDTO alunoDTO) {
        var idAluno = Long.valueOf(alunoId);

        var aluno = alunoRepository.findById(idAluno);

        if (aluno.isPresent()) {
            aluno.get().setEmail(alunoDTO.email());
            aluno.get().setNome(alunoDTO.name());
            aluno.get().setIdade(alunoDTO.idade());
            aluno.get().setTurma(alunoDTO.turma());
        }
    }

    @Transactional
    public void deleteAluno(String alunoId) {
        var aluno = alunoRepository.findById(Long.valueOf(alunoId));

        if (aluno.isPresent()) {
            alunoRepository.delete(aluno.get());
        }
        else {
            return;
        }
    }
}
