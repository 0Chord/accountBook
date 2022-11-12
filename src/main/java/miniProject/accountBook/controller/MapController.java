package miniProject.accountBook.controller;

import miniProject.accountBook.dto.SearchForm;
import miniProject.accountBook.service.MapService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/map")
public class MapController {

    MapService mapService;

    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @GetMapping("/view")
    public String view() {
        return "map/mapView";
    }

    @GetMapping("/searchLocation")
    public String search(@ModelAttribute SearchForm searchForm) {

        return "map/searchLocation";
    }

    @PostMapping("/searchLocation")
    public String location(@ModelAttribute @Validated SearchForm searchForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "map/searchLocation";
        }
        System.out.println("searchForm.getKeyword() = " + searchForm.getKeyword());
        if(searchForm.getKeyword() == ""){
            bindingResult.reject("searchFail","키워드를 입력해주세요");
            return "map/searchLocation";
        }
        mapService.getLocation(searchForm.getKeyword());
        return "map/searchLocation";
    }
}

