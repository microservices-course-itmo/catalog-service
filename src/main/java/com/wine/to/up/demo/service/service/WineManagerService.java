package com.wine.to.up.demo.service.service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
//@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class WineManagerService {


    public Object getWinePositionById(String id) {
//        System.out.println("Hello, Wine!");

        return null;
    }

    public List<Object> getAllWinePositions() {

        return null;
    }

    public Object createWinePosition(Object obj) {

        return obj;
    }

    public Object updateWinePosition(String id, Object obj) {

        return null;
    }
}
