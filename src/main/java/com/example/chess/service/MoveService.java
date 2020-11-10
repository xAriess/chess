package com.example.chess.service;

import com.example.chess.model.game.Move;
import com.example.chess.model.game.MoveRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoveService {
    private MoveRepository moveRepository;

    public MoveService(MoveRepository moveRepository) {
        this.moveRepository = moveRepository;
    }

    public void addMove(Move toAdd){
        moveRepository.save(toAdd);
    }

    public void flushRepository(){
        moveRepository.flush();
    }

    public Move getLastAIMoveFromGame(int gameId){
        return moveRepository.findTopByGameIdOrderByIdDesc(gameId).orElseThrow();
    }

    public List<Move> saveAll( Iterable<Move> moves)    {
        return moveRepository.saveAll(moves);
    }




}