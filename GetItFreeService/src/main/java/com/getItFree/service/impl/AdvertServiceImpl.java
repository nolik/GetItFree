package com.getItFree.service.impl;

import com.getItFree.model.Advert;
import com.getItFree.repository.AdvertRepository;
import com.getItFree.service.AdvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvertServiceImpl implements AdvertService {

    private final AdvertRepository advertRepository;

    //temporary initialization of db
    private static List<Advert> adverts = new ArrayList<>();

//    static {
//        adverts.add(new Advert(1, "пивко", "забирай добрый люд пивко", Calendar.getInstance().getTime(),
//                "https://thumb9.shutterstock.com/display_pic_with_logo/3521228/391005625/stock-photo-glasses-of-light-and-dark-beer-on-a-pub-background-391005625.jpg", false));
//        adverts.add(new Advert(2, "пивко2", "забирай добрый люд пивко", Calendar.getInstance().getTime(),
//                "https://thumb9.shutterstock.com/display_pic_with_logo/3521228/391005625/stock-photo-glasses-of-light-and-dark-beer-on-a-pub-background-391005625.jpg", false));
//        adverts.add(new Advert(3, "пивко3", "забирай добрый люд пивко", Calendar.getInstance().getTime(),
//                "https://thumb9.shutterstock.com/display_pic_with_logo/3521228/391005625/stock-photo-glasses-of-light-and-dark-beer-on-a-pub-background-391005625.jpg", false));
//    }

    @PostConstruct
    public void init(){
        advertRepository.saveAll(adverts);
    }


    public List<Advert> findAllAdvertsFromDB(){
        List<Advert> repositoryAll=  advertRepository.findAll();
        return repositoryAll;
    }

    public Advert addNewAdvert(Advert advert){
        return advertRepository.save(advert);
    }
}
