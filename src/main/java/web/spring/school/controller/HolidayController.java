package web.spring.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.spring.school.model.Holiday;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidayController {

    @GetMapping("/holidays")
    public String displayHolidays(Model model){
        List<Holiday> holidays = Arrays.asList(
                new Holiday(" Jan 1-2 ", "New Year's Day", Holiday.Type.FESTIVAL),
                new Holiday(" Feb 10 ", "Chinese New Year", Holiday.Type.FEDERAL),
                new Holiday(" Feb 26 ", "Makha Bucha Day", Holiday.Type.FEDERAL),
                new Holiday(" Apr 8 ", "Chakri Memorial Day", Holiday.Type.FEDERAL),
                new Holiday(" Apr 13-16 ", "Songkran Festival", Holiday.Type.FESTIVAL),
                new Holiday(" May 1 ", "Labor Day", Holiday.Type.FEDERAL)
        );
        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types){
            model.addAttribute(type.toString(), holidays.stream().filter((holiday -> holiday.getType().equals(type))).collect(Collectors.toList()));
        }
        return "holidays.html";
    }
}
