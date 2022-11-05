package com.example.history.service;

import com.example.history.entity.HistoryEntity;
import com.example.history.model.Model;
import com.example.history.repository.HistoryRepository;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoryService {
    private final HistoryRepository historyRepository;
    public void saveHistory(String message){
        Gson gson = new Gson();
        Model model = gson.fromJson(message, Model.class);
        HistoryEntity historyEntity = new HistoryEntity(model.getId(), model.getCount(), model.getTrade());
        historyRepository.save(historyEntity);
    }

}
