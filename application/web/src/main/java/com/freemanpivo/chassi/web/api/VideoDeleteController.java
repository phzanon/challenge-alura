package com.freemanpivo.chassi.web.api;

import com.freemanpivo.chassi.domain.exception.BusinessException;
import com.freemanpivo.chassi.domain.exception.ErrorMessageEnum;
import com.freemanpivo.chassi.domain.port.command.DeleteVideoCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/videos")
@RequiredArgsConstructor
@Slf4j
public class VideoDeleteController {

    private final DeleteVideoCommand command;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVideo(@PathVariable("id") String id) {
        if(command.deleteVideoById(Long.parseLong(id))) {
            return ResponseEntity.ok("Deleted");
        }
        throw new BusinessException(ErrorMessageEnum.E009.getCode(), ErrorMessageEnum.E009.getMessage());
    }
}
