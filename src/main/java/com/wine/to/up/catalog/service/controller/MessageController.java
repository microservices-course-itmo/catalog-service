package com.wine.to.up.catalog.service.controller;

import com.wine.to.up.catalog.service.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * REST controller of the service
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/message")
@Validated
@Slf4j
@ApiIgnore
public class MessageController {
    public final MessageRepository messageRepository;

    @GetMapping
    public List<String> getSentMessages() {
        return messageRepository.findDistinctContent();
    }
}
