var yearSlider = document.getElementById('yearSlider')
var yearMinLabel = document.getElementById('yearMinLabel')
var yearMaxLabel = document.getElementById('yearMaxLabel')
var minRating = document.getElementById('minRatingInput')

// fetch("http://localhost:8080/js/catalog.js")
//     .then((response) => { return response.text() })
//     .then((text) => { console.log(text) })

// fetch("http://localhost:8080/js/catalog.js")
//     .then((response) => {
//         response.text()
//         .then((text) => { console.log(text) })
//     })

noUiSlider.create(yearSlider, {
    start: [1920, 2030],

    range: {
        'min': [1920],
        'max': [2030]
    },

    connect: true
});

function findByFilters() {
    let filters = document.getElementById("genres_list")

    let genres_checkbox = filters.getElementsByClassName("form-check-input")
    let genres_data = []

    for (let i = 0; i < genres_checkbox.length; i++) {
        if (genres_checkbox[i].checked) {
            genres_data.push(genres_checkbox[i].value)
        }
    }

    var data = {
        genres: genres_data,
        //minimumRating: 2,
        //sort_by: ""
        yearfrom: parseInt(yearMinLabel.innerHTML),
        yearmax: parseInt(yearMaxLabel.innerHTML),
        minRating: parseInt(minRating.value)
    }

    //console.log(data)

    let promise = fetch("http://localhost:8080/filter", {
        method: "POST", // POST, PUT, DELETE, etc.
        headers: {
            // значение этого заголовка обычно ставится автоматически,
            // в зависимости от тела запроса
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data), // string, FormData, Blob, BufferSource или URLSearchParams
        referrer: "about:client", // или "" для того, чтобы не послать заголовок Referer,
        // или URL с текущего источника
        referrerPolicy: "strict-origin-when-cross-origin", // no-referrer-when-downgrade, no-referrer, origin, same-origin...
        mode: "cors", // same-origin, no-cors
        credentials: "same-origin", // omit, include
        cache: "default", // no-store, reload, no-cache, force-cache или only-if-cached
        redirect: "follow", // manual, error
        integrity: "", // контрольная сумма, например "sha256-abcdef1234567890"
        keepalive: false, // true
        signal: undefined, // AbortController, чтобы прервать запрос
        window: window // null
    });
    promise.then((responce) => {
        return responce.text()
    }).then((text) => {
        var parser = new DOMParser()
        var container = parser.parseFromString(text, "text/html");
        var x = container.getElementById("films-grid");
        var currentGrid = document.getElementById("films-grid");
        currentGrid.innerHTML = x.innerHTML;
    })
}

function changeYearLabel(values, handle, unencoded, tap, positions, noUiSlider) {
    // values: Current slider values (array);
    // handle: Handle that caused the event (number);
    // unencoded: Slider values without formatting (array);
    // tap: Event was caused by the user tapping the slider (boolean);
    // positions: Left offset of the handles (array);
    // noUiSlider: slider public Api (noUiSlider);
    yearMinLabel.innerHTML = parseInt(values[0]);
    yearMaxLabel.innerHTML = parseInt(values[1]);
    // console.log(values[1])
}
// Binding signature
yearSlider.noUiSlider.on("update", changeYearLabel);