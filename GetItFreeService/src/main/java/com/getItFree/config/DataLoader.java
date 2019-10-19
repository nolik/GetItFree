package com.getItFree.config;

import com.getItFree.model.Advert;
import com.getItFree.model.AdvertStatus;
import com.getItFree.model.User;
import com.getItFree.repository.AdvertRepository;
import com.getItFree.repository.UserRepository;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.*;

import static com.getItFree.model.Authority.ROLE_USER;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final UserRepository userRepository;
    private final AdvertRepository advertRepository;


    @Override
    public void run(ApplicationArguments args) {
        List<User> users = Lists.newArrayList();
        users.add(User.builder()
                .username("user")
                .password("pass")
                .email("asd@mail.com")
                .authority(Collections.singletonList(ROLE_USER))
                .build()
        );

        users.add(User.builder()
                .username("user2")
                .password("pass")
                .email("ewq@mail.com")
                .authority(Collections.singletonList(ROLE_USER))
                .build()
        );

        users.forEach(userRepository::save);

        //temporary initialization of db
        List<Advert> adverts = new ArrayList<>();
        adverts.add(Advert.builder()
                .head("пивко")
                .content("забирай добрый люд пивко")
                .date(Calendar.getInstance().getTime())
                .imageUrl("https://thumb9.shutterstock.com/display_pic_with_logo/3521228/391005625/stock-photo-glasses-of-light-and-dark-beer-on-a-pub-background-391005625.jpg")
                .status(AdvertStatus.FREE)
                .giver(users.get(0))
                .build()
        );

        adverts.add(Advert.builder()
                .head("книга")
                .content("читайте это сами")
                .date(Calendar.getInstance().getTime())
                .imageUrl("https://img.labirint.ru/rcimg/c4479c18a3792f2e950a6991966f1728/1920x1080/comments_pic/1507/0_1bdb2b488034b1e5d38d6c277796284b_1423810840.jpg")
                .status(AdvertStatus.FREE)
                .giver(users.get(1))
                .build()

        );
        adverts.add(Advert.builder()
                .head("камод")
                .content("нужен кому камод")
                .date(Calendar.getInstance().getTime())
                .imageUrl("https://images.by.prom.st/97629736_w640_h640_img_20180105_164532.jpg")
                .status(AdvertStatus.FREE)
                .giver(users.get(1))
                .build());

        adverts.forEach(advertRepository::save);


    }
}
