package miniProject.accountBook.controller;

import miniProject.accountBook.domain.Location;
import miniProject.accountBook.dto.LocationDto;
import miniProject.accountBook.dto.LocationInfo;
import miniProject.accountBook.dto.SearchForm;
import miniProject.accountBook.service.MapService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String location(@ModelAttribute @Validated SearchForm searchForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "map/searchLocation";
        }
        if (searchForm.getKeyword().equals("")) {
            bindingResult.reject("searchFail", "키워드를 입력해주세요");
            return "map/searchLocation";
        }
        LocationInfo locationInfo = mapService.getLocation(searchForm.getKeyword());
        model.addAttribute("documents", locationInfo.getDocuments());
        model.addAttribute("locationDto", new LocationDto());
        return "map/searchLocation";
    }

    @PostMapping("/registerLocation")
    public String register(@ModelAttribute @Validated LocationDto locationDto, Model model) {
        Location location = new Location();
        location.setPlaceName(locationDto.getPlaceName());
        location.setPlaceUrl(locationDto.getPlaceUrl());
        location.setRoadAddressName(locationDto.getRoadAddressName());
        location.setX(locationDto.getX());
        location.setY(locationDto.getY());
        location.setDate(locationDto.getDate());
        mapService.store(location);
        model.addAttribute("searchForm", new SearchForm());
        return "map/searchLocation";
    }
}

