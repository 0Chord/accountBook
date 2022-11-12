function makeOverListener(map, marker, infoWindow) {
    return function () {
        infoWindow.open(map, marker);
    };
}