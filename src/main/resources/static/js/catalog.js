function findByFilters(){
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
    }

    console.log(data)
}