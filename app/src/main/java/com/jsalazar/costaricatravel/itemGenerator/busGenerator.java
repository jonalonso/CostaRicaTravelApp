package com.jsalazar.costaricatravel.itemGenerator;

import com.jsalazar.costaricatravel.models.Bus;

import java.util.ArrayList;

public class busGenerator {

    public static ArrayList<Bus> generate(){
        ArrayList<Bus> response = new ArrayList<>();
        response.add(new Bus("Cartago","San José","https://maps.app.goo.gl/yLKMosT83ZZafWSN6","https://maps.app.goo.gl/vRSjR9UB4maJnM9S6","22Km"));
        response.add(new Bus("San José","Cartago","https://maps.app.goo.gl/vRSjR9UB4maJnM9S6","https://maps.app.goo.gl/AhcnAn3BtwPRNc7f8","23Km"));
        response.add(new Bus("Cartago","Turrialba","https://maps.app.goo.gl/rYmkwXcRC7gcPHPF9","https://maps.app.goo.gl/XCQVKNysAsbJ1x1f7","40Km"));
        response.add(new Bus("San José","Alajuela","https://maps.app.goo.gl/GJRiHX9iZQQ5ekRc7","https://maps.app.goo.gl/3Exvi3iUQQxgtfyq9","19Km"));
        response.add(new Bus("San José","Puntarenas","https://maps.app.goo.gl/QpMs8SEC46KnjhvMA","https://maps.app.goo.gl/NLSf9rY4VnCrHmzUA","96Km"));
        response.add(new Bus("San José","Liberia","https://maps.app.goo.gl/WfyQCxNFRjwisnyZA","https://maps.app.goo.gl/328LrG1Ufc7KanEa6","210Km"));
        response.add(new Bus("San José","Jaco","https://maps.app.goo.gl/BBXZresaPxMc3EUAA","https://maps.app.goo.gl/99nBUKJiD19kQCNk7","100Km"));
        response.add(new Bus("San José","Manuel Antonio","https://maps.app.goo.gl/BBXZresaPxMc3EUAA","https://maps.app.goo.gl/t92n6ehYSuF4wc6d9","173Km"));
        response.add(new Bus("San José","Limón","https://maps.app.goo.gl/Ei64FWNZHWC9L5Ao7","https://maps.app.goo.gl/UaNQAgLD3CjYfAy97","167Km"));
        response.add(new Bus("Liberia","Playa Tamarindo","https://maps.app.goo.gl/JGmthpkpPZeEQoYV8","https://maps.app.goo.gl/6Y6cC6V1ianwyQ6W9","75Km"));
        response.add(new Bus("Liberia","Playa del Coco","https://maps.app.goo.gl/KhzRwpm8ho5FMDUYA","https://maps.app.goo.gl/6Y6cC6V1ianwyQ6W9","35Km"));
        response.add(new Bus("Liberia","Cañas","https://maps.app.goo.gl/KhzRwpm8ho5FMDUYA","https://maps.app.goo.gl/8eokGdHvTL3fhFPf9","48Km"));
        response.add(new Bus("Liberia","Puntarenas","https://maps.app.goo.gl/KhzRwpm8ho5FMDUYA","https://maps.app.goo.gl/NLSf9rY4VnCrHmzUA","133Km"));
        response.add(new Bus("Cañas","Tilaran","https://maps.app.goo.gl/tZPXw13TccjVQKHX8","https://maps.app.goo.gl/5yTPvhAkcuCSMPgu8","21Km"));
        response.add(new Bus("Tilaran","La Fortuna","https://maps.app.goo.gl/rTM5ZgBed9R4k1uj9","https://maps.app.goo.gl/cSZHtPkR2mUpjCkT7","74Km"));
        response.add(new Bus("La Fortuna","San Ramón","https://maps.app.goo.gl/cSZHtPkR2mUpjCkT7","https://maps.app.goo.gl/S9tnGUTm6fRzr2KW8","71Km"));
        response.add(new Bus("San Ramón","San José","https://maps.app.goo.gl/jpX5LKzfJt6HhKPw6","https://maps.app.goo.gl/qReZNkCPtv3AwC3DA","59Km"));
        return response;
    }
}
