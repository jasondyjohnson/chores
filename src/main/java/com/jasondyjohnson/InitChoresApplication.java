package com.jasondyjohnson;

import com.jasondyjohnson.domain.ChoreReward;
import com.jasondyjohnson.domain.Person;
import com.jasondyjohnson.repository.ChoreRewardRepository;
import com.jasondyjohnson.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Jason on 3/4/2016.
 */
@Slf4j
public class InitChoresApplication {

    public static void devInitDatabase(PersonRepository personRepository, ChoreRewardRepository choreRepository) {
        if (personRepository.count() > 0) {
            return;
        }
        Person person1 = new Person("person1", "", "person1", "person1", "",
                "");
        personRepository.save(person1);
        Person person2 = new Person("person2", "", "person2",  "person2", "",
                "");
        personRepository.save(person2);
        personRepository.save(new Person("person3", "", "person3", "person3", "",
                ""));
        ChoreReward dishwasher = new ChoreReward("Dishwasher", 1);
        choreRepository.save(dishwasher);
        ChoreReward extraHomework = new ChoreReward("Extra homework", 1);
        choreRepository.save(extraHomework);
        choreRepository.save(new ChoreReward("Garbage", 1));
        choreRepository.save(new ChoreReward("Groceries", 1));
        choreRepository.save(new ChoreReward("Laundry", 1));
        ChoreReward cleanRoom = new ChoreReward("Clean a room", 2);
        choreRepository.save(cleanRoom);
        ChoreReward setTable = new ChoreReward("Set table", 1);
        choreRepository.save(setTable);
        ChoreReward sweep = new ChoreReward("Sweep floor", 2);
        choreRepository.save(sweep);
        choreRepository.save(new ChoreReward("Yard work", 2));
        choreRepository.save(new ChoreReward("Help at soccer", 1));
        ChoreReward miniPokemon = new ChoreReward("Small Pokemon Pack", -2);
        ChoreReward texturePack = new ChoreReward("Minecraft Texture Pack", -2);
        ChoreReward skinPack = new ChoreReward("Minecraft Skin Pack", -4);
        ChoreReward mashupPack = new ChoreReward("Minecraft Mashup Pack", -8);
        choreRepository.save(miniPokemon);

            /* Init Leander Chores */
        Calendar.Builder builder = new Calendar.Builder().setCalendarType("iso8601");
        Date tempDate = builder
                .setFields(Calendar.YEAR, 2015)
                .setFields(Calendar.MONTH, Calendar.DECEMBER)
                .setFields(Calendar.DAY_OF_MONTH, 5)
                .build().getTime();
        person1.addChoreReward(cleanRoom, tempDate);

        tempDate = builder
                .setFields(Calendar.YEAR, 2016)
                .setFields(Calendar.MONTH, Calendar.JANUARY)
                .setFields(Calendar.DAY_OF_MONTH, 9)
                .build().getTime();
        person1.addChoreReward(sweep, tempDate);
        person1.addChoreReward(dishwasher, tempDate);
        person1.addChoreReward(setTable, tempDate);

        tempDate = builder
                .setFields(Calendar.MONTH, Calendar.FEBRUARY)
                .setFields(Calendar.DAY_OF_MONTH, 1)
                .build().getTime();
        person1.addChoreReward(cleanRoom, tempDate);

        tempDate = builder
                .setFields(Calendar.DAY_OF_MONTH, 6)
                .build().getTime();
        person1.addChoreReward(cleanRoom, tempDate);

        tempDate = builder
                .setFields(Calendar.DAY_OF_MONTH, 7)
                .build().getTime();
        person1.addChoreReward(dishwasher, tempDate);
        person1.addChoreReward(dishwasher, tempDate);

        tempDate = builder
                .setFields(Calendar.DAY_OF_MONTH, 11)
                .build().getTime();
        person1.addChoreReward(cleanRoom, tempDate);

        tempDate = builder
                .setFields(Calendar.DAY_OF_MONTH, 13)
                .build().getTime();
        person1.addChoreReward(cleanRoom, tempDate);

        tempDate = builder.setFields(Calendar.DAY_OF_MONTH, 27)
                .build().getTime();
        person1.addChoreReward(extraHomework, tempDate);

        tempDate = builder.setFields(Calendar.DAY_OF_MONTH, 28)
                .build().getTime();
        person1.addChoreReward(dishwasher, tempDate);

        tempDate = builder
                .setFields(Calendar.MONTH, Calendar.MARCH)
                .setFields(Calendar.DAY_OF_MONTH, 3)
                .build().getTime();
        person1.addChoreReward(cleanRoom, tempDate);

        tempDate = builder
                .setFields(Calendar.DAY_OF_MONTH, 6)
                .build().getTime();
        person1.addChoreReward(dishwasher, tempDate);

        tempDate = builder
                .setFields(Calendar.DAY_OF_MONTH, 7)
                .build().getTime();
        person1.addChoreReward(cleanRoom, tempDate);

        tempDate = builder
                .setFields(Calendar.DAY_OF_MONTH, 8)
                .build().getTime();
        person1.addChoreReward(dishwasher, tempDate);

        personRepository.save(person1);

            /* Init Garrett Chores */
        tempDate = builder
                .setFields(Calendar.MONTH, Calendar.JANUARY)
                .setFields(Calendar.DAY_OF_MONTH, 1)
                .build().getTime();

        person2.addChoreReward(dishwasher, tempDate);

        tempDate = builder
                .setFields(Calendar.DAY_OF_MONTH, 9)
                .build().getTime();
        person2.addChoreReward(sweep, tempDate);
        person2.addChoreReward(dishwasher, tempDate);
        person2.addChoreReward(setTable, tempDate);
        person2.addChoreReward(miniPokemon, tempDate);
        person2.addChoreReward(miniPokemon, tempDate);

        tempDate = builder
                .setFields(Calendar.DAY_OF_MONTH, 12)
                .build().getTime();
        person2.addChoreReward(sweep, tempDate);
        person2.addChoreReward(miniPokemon, tempDate);

        tempDate = builder
                .setFields(Calendar.DAY_OF_MONTH, 17)
                .build().getTime();
        person2.addChoreReward(cleanRoom, tempDate);
        person2.addChoreReward(dishwasher, tempDate);
        person2.addChoreReward(setTable, tempDate);
        person2.addChoreReward(miniPokemon, tempDate);
        person2.addChoreReward(miniPokemon, tempDate);

        tempDate = builder
                .setFields(Calendar.MONTH, Calendar.FEBRUARY)
                .setFields(Calendar.DAY_OF_MONTH, 6)
                .build().getTime();
        person2.addChoreReward(cleanRoom, tempDate);
        person2.addChoreReward(dishwasher, tempDate);
        person2.addChoreReward(miniPokemon, tempDate);
        person2.addChoreReward(miniPokemon, tempDate);

        tempDate = builder
                .setFields(Calendar.DAY_OF_MONTH, 11)
                .build().getTime();
        person2.addChoreReward(cleanRoom, tempDate);
        person2.addChoreReward(miniPokemon, tempDate);

        tempDate = builder.setFields(Calendar.DAY_OF_MONTH, 13)
                .build().getTime();
        person2.addChoreReward(cleanRoom, tempDate);
        person2.addChoreReward(miniPokemon, tempDate);

        tempDate = builder.setFields(Calendar.DAY_OF_MONTH, 17)
                .build().getTime();
        person2.addChoreReward(cleanRoom, tempDate);
        person2.addChoreReward(miniPokemon, tempDate);


        tempDate = builder.setFields(Calendar.DAY_OF_MONTH, 27)
                .build().getTime();
        person2.addChoreReward(extraHomework, tempDate);

        tempDate = builder.setFields(Calendar.DAY_OF_MONTH, 28)
                .build().getTime();
        person2.addChoreReward(dishwasher, tempDate);
        person2.addChoreReward(miniPokemon, tempDate);

        tempDate = builder
                .setFields(Calendar.MONTH, Calendar.MARCH)
                .setFields(Calendar.DAY_OF_MONTH, 6)
                .build().getTime();
        person2.addChoreReward(dishwasher, tempDate);

        tempDate = builder
                .setFields(Calendar.DAY_OF_MONTH, 7)
                .build().getTime();
        person2.addChoreReward(cleanRoom, tempDate);

        person2.addChoreReward(miniPokemon, tempDate);

        personRepository.save(person2);

        for (Person person : personRepository.findAll()) {
            log.info(person.getLoginName());
        }
        for (ChoreReward choreReward : choreRepository.findAll()) {
            log.info(choreReward.getName());
        }
    }
}
