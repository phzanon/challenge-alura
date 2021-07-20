package com.freemanpivo.chassi.domain.usecase;

import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.domain.port.SaveVideoModelPort;
import com.freemanpivo.chassi.domain.port.command.GetVideoModelPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveVideoInfo implements GetVideoModelPort {

    private final SaveVideoModelPort port;

    @Override
    public Video save(String id, String titulo, String descricao, String url) {
        Video video = new Video(id, titulo, descricao, url);
        Video video1 = port.save(video);
        if(video1 == null) {
            throw new RuntimeException("Erro ao salvar", null);
        }
        return video1;
    }
}
