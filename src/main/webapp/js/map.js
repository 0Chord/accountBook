function keywordSearch(map) {
    let keyword = document.getElementById("keyword").value;

    let infoWindow = new kakao.maps.infoWindow({zIndex: 1});

    let ps = new kakao.maps.services.Places(map);

    let searchOption = {
        location: currentPos,
        radius: 1000,
        size: 5
    };

    ps.keywordSearch(keyword, placesSearchDB, searchOption);
}

function placesSearchDB(data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {

        displayPlacesView(data);
    } else if (status === kakao.maps.services.Status.ZERO_RESULT) {
        alert("검색 결과가 존재하지 않습니다.");
        return;
    } else if (status === kakao.maps.services.Status.ERROR) {
        alert('검색 결과 중 오류가 발생했습니다.');
        return;
    }
}

function displayMarker(place) {
    let marker = new kakao.maps.Marker({
        map: map,
        position: new kakao.maps.LatLng(place.y, place.x)
    });
}

function makeOverListener(map, marker, infoWindow) {
    return function () {
        infoWindow.open(map, marker);
    };
}